package ast;

public class LiteralString extends Expr {
    
    public LiteralString( String literalString ) { 
        this.literalString = literalString;
    }
    
    public void genCplusplus( PW pw, boolean putParenthesis ) {
        pw.print("\""+literalString+"\"");
    }
    
    public Type getType() {
        return Type.stringType;
    }
    
    private String literalString;

	@Override
	public void genKra(PW pw) {
		pw.print(literalString);
		
	}

}
