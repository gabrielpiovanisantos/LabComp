
package comp;

import ast.*;
import jdk.nashorn.internal.runtime.Undefined;
import lexer.*;
import java.io.*;
import java.util.*;

public class Compiler {

	private MethodDec currentMethod;
	private KraClass currentClass;
	private int countWhile = 0;

	// compile must receive an input with an character less than
	// p_input.lenght
	public Program compile(char[] input, PrintWriter outError) {

		ArrayList<CompilationError> compilationErrorList = new ArrayList<>();
		signalError = new ErrorSignaller(outError, compilationErrorList);
		symbolTable = new SymbolTable();
		lexer = new Lexer(input, signalError);
		signalError.setLexer(lexer);

		Program program = null;
		lexer.nextToken();
		program = program(compilationErrorList);
		return program;
	}

	private Program program(ArrayList<CompilationError> compilationErrorList) {
		// Program ::= KraClass { KraClass }
		ArrayList<MetaobjectCall> metaobjectCallList = new ArrayList<>();
		ArrayList<KraClass> kraClassList = new ArrayList<>();
		Program program = new Program(kraClassList, metaobjectCallList, compilationErrorList);
		try {
			while (lexer.token == Symbol.MOCall) {
				metaobjectCallList.add(metaobjectCall());
			}
			kraClassList.add(classDec());
			while (lexer.token == Symbol.CLASS)
				kraClassList.add(classDec());
			boolean progFlag = false;
			for (KraClass k : kraClassList) {
				if (k.getName().equals("Program")) {
					progFlag = true;
					break;
				}
			}
			if (!progFlag)
				signalError.showError("Source code without a class 'Program'");
			if (lexer.token != Symbol.EOF) {
				signalError.showError("End of file expected");
			}
		} catch (CompilerError e) {
			// if there was an exception, there is a compilation signalError
		} catch (RuntimeException e) {
			 e.printStackTrace();
		}
		return program;
	}

	/**
	 * parses a metaobject call as <code>{@literal @}ce(...)</code> in <br>
	 * <code>
	 * &#64;ce(5, "'class' expected") <br>
	 * clas Program <br>
	 *     public void run() { } <br>
	 * end <br>
	 * </code>
	 * 
	 * 
	 */
	@SuppressWarnings("incomplete-switch")
	private MetaobjectCall metaobjectCall() {
		String name = lexer.getMetaobjectName();
		lexer.nextToken();
		ArrayList<Object> metaobjectParamList = new ArrayList<>();
		if (lexer.token == Symbol.LEFTPAR) {
			// metaobject call with parameters
			lexer.nextToken();
			while (lexer.token == Symbol.LITERALINT || lexer.token == Symbol.LITERALSTRING
					|| lexer.token == Symbol.IDENT) {
				switch (lexer.token) {
				case LITERALINT:
					metaobjectParamList.add(lexer.getNumberValue());
					break;
				case LITERALSTRING:
					metaobjectParamList.add(lexer.getLiteralStringValue());
					break;
				case IDENT:
					metaobjectParamList.add(lexer.getStringValue());
				}
				lexer.nextToken();
				if (lexer.token == Symbol.COMMA)
					lexer.nextToken();
				else
					break;
			}
			if (lexer.token != Symbol.RIGHTPAR)
				signalError.showError("')' expected after metaobject call with parameters");
			else
				lexer.nextToken();
		}
		if (name.equals("nce")) {
			if (metaobjectParamList.size() != 0)
				signalError.showError("Metaobject 'nce' does not take parameters");
		} else if (name.equals("ce")) {
			if (metaobjectParamList.size() != 3 && metaobjectParamList.size() != 4)
				signalError.showError("Metaobject 'ce' take three or four parameters");
			if (!(metaobjectParamList.get(0) instanceof Integer))
				signalError.showError("The first parameter of metaobject 'ce' should be an integer number");
			if (!(metaobjectParamList.get(1) instanceof String) || !(metaobjectParamList.get(2) instanceof String))
				signalError.showError("The second and third parameters of metaobject 'ce' should be literal strings");
			if (metaobjectParamList.size() >= 4 && !(metaobjectParamList.get(3) instanceof String))
				signalError.showError("The fourth parameter of metaobject 'ce' should be a literal string");

		}

		return new MetaobjectCall(name, metaobjectParamList);
	}

