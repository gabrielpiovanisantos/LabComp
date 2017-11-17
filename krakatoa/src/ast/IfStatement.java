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
		// TODO Auto-generated method stub
		
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
