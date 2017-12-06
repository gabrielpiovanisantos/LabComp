/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class VariableExpr extends Expr {
    
    public VariableExpr( Variable v ) {
        this.v = v;
    }
    
    public void genCplusplus( PW pw, boolean putParenthesis ) {
        pw.print(v.getName());
    }
    
    public Type getType() {
        return v.getType();
    }
    
    private Variable v;

	@Override
	public void genKra(PW pw) {
		pw.print(this.v.getName());	
	}

	
}