	private KraClass classDec() {
		// Note que os m�todos desta classe n�o correspondem exatamente �s
		// regras
		// da gram�tica. Este m�todo classDec, por exemplo, implementa
		// a produ��o KraClass (veja abaixo) e partes de outras produ��es.

		/*
		 * KraClass ::= ``class'' Id [ ``extends'' Id ] "{" MemberList "}" MemberList
		 * ::= { Qualifier Member } Member ::= InstVarDec | MethodDec InstVarDec ::=
		 * Type IdList ";" MethodDec ::= Qualifier Type Id "("[ FormalParamDec ] ")" "{"
		 * StatementList "}" Qualifier ::= [ "static" ] ( "private" | "public" )
		 */
		String superclassName = null;
		ArrayList<MethodDec> methodList = new ArrayList<>();
		ArrayList<InstanceVarDec> varList = new ArrayList<>();
		if (lexer.token != Symbol.CLASS)
			signalError.showError("'class' expected");
		lexer.nextToken();
		if (lexer.token != Symbol.IDENT)
			signalError.show(ErrorSignaller.ident_expected);
		String className = lexer.getStringValue();
		if (symbolTable.getInGlobal(className) != null)
			signalError.showError("class alreaby been declared");
		this.currentClass = new KraClass(className);
		symbolTable.putInGlobal(className, this.currentClass);
		lexer.nextToken();
		if (lexer.token == Symbol.EXTENDS) {
			lexer.nextToken();
			if (lexer.token != Symbol.IDENT)
				signalError.show(ErrorSignaller.ident_expected);
			superclassName = lexer.getStringValue();
			if (symbolTable.getInGlobal(superclassName) == null)
				signalError.showError("superclass have not been declared");
			if (className.compareToIgnoreCase(superclassName) == 0)
				signalError.showError("class" + className + "is inheriting from itself");
			this.currentClass.setSuperclass(symbolTable.getInGlobal(superclassName));
			lexer.nextToken();
		}
		if (lexer.token != Symbol.LEFTCURBRACKET)
			signalError.showError("{ expected", true);
		lexer.nextToken();

		while (lexer.token == Symbol.PRIVATE || lexer.token == Symbol.PUBLIC) {

			Symbol qualifier;
			switch (lexer.token) {
			case PRIVATE:
				lexer.nextToken();
				qualifier = Symbol.PRIVATE;
				break;
			case PUBLIC:
				lexer.nextToken();
				qualifier = Symbol.PUBLIC;
				break;
			default:
				signalError.showError("private, or public expected");
				qualifier = Symbol.PUBLIC;
			}
			Type t = type();

			if (lexer.token != Symbol.IDENT)
				signalError.showError("Identifier expected");
			String name = lexer.getStringValue();
			lexer.nextToken();
			if (lexer.token == Symbol.LEFTPAR) {
				if (className.equals("Program") && qualifier.toString().equals("private") && name.equals("run"))
					signalError.showError("Method 'run' of class 'Program' cannot be private");
				methodDec(t, name, qualifier);
			} else if (qualifier != Symbol.PRIVATE)
				signalError.showError("Attempt to declare a public instance variable");
			else
				instanceVarDec(t, name);
		}
		if (lexer.token != Symbol.RIGHTCURBRACKET)
			signalError.showError("'public', 'private' or '}' expected");
		if (this.currentClass.getName().equals("Program")) {
			boolean runFlag = false;
			for (MethodDec m : this.currentClass.getPublicMethodList()) {
				if (m.getName().equals("run")) {
					runFlag = true;
					break;
				}
			}
			if (!runFlag)
				signalError.showError("method 'run' was not found in class 'Program'");
		}
		lexer.nextToken();

		return this.currentClass;

	}

	private void instanceVarDec(Type type, String name) {
		// InstVarDec ::= [ "static" ] "private" Type IdList ";"

		InstanceVariable var = new InstanceVariable(name, type);
		if (this.currentClass.searchVariable(name) != null)
			signalError.showError("variable has already been declared");
		this.currentClass.addInstanceVariable(var);

		while (lexer.token == Symbol.COMMA) {
			lexer.nextToken();
			if (lexer.token != Symbol.IDENT)
				signalError.showError("Identifier expected");
			var = new InstanceVariable(lexer.getStringValue(), type);
			if (this.currentClass.searchVariable(var.getName()) != null)
				signalError.showError("variable has already been declared");
			this.currentClass.addInstanceVariable(var);
			lexer.nextToken();
		}

		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
	}

