package ast;

public class VarMethodExpr extends Expr {

	private String firstId;
	private String id;
	private ExprList exprList;
	private String id22;

	public VarMethodExpr(String firstId, String id, ExprList exprList) {
		this.firstId = firstId;
		this.id = id;
		this.exprList = exprList;
	}

	public VarMethodExpr(String firstId2, String id2) {
		this.firstId = firstId2;
		this.id = id2;
	}

	public VarMethodExpr(String string) {
		this.firstId = string;
	}

	public VarMethodExpr(String string, String id2, String id22, ExprList exprList2) {
		this.firstId = string;
		this.id = id2;
		this.id22 = id22;
		this.exprList = exprList2;
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
		// TODO Auto-generated method stub

	}

}
