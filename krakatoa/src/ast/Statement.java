/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

abstract public class Statement {

	abstract public void genC(PW pw);
	
	abstract public void genKra(PW pw);

}