	private void methodDec(Type type, String name, Symbol qualifier) {
		/*
		 * MethodDec ::= Qualifier Return Id "("[ FormalParamDec ] ")" "{" StatementList
		 * "}"
		 */
		this.currentMethod = new MethodDec(type, name, qualifier);
		KraClass superclass = this.currentClass.getSuperclass();
		ArrayList<MethodDec> publicMethodList = this.currentClass.getPublicMethodList();
		ArrayList<MethodDec> privateMethodList = this.currentClass.getPrivateMethodList();
		for (int i = 0; i < publicMethodList.size(); i++) {
			if (publicMethodList.get(i).getName().equals(name)) {
				signalError.showError("Method '" + this.currentMethod.getName() + "' is being redeclared");
				break;
			}
		}
		for (int i = 0; i < privateMethodList.size(); i++) {
			if (privateMethodList.get(i).getName().equals(name)) {
				signalError.showError("Method '" + this.currentMethod.getName() + "' is being redeclared");
				break;
			}
		}

		if (this.currentClass.searchVariable(this.currentMethod.getName()) != null)
			signalError
					.showError("Method '" + this.currentMethod.getName() + "' has name equal to an instance variable");
		lexer.nextToken();
		if (lexer.token != Symbol.RIGHTPAR)
			this.currentMethod.param = formalParamDec();
		int i;
		if (superclass != null) {
			i = 0;
			ArrayList<MethodDec> superClasspublicMethodList = superclass.getPublicMethodList();
			while (i < superClasspublicMethodList.size()) {
				if (superClasspublicMethodList.get(i).getName().equals(name)) {
					// String namme = superClasspublicMethodList.get(i).getName();

					// if(!superClasspublicMethodList.get(i).getParam().equals(this.currentMethod.param)){
					// signalError.showError("Method '"+name+"' is being redefined in subclass
					// '"+this.currentClass.getName()+"' with a signature different from the method
					// of superclass '"+this.currentClass.getSuperclass().getName()+"'");
					// break;
					// }

					if (!superClasspublicMethodList.get(i).getReturnType().equals(type)
							&& superClasspublicMethodList.get(i).getQualifier().equals(qualifier)) {
						signalError.showError("Method '" + superClasspublicMethodList.get(i).getName()
								+ "' of subclass '" + this.currentClass.getName()
								+ "' has a signature different from method inherited from superclass '"
								+ superclass.getName() + "'");
						break;
					}
				}
				i++;
			}
		}

		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		if (this.currentClass.getName().equals("Program") && this.currentMethod.getName().equals("run")
				&& this.currentMethod.param != null)
			signalError.showError("method run can not take parameters");
		if (this.currentClass.getName().equals("Program") && this.currentMethod.getName().equals("run")
				&& this.currentMethod.getReturnType() != Type.voidType)
			signalError.showError("Method '" + this.currentMethod.getName() + "' of class '"
					+ this.currentClass.getName() + "' with a return value type different from 'void'");

		lexer.nextToken();
		if (lexer.token != Symbol.LEFTCURBRACKET)
			signalError.showError("{ expected");

		lexer.nextToken();
		this.currentMethod.stmtList = statementList();
		if (this.currentMethod.getReturnType().getName().compareToIgnoreCase("void") != 0) {
			boolean retflag = false;
			IfStatement ifstmt;
			for (Statement m : this.currentMethod.stmtList.getStmtlist()) {
				if (m.getClass() == ReturnStatement.class) {
					retflag = true;
					break;
				} else if (m.getClass() == IfStatement.class) {
					ifstmt = (IfStatement) m;	
					if(ifstmt.stmt != null){
						if (ifstmt.stmt.getClass() == ReturnStatement.class) {
							retflag = true;
							break;
						} else if (ifstmt.elseStmt.getClass() == ReturnStatement.class) {
							retflag = true;
							break;
						}
					}
				}
			}
			if (!retflag)
				signalError.showError("a non void method must have a return statement");
		}
		if (lexer.token != Symbol.RIGHTCURBRACKET)
			signalError.showError("} expected");

		lexer.nextToken();
		if (qualifier == Symbol.PRIVATE)
			this.currentClass.addPrivateMethod(this.currentMethod);
		if (qualifier == Symbol.PUBLIC)
			this.currentClass.addPublicMethod(this.currentMethod);
		this.symbolTable.removeLocalIdent();

		this.currentMethod = null;
	}

	private LocalDec localDec() {
		// LocalDec ::= Type IdList ";"

		ArrayList<Variable> arrayVar = new ArrayList<>();
		Type type = type();
		if (lexer.token != Symbol.IDENT)
			signalError.showError("Identifier expected");
		Variable v = new Variable(lexer.getStringValue(), type);
		if (this.symbolTable.getInLocal(v.getName()) != null)
			signalError.showError("variable has already been declared");
		arrayVar.add(v);
		this.symbolTable.putInLocal(v.getName(), v);
		lexer.nextToken();
		while (lexer.token == Symbol.COMMA) {
			lexer.nextToken();
			if (lexer.token != Symbol.IDENT)
				signalError.showError("Identifier expected");
			v = new Variable(lexer.getStringValue(), type);
			if (symbolTable.getInLocal(v.getName()) != null)
				signalError.showError("variable has already been declared");
			this.symbolTable.putInLocal(v.getName(), v);
			arrayVar.add(v);
			lexer.nextToken();
		}
		if (lexer.token != Symbol.SEMICOLON) {
			if (lexer.getLineNumberBeforeLastToken() != lexer.getLineNumber()) {
				lexer.setLineNumber(lexer.getLineNumber() - 1);
				this.signalError.showError("semicolon expected");
				lexer.setLineNumber(lexer.getLineNumber() + 1);
			} else
				this.signalError.showError("semicolon expected");
		}
		return new LocalDec(arrayVar, type);
	}

	private FormalParamDec formalParamDec() {
		// FormalParamDec ::= ParamDec { "," ParamDec }
		ArrayList<ParamDec> params = new ArrayList<>();
		params.add(paramDec());
		while (lexer.token == Symbol.COMMA) {
			lexer.nextToken();
			params.add(paramDec());
		}
		return new FormalParamDec(params);
	}

	private ParamDec paramDec() {
		// ParamDec ::= Type Id

		Type type = type();
		if (lexer.token != Symbol.IDENT)
			signalError.showError("Identifier expected");
		ParamDec p = new ParamDec(lexer.getStringValue(), type);
		this.symbolTable.putInLocal(p.getName(), p);
		lexer.nextToken();
		return p;
	}

	private Type type() {
		// Type ::= BasicType | Id
		Type result;

		switch (lexer.token) {
		case VOID:
			result = Type.voidType;
			break;
		case INT:
			result = Type.intType;
			break;
		case BOOLEAN:
			result = Type.booleanType;
			break;
		case STRING:
			result = Type.stringType;
			break;
		case IDENT:
			// # corrija: fa�a uma busca na TS para buscar a classe
			// IDENT deve ser uma classe.
			String className = lexer.getStringValue();
			KraClass classident = this.symbolTable.getInGlobal(className);
			if (classident == null) {
				signalError.showError("This class does not exists");
				result = Type.undefinedType;
			} else
				result = classident;
			break;
		default:
			signalError.showError("Type expected");
			result = Type.undefinedType;
		}
		lexer.nextToken();
		return result;
	}

	private CompositeStatement compositeStatement() {

		lexer.nextToken();
		CompositeStatement comp = new CompositeStatement();
		comp.stmlist = statementList();
		if (lexer.token != Symbol.RIGHTCURBRACKET)
			signalError.showError("} expected");
		else
			lexer.nextToken();
		return null;
	}

