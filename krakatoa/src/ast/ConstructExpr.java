package ast;

public class ConstructExpr extends Expr {

	private String className;
	private KraClass aclass;
	
	public ConstructExpr(String className, KraClass aclass2) {
		this.className = className;
		this.aclass = aclass2;
	}

	@Override
	public void genC(PW pw, boolean putParenthesis) {
		// TODO Auto-generated method stub

	}

	@Override
	public Type getType(){
		return this.aclass;
	}
	
	@Override
	public void genKra(PW pw) {
		pw.println("new "+ this.className+ " ( )");

	}

}
