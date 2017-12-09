/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class IfStatement extends Statement {

	public Expr expr;
	public Statement stmt;
	public Statement elseStmt;

	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("if ( ");
		this.expr.genCplusplus(pw, false);
		pw.println(")");
		pw.add();
		if(this.stmt != null)
			this.stmt.genCplusplus(pw);
		pw.sub();
		if(this.elseStmt!=null)
		{
			pw.printlnIdent(" else ");
			pw.add();
			this.elseStmt.genCplusplus(pw);
			pw.sub();
		}		
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("if ( ");
		this.expr.genKra(pw);
		pw.println(")");
		pw.add();
		this.stmt.genKra(pw);
		pw.sub();
		if(this.elseStmt!=null)
		{
			pw.printlnIdent(" else ");
			pw.add();
			this.elseStmt.genKra(pw);
			pw.sub();
		}		
	}

}