	private StatementList statementList() {
		// CompStatement ::= "{" { Statement } "}"
		Symbol tk;
		ArrayList<Statement> stmtList = new ArrayList<>();
		// statements always begin with an identifier, if, read, write, ...
		while ((tk = lexer.token) != Symbol.RIGHTCURBRACKET && tk != Symbol.ELSE)
			stmtList.add(statement());
		return new StatementList(stmtList);
	}

	private Statement statement() {
		/*
		 * Statement ::= Assignment ``;'' | IfStat |WhileStat | MessageSend ``;'' |
		 * ReturnStat ``;'' | ReadStat ``;'' | WriteStat ``;'' | ``break'' ``;'' | ``;''
		 * | CompStatement | LocalDec
		 */
		switch (lexer.token) {
		case THIS:
		case IDENT:
		case SUPER:
		case INT:
		case BOOLEAN:
		case STRING:
			return assignExprLocalDec();			
		case ASSERT:
			return assertStatement();
		case RETURN:
			return  returnStatement();
		case READ:
			return readStatement();
		case WRITE:
			return writeStatement();
		case WRITELN:
			return writelnStatement();
		case IF:
			return ifStatement();
		case BREAK:
			if (countWhile == 0)
				signalError.showError("'break' statement found outside a 'while' statement");
			else
				countWhile--;
			return breakStatement();
		case WHILE:
			return whileStatement();
		case SEMICOLON:
			return nullStatement();
		case LEFTCURBRACKET:
			return compositeStatement();
		case DO:
			return dowhileStatement();
		default:
			signalError.showError("Statement expected");
			break;
		}
		return null;
	}

	private Statement dowhileStatement() {
		lexer.nextToken();
		if (lexer.token != Symbol.LEFTCURBRACKET)
			this.signalError.showError(" { expected");
		lexer.nextToken();
		StatementList comp = statementList();
		if (lexer.token != Symbol.RIGHTCURBRACKET)
			this.signalError.showError(" } expected");

		lexer.nextToken();
		if (lexer.token != Symbol.WHILE) {
			if (lexer.getLineNumberBeforeLastToken() != lexer.getLineNumber()) {
				lexer.setLineNumber(lexer.getLineNumber() - 1);
				this.signalError.showError("'while' expected");
				lexer.setLineNumber(lexer.getLineNumber() + 1);
			} else
				this.signalError.showError("'while' expected");
		}

		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			this.signalError.showError("'(' expected");
		lexer.nextToken();
		Expr expr = expr();
		if (expr.getType() != Type.booleanType)
			this.signalError.showError(" boolean expression expected");
		if (lexer.token != Symbol.RIGHTPAR)
			this.signalError.showError("')' expected");
		lexer.nextToken();
		if (lexer.token != Symbol.SEMICOLON)
			this.signalError.showError("';' expected");
		return new DoWhileStatement(comp, expr);
	}

	private Statement assertStatement() {
		lexer.nextToken();
		int lineNumber = lexer.getLineNumber();
		Expr e = expr();
		if (e.getType() != Type.booleanType)
			signalError.showError("boolean expression expected");
		if (lexer.token != Symbol.COMMA) {
			this.signalError.showError("',' expected after the expression of the 'assert' statement");
		}
		lexer.nextToken();
		if (lexer.token != Symbol.LITERALSTRING) {
			this.signalError.showError("A literal string expected after the ',' of the 'assert' statement");
		}
		String message = lexer.getLiteralStringValue();
		lexer.nextToken();
		if (lexer.token == Symbol.SEMICOLON)
			lexer.nextToken();
		else
			signalError.showError("; expected");

		return new StatementAssert(e, lineNumber, message);
	}

	/*
	 * retorne true se 'name' � uma classe declarada anteriormente. � necess�rio
	 * fazer uma busca na tabela de s�mbolos para isto.
	 */
	private boolean isType(String name) {
		return this.symbolTable.getInGlobal(name) != null;
	}

	/*
	 * AssignExprLocalDec ::= Expression [ ``$=$'' Expression ] | LocalDec
	 */
	private AssignExprLocalDec assignExprLocalDec() {

		AssignExprLocalDec a = new AssignExprLocalDec();
		Expr left = null, right = null;
		if (lexer.token == Symbol.INT || lexer.token == Symbol.BOOLEAN || lexer.token == Symbol.STRING ||
		// token � uma classe declarada textualmente antes desta
		// instru��o
				(lexer.token == Symbol.IDENT && isType(lexer.getStringValue()))) {
			/*
			 * uma declara��o de vari�vel. 'lexer.token' � o tipo da vari�vel
			 * 
			 * AssignExprLocalDec ::= Expression [ ``$=$'' Expression ] | LocalDec LocalDec
			 * ::= Type IdList ``;''
			 */
			a.localDec = localDec();
		} else {
			/*
			 * AssignExprLocalDec ::= Expression [ ``$=$'' Expression ]
			 */
			left = expr();
			if (lexer.token == Symbol.ASSIGN) {
				lexer.nextToken();
				right = expr();
				Type r = right.getType();
				Type l = left.getType();

				if (r == Type.undefinedType) {
					if (l.isDefaultType())
						signalError.showError("Expressions of diferents types");
				} else if (r != null){
					if(!r.isCompatible(l))
						signalError.showError("Expressions of diferents types");
				}
					
				if (lexer.token != Symbol.SEMICOLON)
					signalError.showError("';' expected", true);

			} else if (lexer.token == Symbol.SEMICOLON) {
				if (left instanceof VarMethodExpr) {
					VarMethodExpr expr = (VarMethodExpr) left;
					if (expr.getType() != Type.voidType)
						signalError.showError("Message send '" + expr.getFirstId() + "." + expr.getId()
								+ "()' returns a value that is not used");
				}
			}
		}
		a.left = left;
		a.right = right;
		return a;
	}

