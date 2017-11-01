/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class SuperMethodExpr extends Expr {

	private String messageName;
	private ExprList exprList;

	public SuperMethodExpr(String messageName, ExprList exprList) {
		this.messageName = messageName;
		this.exprList = exprList;
	}

	@Override
	public void genC(PW pw, boolean putParenthesis) {
		// TODO Auto-generated method stub

	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void genKra(PW pw) {
		pw.print("super." + this.messageName + " (");
		if (this.exprList != null)
			this.exprList.genKra(pw);
		pw.print(" )");
	}

}
