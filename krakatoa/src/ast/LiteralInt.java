package ast;

public class LiteralInt extends Expr {
    
    public LiteralInt( int value ) { 
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    public void genCplusplus( PW pw, boolean putParenthesis ) {
        pw.print(""+value);
    }
    
    public Type getType() {
        return Type.intType;
    }
    
    private int value;

	@Override
	public void genKra(PW pw) {
		pw.print(""+ value);
		
	}

	
}