	private ExprList realParameters() {
		ExprList anExprList = null;

		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		if (startExpr(lexer.token))
			anExprList = exprList();
		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		return anExprList;
	}

	private WhileStatement whileStatement() {

		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		Expr expr = expr();
		if (expr.getType() != Type.booleanType)
			signalError.showError("boolean expression expected");
		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		countWhile++;
		Statement stmt;
		if(lexer.token == Symbol.LEFTCURBRACKET){
			lexer.nextToken();
			stmt = statementList();
			lexer.nextToken();
		}
		else
			stmt = statement();
		return new WhileStatement(expr, stmt);
	}

	private IfStatement ifStatement() {

		IfStatement ifStmt = new IfStatement();
		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		ifStmt.expr = expr();
		if (ifStmt.expr.getType() != Type.booleanType)
			signalError.showError("boolean expression expected");
		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		if(lexer.token == Symbol.LEFTCURBRACKET)
			lexer.nextToken();
		Statement stmt = statement();
		ifStmt.stmt = stmt;
		if(lexer.token == Symbol.RIGHTCURBRACKET)
			lexer.nextToken();
		if (lexer.token == Symbol.ELSE) {
			lexer.nextToken();
			ifStmt.elseStmt = statement();
		}
		return ifStmt;
	}

	private ReturnStatement returnStatement() {

		ReturnStatement retStmt = new ReturnStatement();
		lexer.nextToken();
		retStmt.expr = expr();
		if (this.currentMethod.getReturnType() == Type.voidType)
			signalError.showError("This method cannot return a value ");
		Type t = retStmt.expr.getType();
		if (t != null) {
			if (!t.isCompatible(this.currentMethod.getReturnType()))
				signalError.showError("Return expression type is not compatible with the method type");
		}
		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
		return retStmt;
	}

	private ReadStatement readStatement() {
		ReadStatement readStmt = new ReadStatement();
		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		while (true) {
			if (lexer.token == Symbol.THIS) {
				lexer.nextToken();
				if (lexer.token != Symbol.DOT)
					signalError.showError(". expected");
				lexer.nextToken();

				if (lexer.token != Symbol.IDENT)
					signalError.show(ErrorSignaller.ident_expected);
				String name = lexer.getStringValue();

				ArrayList<InstanceVariable> instanceVariableList = currentClass.getInstanceVariableList();
				boolean flag = false;
				Type type = null;
				int i = 0;
				InstanceVariable inst = null;
				while (i < instanceVariableList.size()) {
					if (instanceVariableList.get(i).getName().equals(name)) {
						flag = true;
						type = instanceVariableList.get(i).getType();
						inst = instanceVariableList.get(i);
						break;
					}
					i++;
				}

				if (!flag)
					signalError.showError("variable not declared");

				if (inst.getType() != Type.intType && inst.getType() != Type.stringType)
					this.signalError.showError("int or string expressions expected");
				lexer.nextToken();
				readStmt.name.add(name);

			} else {
				if (lexer.token != Symbol.IDENT)
					signalError.show(ErrorSignaller.ident_expected);
				String name = lexer.getStringValue();

				if (this.symbolTable.getInLocal(name) == null)
					this.signalError.showError("variable not declared");
				if (this.symbolTable.getInLocal(name).getType() != Type.intType
						&& this.symbolTable.getInLocal(name).getType() != Type.stringType)
					this.signalError.showError("int or string expressions expected");
				lexer.nextToken();

				readStmt.name.add(name);
			}
			if (lexer.token == Symbol.COMMA)
				lexer.nextToken();
			else
				break;
		}

		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
		return readStmt;

	}

	private WriteStatement writeStatement() {

		WriteStatement write = new WriteStatement();
		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		write.exprlist = exprList();
		for (Expr e : write.exprlist.getExprList()) {
			Type t = e.getType();
			if (t != null) {
				if (e.getType() == Type.booleanType || (this.symbolTable.getInGlobal(e.getType().getName()) != null)) {
					this.signalError.showError("command write dos not accept boolean expression" + "or objects");
					break;
				}
			}

		}
		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
		return write;
	}

	private WriteLnStatement writelnStatement() {

		WriteLnStatement writeln = new WriteLnStatement();
		lexer.nextToken();
		if (lexer.token != Symbol.LEFTPAR)
			signalError.showError("( expected");
		lexer.nextToken();
		writeln.exprlist = exprList();
		for (Expr e : writeln.exprlist.getExprList()) {
			if (e.getType() == Type.booleanType || (this.symbolTable.getInGlobal(e.getType().getName()) != null)) {
				this.signalError.showError("command writeln dos not accept boolean expression" + "or objects");
				break;
			}

		}

		if (lexer.token != Symbol.RIGHTPAR)
			signalError.showError(") expected");
		lexer.nextToken();
		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
		return writeln;
	}

