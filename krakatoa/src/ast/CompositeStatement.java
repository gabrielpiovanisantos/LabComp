/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class CompositeStatement extends Statement {

	public StatementList stmlist;

	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("{ ");
		pw.add();
		this.stmlist.genCplusplus(pw);
		pw.sub();
		pw.println("}");
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printlnIdent("{");
		pw.add();
		this.stmlist.genKra(pw);
		pw.sub();
		pw.println("}");
	}

}
