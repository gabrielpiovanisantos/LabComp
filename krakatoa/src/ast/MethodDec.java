package ast;

import lexer.Symbol;

public class MethodDec {

	public Type getReturnType() {
		return returnType;
	}

	public String getName() {
		return name;
	}

	public Symbol getQualifier() {
		return qualifier;
	}

	private Type returnType;
	private String name;
	private Symbol qualifier;
	public FormalParamDec param;
	public StatementList stmtList;
	

	public MethodDec(Type returntype, String name, Symbol qualifier) {
		this.returnType = returntype;
		this.name = name;
		this.qualifier = qualifier;
	}

	public FormalParamDec getParam() {
		return param;
	}

	public void genKra(PW pw)
	{
		pw.printIdent(this.qualifier.name().toLowerCase() + " " + this.returnType.getName()
						+ " " + this.getName() + "(");
		if(this.param != null)
			this.param.genKra(pw);
		pw.println(") {");
		pw.add();
		if(this.stmtList != null)
			this.stmtList.genKra(pw);		
		pw.sub();
		pw.printlnIdent("}");
		
	}
}
