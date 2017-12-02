/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

public class InstanceVariable extends Variable {

    public InstanceVariable( String name, Type type ) {
        super(name, type);
    }

	public void genkra(PW pw) {
		pw.printlnIdent("private"+" "+this.getType().getName()+" "+this.getName()+";");		
	}

	public void genCplusplus(PW pw) {
		if(!this.getType().isDefaultType())
			pw.println(this.getType().getName()+" "+this.getName()+";");
		else
			pw.println(this.getType().getName()+" *"+this.getName()+";");
		
	}

}