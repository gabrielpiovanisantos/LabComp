/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class DoWhileStatement extends Statement {

	private StatementList comp;
	private Expr expr;

	public DoWhileStatement(StatementList comp2, Expr expr) {
		this.comp = comp2;
		this.expr = expr;
	}

	@Override
	public void genCplusplus(PW pw) {
		pw.printlnIdent("do {");
		pw.add();
		this.comp.genKra(pw);
		pw.sub();
		pw.printIdent("} while (");
		this.expr.genCplusplus(pw,false);
		pw.println(")");

	}

	@Override
	public void genKra(PW pw) {
		pw.printlnIdent("do {");
		pw.add();
		this.comp.genKra(pw);
		pw.sub();
		pw.printIdent("} while (");
		this.expr.genKra(pw);
		pw.println(")");
	}

}
