/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class NullStatement extends Statement {

	@Override
	public void genCplusplus(PW pw) {
		pw.println(";");	
	}

	@Override
	public void genKra(PW pw) {
		pw.println(" ;");
		
	}

}
