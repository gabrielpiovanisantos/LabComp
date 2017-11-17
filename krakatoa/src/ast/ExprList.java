/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.*;

public class ExprList {

    public ExprList() {
        exprList = new ArrayList<Expr>();
    }

    public void addElement( Expr expr ) {
        exprList.add(expr);
    }

    public void genCplusplus( PW pw ) {

        int size = exprList.size();
        for ( Expr e : exprList ) {
        	e.genCplusplus(pw, false);
            if ( --size > 0 )
                pw.print(", ");
        }
    }
    
    public void genKra(PW pw)
    {
    	int size = exprList.size();
    	for(Expr e: exprList)
    	{
    		e.genKra(pw);
    		if(--size>0)
    			pw.print(", ");
    	}
    }

    private ArrayList<Expr> exprList;

	public ArrayList<Expr> getExprList() {
		return exprList;
	}

	public void setExprList(ArrayList<Expr> exprList) {
		this.exprList = exprList;
	}

}
