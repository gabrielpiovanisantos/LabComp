/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import lexer.*;

public class SignalExpr extends Expr {

    public SignalExpr( Symbol oper, Expr expr ) {
       this.oper = oper;
       this.expr = expr;
    }

    @Override
	public void genCplusplus( PW pw, boolean putParenthesis ) {
       if ( putParenthesis )
          pw.print("(");
       pw.print( oper == Symbol.PLUS ? "+" : "-" );
       expr.genCplusplus(pw, true);
       if ( putParenthesis )
          pw.print(")");
    }

    @Override
	public Type getType() {
       return expr.getType();
    }

    private Expr expr;
    private Symbol oper;
	@Override
	public void genKra(PW pw) {
		if(this.oper == Symbol.PLUS)
			pw.print("+");
		else
			pw.print("-");
		this.expr.genKra(pw);
	}

	
}
