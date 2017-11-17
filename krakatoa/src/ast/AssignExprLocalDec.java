/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class AssignExprLocalDec extends Statement {

	public LocalDec localDec;
	public Expr left;
	public Expr right;

	@Override
	public void genCplusplus(PW pw) {
		// TODO Auto-generated method stub

	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("");
		if (this.localDec != null)
			this.localDec.genkra(pw);
		else {
			this.left.genKra(pw);
			if (this.right != null) {
				pw.print(" = ");
				if (this.right != null)
					this.right.genKra(pw);
			}
		}
	}
}
