/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class StatementAssert extends Statement {
	public StatementAssert(Expr expr, int lineNumber, String message) {
		this.expr = expr;
		this.lineNumber = lineNumber;
		this.message = message;
	}
	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("if ( !( ");
		expr.genCplusplus(pw, false);
		pw.println(" ) ) {");
		pw.add();
		pw.printlnIdent("puts(\"" + message +  "\");");
		pw.sub();
		pw.printlnIdent("}");

	}

	public Expr getExpr() {
		return expr;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getMessage() {
		return message;
	}

	private Expr expr;
	private int lineNumber;
	private String message;
	@Override
	public void genKra(PW pw) {
		pw.printIdent("assert ");
		this.expr.genKra(pw);
		pw.println(", " + this.message);
	}
}
