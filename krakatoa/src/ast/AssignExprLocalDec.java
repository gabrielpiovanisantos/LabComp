package ast;

public class AssignExprLocalDec extends Statement {

	public LocalDec localDec;
	public Expr left;
	public Expr right;

	@Override
	public void genC(PW pw) {
		// TODO Auto-generated method stub

	}

	@Override
	public void genKra(PW pw) {
		if (this.localDec != null)
			this.localDec.genkra(pw);
		else {
			pw.printIdent("");
			this.left.genKra(pw);
			if (this.right != null) {
				pw.print(" = ");
				if (this.right != null)
					this.right.genKra(pw);
			}
		}
	}
}
