/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class BreakStatement extends Statement {

	@Override
	public void genCplusplus(PW pw) {
		pw.printlnIdent("break ;");		
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printlnIdent("break ;");		
	}

}
