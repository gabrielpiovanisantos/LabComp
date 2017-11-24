/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class WriteStatement extends Statement{

	public ExprList exprlist;

	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("cout << ");
		this.exprlist.genCplusplus(pw);
		pw.println(";");
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("write( ");
		this.exprlist.genKra(pw);
		pw.println(" );");
	}
}

