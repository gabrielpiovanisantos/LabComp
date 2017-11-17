/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class NullExpr extends Expr {
    
   public void genCplusplus( PW pw, boolean putParenthesis ) {
      pw.printIdent("NULL");
   }
   
   public Type getType() {
     
      return Type.undefinedType;
   }

@Override
public void genKra(PW pw) {
	pw.print(" null ");
	
}

}