/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class SuperMethodExpr extends Expr {

	private String messageName;
	private ExprList exprList;
	private String superClassName;

	public SuperMethodExpr(String messageName, ExprList exprList, String superClassName) {
		this.messageName = messageName;
		this.exprList = exprList;
		this.superClassName = superClassName;
	}

	@Override
	public void genCplusplus(PW pw, boolean putParenthesis) {
		pw.print(superClassName + "::" + this.messageName + "( ");
		if(this.exprList != null)
			this.exprList.genCplusplus(pw);
		pw.print(")");
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
