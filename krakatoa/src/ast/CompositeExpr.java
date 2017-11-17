/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import lexer.*;
import java.util.HashMap;


public class CompositeExpr extends Expr {

    public CompositeExpr( Expr pleft, Symbol poper, Expr pright ) {
        left = pleft;
        oper = poper;
        right = pright;
    }
    
    @Override
	public void genCplusplus( PW pw, boolean putParenthesis ) {
        if ( putParenthesis )
          pw.print("(");
        left.genCplusplus(pw, true);
        String strSymbol = arrayOper.get(oper);
        if ( strSymbol == null ) {
        	pw.println("internal error in CompositeExpr::genC");
        }
        else
            pw.print(" " + strSymbol + " ");
        right.genCplusplus(pw, true);
        if ( putParenthesis )
          pw.print(")");
    }

    @Override
	public Type getType() {
          // left and right must be the same type
       if ( oper == Symbol.EQ || oper == Symbol.NEQ || oper == Symbol.LE || oper == Symbol.LT ||
            oper == Symbol.GE || oper == Symbol.GT )
            return Type.booleanType;
       else if ( oper == Symbol.AND || oper == Symbol.OR )
            return Type.booleanType;
       else
            return Type.intType;
    }

    private Expr left, right;
    private Symbol oper;
    private static HashMap<Symbol, String> arrayOper;
    static {
        arrayOper = new HashMap<Symbol, String>();
        arrayOper.put(Symbol.PLUS, "+");
        arrayOper.put(Symbol.MINUS, "-");
        arrayOper.put(Symbol.MULT, "*");
        arrayOper.put(Symbol.DIV, "/");
        arrayOper.put(Symbol.LT, "<");
        arrayOper.put(Symbol.LE, "<=");
        arrayOper.put(Symbol.GT, ">");
        arrayOper.put(Symbol.GE, ">=");
        arrayOper.put(Symbol.NEQ, "!=");
        arrayOper.put(Symbol.EQ, "==");
        arrayOper.put(Symbol.ASSIGN, "=");
        arrayOper.put(Symbol.AND, "&&");
        arrayOper.put(Symbol.OR, "||");
    }
	@Override
	public void genKra(PW pw) {
		this.left.genKra(pw);
		String strSymbol = arrayOper.get(oper);
        if ( strSymbol == null ) {
        	pw.println("internal error in CompositeExpr::genkra");
        }
        else
            pw.print(" " + strSymbol + " ");
		this.right.genKra(pw);
		
	}

}