	private BreakStatement breakStatement() {
		BreakStatement breakstmt = new BreakStatement();
		lexer.nextToken();
		if (lexer.token != Symbol.SEMICOLON)
			signalError.show(ErrorSignaller.semicolon_expected);
		lexer.nextToken();
		return breakstmt;
	}

	private Statement nullStatement() {

		lexer.nextToken();
		return new NullStatement();
	}

	private ExprList exprList() {
		// ExpressionList ::= Expression { "," Expression }

		ExprList anExprList = new ExprList();
		anExprList.addElement(expr());
		while (lexer.token == Symbol.COMMA) {
			lexer.nextToken();
			anExprList.addElement(expr());
		}
		return anExprList;
	}

	private Expr expr() {

		Expr left = simpleExpr();
		Symbol op = lexer.token;
		if (op == Symbol.EQ || op == Symbol.NEQ || op == Symbol.LE || op == Symbol.LT || op == Symbol.GE
				|| op == Symbol.GT) {
			lexer.nextToken();
			Expr right = simpleExpr();
			Type l = left.getType();
			Type r = right.getType();

			if (!((right.getType() == Type.undefinedType && left.getType() == Type.stringType)
					|| (left.getType() == Type.undefinedType && right.getType() == Type.stringType))) {
				if (!right.getType().isCompatible(left.getType()) && !left.getType().isCompatible(right.getType()))
					signalError.showError(
							"Incompatible types cannot be compared with '==' because the result will always be 'false'");
			}
			left = new CompositeExpr(left, op, right);
		}
		return left;
	}

	private Expr simpleExpr() {
		Symbol op;

		Expr left = term();
		while ((op = lexer.token) == Symbol.MINUS || op == Symbol.PLUS || op == Symbol.OR) {
			lexer.nextToken();
			Expr right = term();
			if ((left.getType().getName().equals("int") || right.getType().getName().equals("int")) && op == Symbol.OR)
				signalError.showError("type int does not support operation '||'");
			if ((left.getType().getName().equals("boolean") || right.getType().getName().equals("boolean"))
					&& (op == Symbol.MINUS || op == Symbol.PLUS))
				signalError.showError("type boolean dos not support operator '+'  or '-'");
			left = new CompositeExpr(left, op, right);
		}
		return left;
	}

	private Expr term() {
		Symbol op;

		Expr left = signalFactor();
		while ((op = lexer.token) == Symbol.DIV || op == Symbol.MULT || op == Symbol.AND) {
			lexer.nextToken();
			Expr right = signalFactor();
			if ((left.getType().getName().equals("int") || right.getType().getName().equals("int")) && op == Symbol.AND)
				signalError.showError("type int does not support operation '&&'");
			if ((left.getType().getName().equals("boolean") || right.getType().getName().equals("boolean"))
					&& (op == Symbol.DIV || op == Symbol.MULT))
				signalError.showError("type boolean dos not support operator '*'  or '\'");
			left = new CompositeExpr(left, op, right);
		}
		return left;
	}

	private Expr signalFactor() {
		Symbol op;
		if ((op = lexer.token) == Symbol.PLUS || op == Symbol.MINUS) {
			lexer.nextToken();
			Expr fact = factor();
			if (fact.getType().getName().equals("boolean"))
				this.signalError.showError("operator '-' dos not accept boolean expressions");
			return new SignalExpr(op, fact);

		} else
			return factor();
	}

