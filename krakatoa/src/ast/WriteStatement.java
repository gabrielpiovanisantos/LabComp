/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.ArrayList;

public class WriteStatement extends Statement{

	public ExprList exprlist;

	@Override
	public void genCplusplus(PW pw) {
		pw.printIdent("cout << ");
		ArrayList<Expr> exprList = this.exprlist.getExprList();
		int size = exprList.size();
		if(size > 1){
			for(Expr e: exprList){
				
					e.genCplusplus(pw, false);
					if(--size>0)
						pw.print(" << ");
				
			}
		}
		else
			this.exprlist.genCplusplus(pw);
		pw.println(";");
		
	}

	@Override
	public void genKra(PW pw) {
		pw.printIdent("write( ");
		this.exprlist.genKra(pw);
		pw.println(" );");
	}
}

