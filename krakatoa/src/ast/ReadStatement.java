/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.ArrayList;

public class ReadStatement extends Statement{

	public ArrayList<String> name;
	
	
	public ReadStatement() {
		super();
		this.name = new ArrayList<String>();
	}

	@Override
	public void genCplusplus(PW pw) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void genKra(PW pw) {
		int size = name.size();
		pw.printIdent("read( ");
		for(String n: name)
		{
			pw.print(n);
			if(--size>0)
				pw.print(", ");
		}
		pw.println(" );");
	}

}
