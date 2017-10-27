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
		pw.printIdent("super."+this.messageName+ " (");
		this.exprList.genKra(pw);
		pw.println(" )");
	}

	

}
