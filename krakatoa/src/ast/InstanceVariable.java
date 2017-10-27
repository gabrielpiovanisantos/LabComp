package ast;

public class InstanceVariable extends Variable {

    public InstanceVariable( String name, Type type ) {
        super(name, type);
    }

	public void genkra(PW pw) {
		pw.printlnIdent("private"+" "+this.getType().getName()+" "+this.getName()+";");		
	}

}