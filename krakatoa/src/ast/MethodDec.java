/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.*;

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

	public void genCplusplus(PW pw) {
		if(this.getName().equals("run"))
			pw.printIdent("int main(");
		else
			pw.printIdent("virtual "+ this.returnType.getName()	+ " " + this.getName() + "(");
		if(this.param != null)
			this.param.genCplusplus(pw);
		pw.println(") {");
		pw.add();
		if(this.stmtList != null)
			this.stmtList.genCplusplus(pw);		
		pw.sub();
		pw.printlnIdent("}");
	}
}
