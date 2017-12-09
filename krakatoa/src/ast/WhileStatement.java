/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class WhileStatement extends Statement{

	private Expr expr;
	private Statement stmt;

	public Expr getExpr() {
		return expr;
	}

	public Statement getStmt() {
		return stmt;
	}

	public WhileStatement(Expr expr2, Statement stmt2) {
		this.expr = expr2;
		this.stmt = stmt2;
	}

	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("while ( ");
		this.expr.genCplusplus(pw, false);
		pw.println(" ){");
		pw.add();
		if(this.stmt != null)
			this.stmt.genCplusplus(pw);
		pw.sub();
		pw.printIdent("}");
		pw.println("");
	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("while ( ");
		this.expr.genKra(pw);
		pw.println(" )");
		pw.add();
		this.stmt.genKra(pw);
		pw.sub();
	}
}
