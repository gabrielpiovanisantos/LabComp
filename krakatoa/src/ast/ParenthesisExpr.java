/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class ParenthesisExpr extends Expr {
    
    public ParenthesisExpr( Expr expr ) {
        this.expr = expr;
    }
    
    public void genCplusplus( PW pw, boolean putParenthesis ) {
        pw.print("(");
        expr.genCplusplus(pw, false);
        pw.printIdent(")");
    }
    
    public Type getType() {
        return expr.getType();
    }
    
    private Expr expr;

	@Override
	public void genKra(PW pw) {
		pw.print("( ");
		this.expr.genKra(pw);
		pw.print(" )");
		
	}

	
}