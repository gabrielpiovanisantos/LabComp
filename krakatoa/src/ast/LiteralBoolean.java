package ast;

public class LiteralBoolean extends Expr {

    public LiteralBoolean( boolean value ) {
        this.value = value;
    }

    @Override
	public Type getType() {
        return Type.booleanType;
    }

    public static LiteralBoolean True  = new LiteralBoolean(true);
    public static LiteralBoolean False = new LiteralBoolean(false);

    private boolean value;

	@Override
	public void genKra(PW pw) {
		pw.print(""+this.value);
		
	}

	@Override
	public void genCplusplus(PW pw, boolean putParenthesis) {
		pw.print(""+this.value);
		
	}

}