	/*
	 * Factor ::= BasicValue | "(" Expression ")" | "!" Factor | "null" |
	 * ObjectCreation | PrimaryExpr
	 * 
	 * BasicValue ::= IntValue | BooleanValue | StringValue BooleanValue ::= "true"
	 * | "false" ObjectCreation ::= "new" Id "(" ")" PrimaryExpr ::= "super" "." Id
	 * "(" [ ExpressionList ] ")" | Id | Id "." Id | Id "." Id "(" [ ExpressionList
	 * ] ")" | Id "." Id "." Id "(" [ ExpressionList ] ")" | "this" | "this" "." Id
	 * | "this" "." Id "(" [ ExpressionList ] ")" | "this" "." Id "." Id "(" [
	 * ExpressionList ] ")"
	 */
	private Expr factor() {

		Expr anExpr;
		ExprList exprList;
		String messageName, id;

		switch (lexer.token) {
		// IntValue
		case LITERALINT:
			return literalInt();
		// BooleanValue
		case FALSE:
			lexer.nextToken();
			return LiteralBoolean.False;
		// BooleanValue
		case TRUE:
			lexer.nextToken();
			return LiteralBoolean.True;
		// StringValue
		case LITERALSTRING:
			String literalString = lexer.getLiteralStringValue();
			lexer.nextToken();
			return new LiteralString(literalString);
		// "(" Expression ")" |
		case LEFTPAR:
			lexer.nextToken();
			anExpr = expr();
			if (lexer.token != Symbol.RIGHTPAR)
				signalError.showError(") expected");
			lexer.nextToken();
			return new ParenthesisExpr(anExpr);

		// "null"
		case NULL:
			lexer.nextToken();
			return new NullExpr();
		// "!" Factor
		case NOT:
			lexer.nextToken();
			anExpr = expr();
			return new UnaryExpr(anExpr, Symbol.NOT);
		// ObjectCreation ::= "new" Id "(" ")"
		case NEW:
			lexer.nextToken();
			if (lexer.token != Symbol.IDENT)
				signalError.showError("Identifier expected");

			String className = lexer.getStringValue();
			KraClass aclass = this.symbolTable.getInGlobal(className);
			if (aclass == null)
				signalError.showError("class " + className + "does not exists");
			/*
			 * // encontre a classe className in symbol table KraClass aClass =
			 * symbolTable.getInGlobal(className); if ( aClass == null ) ...
			 */

			lexer.nextToken();
			if (lexer.token != Symbol.LEFTPAR)
				signalError.showError("( expected");
			lexer.nextToken();
			if (lexer.token != Symbol.RIGHTPAR)
				signalError.showError(") expected");
			lexer.nextToken();
			/*
			 * return an object representing the creation of an object
			 */
			return new ConstructExpr(className, aclass);
		/*
		 * PrimaryExpr ::= "super" "." Id "(" [ ExpressionList ] ")" | Id | Id "." Id |
		 * Id "." Id "(" [ ExpressionList ] ")" | Id "." Id "." Id "(" [ ExpressionList
		 * ] ")" | "this" | "this" "." Id | "this" "." Id "(" [ ExpressionList ] ")" |
		 * "this" "." Id "." Id "(" [ ExpressionList ] ")"
		 */
		case SUPER:
			// "super" "." Id "(" [ ExpressionList ] ")"
			if (this.currentClass.getSuperclass() == null)
				this.signalError.showError(
						"'super' used in class '" + this.currentClass.getName() + "' that does not have a superclass");
			lexer.nextToken();
			if (lexer.token != Symbol.DOT) {
				signalError.showError("'.' expected");
			} else
				lexer.nextToken();
			if (lexer.token != Symbol.IDENT)
				signalError.showError("Identifier expected");
			messageName = lexer.getStringValue();
			boolean flag2 = false;

			KraClass superclass = this.currentClass.getSuperclass();
			String superClassName = null;
			
			while (superclass != null) {
				if(superclass.searchPublicMethod(messageName)!= null){
					flag2 = true;
					superClassName = superclass.getName();
					break;
				}
				
				superclass = superclass.getSuperclass();
			}
			
			if (!flag2)
				signalError.showError("Method '" + messageName + "' was not found in superclass '"
						+ this.currentClass.getName() + "' or its superclasses");
			/*
			 * para fazer as confer�ncias sem�nticas, procure por 'messageName' na
			 * superclasse/superclasse da superclasse etc
			 */
			lexer.nextToken();
			exprList = realParameters();
			return new SuperMethodExpr(messageName, exprList, superClassName);
		case IDENT:
			/*
			 * PrimaryExpr ::= Id | Id "." Id | Id "." Id "(" [ ExpressionList ] ")" | Id
			 * "." Id "." Id "(" [ ExpressionList ] ")" |
			 */

			String firstId = lexer.getStringValue();
			if ((this.currentClass.searchVariable(firstId) != null) && (this.symbolTable.getInLocal(firstId) == null))
				signalError.showError("Identifier '" + firstId + "' was not found");

			lexer.nextToken();
			if (lexer.token != Symbol.DOT) {
				// Id
				// retorne um objeto da ASA que representa um identificador
				Variable avar = this.symbolTable.getInLocal(firstId);
				if (this.currentClass.searchVariable(firstId) != null && avar == null)
					this.signalError.showError("Identifier '" + avar.getName() + "' was not found");
				if (avar == null)
					signalError.showError("class " + firstId + "does not exists");

				return new VariableExpr(avar);
			} else { // Id "."
				lexer.nextToken(); // coma o "."
				if (lexer.token != Symbol.IDENT) {
					signalError.showError("Identifier expected");
				} else {
					// Id "." Id
					lexer.nextToken();
					id = lexer.getStringValue();

					if (lexer.token == Symbol.DOT) {
						// Id "." Id "." Id "(" [ ExpressionList ] ")"
						/*
						 * se o compilador permite vari�veis est�ticas, � poss�vel ter esta op��o, como
						 * Clock.currentDay.setDay(12); Contudo, se vari�veis est�ticas n�o estiver nas
						 * especifica��es, sinalize um erro neste ponto.
						 */
						lexer.nextToken();
						if (lexer.token != Symbol.IDENT)
							signalError.showError("Identifier expected");
						messageName = lexer.getStringValue();
						lexer.nextToken();
						exprList = this.realParameters();

					} else if (lexer.token == Symbol.LEFTPAR) {
						// Id "." Id "(" [ ExpressionList ] ")"
						Variable avar = this.symbolTable.getInLocal(firstId);
						if (avar == null)
							signalError.showError("Identifier " + firstId + "was not declared");
						Type typeVar = avar.getType();
						if (!(typeVar instanceof KraClass))
							signalError.showError("Attempt to call a method on a variable of a basic type");
						exprList = this.realParameters();

						KraClass classVar = (KraClass) typeVar;
						MethodDec amethod = classVar.searchPublicMethod(id);
						boolean flag3 = false;
						if (amethod == null) {
							superclass = classVar.getSuperclass();
							while (superclass != null) {
								amethod = superclass.searchPublicMethod(id);
								if (amethod != null) {
									flag3 = true;
									break;
								}
								superclass = superclass.getSuperclass();
							}
							if (!flag3)
								signalError.showError("Method '" + id + "' was not found in the public interface of '"
										+ classVar.getName() + "' or its superclasses");
						}

						// if (amethod == null)
						// signalError.showError("Method " + id + " is not a public method of " +
						// classVar.getCname()
						// + " which is the type of " + firstId);

						/*
						 * para fazer as confer�ncias sem�nticas, procure por m�todo 'ident' na classe
						 * de 'firstId'
						 */
						return new VarMethodExpr(firstId, id, exprList, amethod.getReturnType());
					} else {
						Variable avar = this.symbolTable.getInLocal(id);
						if (avar == null)
							signalError.showError("Identifier " + id + "was not declared");
						Type typeVar = avar.getType();
						return new VarMethodExpr(firstId, id, typeVar,false);
					}
				}
			}
			break;
		case THIS:
			/*
			 * Este 'case THIS:' trata os seguintes casos: PrimaryExpr ::= "this" | "this"
			 * "." Id | "this" "." Id "(" [ ExpressionList ] ")" | "this" "." Id "." Id "("
			 * [ ExpressionList ] ")"
			 */
			lexer.nextToken();
			if (lexer.token != Symbol.DOT) {
				// only 'this'
				// retorne um objeto da ASA que representa 'this'
				// confira se n�o estamos em um m�todo est�tico
				return new VarMethodExpr("this");
			} else {
				lexer.nextToken();
				if (lexer.token != Symbol.IDENT)
					signalError.showError("Identifier expected");
				id = lexer.getStringValue();
				lexer.nextToken();
				// j� analisou "this" "." Id
				if (lexer.token == Symbol.LEFTPAR) {
					// "this" "." Id "(" [ ExpressionList ] ")"
					/*
					 * Confira se a classe corrente possui um m�todo cujo nome � 'ident' e que pode
					 * tomar os par�metros de ExpressionList
					 */
					exprList = this.realParameters();
					MethodDec amethod = this.currentClass.searchPublicMethod(id);
					if (amethod == null) {
						KraClass superclass1 = this.currentClass.getSuperclass();
						while ((superclass1 != null) && (amethod == null)) {
							amethod = superclass1.searchPublicMethod(id);
							superclass1 = superclass1.getSuperclass();
						}
					}
					if (amethod == null)
						amethod = this.currentClass.searchPrivateMethod(id);

					Type type = null;
					if (amethod == null)
						signalError.showError("Method " + id + " is not a public method of currentclass or not exist");
					else
						type = amethod.getReturnType();
					int i = 0;

					if (amethod.param != null) {
						ArrayList<ParamDec> fParam = amethod.param.getParams();
						boolean flag = false;
						if (exprList != null) {
							ArrayList<Expr> eList = exprList.getExprList();
							while (i < eList.size()) {
								if (!eList.get(i).getType().isCompatible(fParam.get(i).getType()))
									flag = true;
								i++;
							}
							if (flag)
								signalError.showError(
										"Type error: the type of the real parameter is not subclass of the type of the formal parameter");
						}
					}
					if (exprList == null)
						exprList = new ExprList();
					return new VarMethodExpr("this", id, exprList, type);
				} else if (lexer.token == Symbol.DOT) {
					// "this" "." Id "." Id "(" [ ExpressionList ] ")"
					lexer.nextToken();
					if (lexer.token != Symbol.IDENT) {
						signalError.showError("Identifier expected");
					}
					String id2 = lexer.getStringValue();
					Type type = null;
					
					ArrayList<InstanceVariable> instVarList = this.currentClass.getInstanceVariableList();
					for(InstanceVariable instVar: instVarList){
						if(instVar.getName().equals(id)){
							KraClass kraclass = this.symbolTable.getInGlobal(instVar.getType().getName());
							MethodDec amethod = kraclass.searchPublicMethod(id2);
							if (amethod == null)
								signalError.showError("Method " + id + " is not a public method of currentclass or not exist");
							else
								type = amethod.getReturnType();
						}
					}
					
					lexer.nextToken();
					if (lexer.token != Symbol.LEFTPAR)
						this.signalError.showError(" ( expected");
					exprList = this.realParameters();
					return new VarMethodExpr("this", id, id2, exprList,type);
				} else {
					// retorne o objeto da ASA que representa "this" "." Id
					/*
					 * confira se a classe corrente realmente possui uma vari�vel de inst�ncia
					 * 'ident'
					 */
					ArrayList<InstanceVariable> instanceVariableList = currentClass.getInstanceVariableList();
					boolean flag = false;
					Type type = null;
					int i = 0;
					while (i < instanceVariableList.size()) {
						if (instanceVariableList.get(i).getName().equals(id)) {
							flag = true;
							type = instanceVariableList.get(i).getType();
							break;
						}
						i++;
					}
					// nao achou a variavel de instancia indicada
					if (!flag)
						signalError.showError("InstanceVariable not found in this");
					return new VarMethodExpr("this", id, type,true);
				}
			}
		default:
			signalError.showError("Expression expected");
		}
		return null;
	}

	private LiteralInt literalInt() {
		// the number value is stored in lexer.getToken().value as an object of
		// Integer.
		// Method intValue returns that value as an value of type int.
		int value = lexer.getNumberValue();
		lexer.nextToken();
		return new LiteralInt(value);
	}

	private static boolean startExpr(Symbol token) {

		return token == Symbol.FALSE || token == Symbol.TRUE || token == Symbol.NOT || token == Symbol.THIS
				|| token == Symbol.LITERALINT || token == Symbol.SUPER || token == Symbol.LEFTPAR
				|| token == Symbol.NULL || token == Symbol.IDENT || token == Symbol.LITERALSTRING;

	}

	private SymbolTable symbolTable;
	private Lexer lexer;
	private ErrorSignaller signalError;

}
