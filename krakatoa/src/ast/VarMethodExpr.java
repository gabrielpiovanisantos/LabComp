/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class VarMethodExpr extends Expr {

	private String firstId;

	public String getFirstId() {
		return firstId;
	}

	public String getId() {
		return id;
	}

	private String id;
	private ExprList exprList;
	private String id22;
	private Type type;

	public VarMethodExpr(String firstId, String id, ExprList exprList, Type type) {
		this.firstId = firstId;
		this.id = id;
		this.exprList = exprList;
		this.type = type;
	}

	public VarMethodExpr(String firstId2, String id2, Type type) {
		this.firstId = firstId2;
		this.id = id2;
		this.type = type;
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
	public void genCplusplus(PW pw, boolean putParenthesis) {
		pw.print(this.firstId);
		if (this.id != null) {
			pw.print("." + this.id);
			if (this.id22 != null)
				pw.print("." + this.id22);
			if (this.type != null) {
				if (this.exprList != null) {
					if (this.exprList.getExprList().isEmpty())
						pw.print("()");
					else {
						pw.print("( ");
						this.exprList.genCplusplus(pw);
						pw.print(" )");
					}
				}
			}
		}
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void genKra(PW pw) {
		pw.print(this.firstId);
		if (this.id != null) {
			pw.print("." + this.id);
			if (this.id22 != null)
				pw.print("." + this.id22);
			if (this.type != null) {
				if (this.exprList != null) {
					if (this.exprList.getExprList().isEmpty())
						pw.print("()");
					else {
						pw.print("( ");
						this.exprList.genKra(pw);
						pw.print(" )");
					}
				}
			} else
				pw.print("");
		} else
			pw.print("");
	}
}
