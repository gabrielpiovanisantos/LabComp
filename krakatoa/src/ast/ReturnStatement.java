/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class ReturnStatement extends Statement{

	public Expr expr;

	@Override
	public void genCplusplus(PW pw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("return ");
		this.expr.genKra(pw);
		pw.println(" ;");		
	}

}
