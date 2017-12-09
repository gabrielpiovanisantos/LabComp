/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.ArrayList;

public class LocalDec {

	private ArrayList<Variable> arrayVar;
	private Type type;

	public LocalDec(ArrayList<Variable> arrayVar, Type type) {
		this.arrayVar = arrayVar;
		this.type = type;
	}

	public void genkra(PW pw) {
		pw.print(this.type.getName()+" ");
		int size = this.arrayVar.size();
		for(Variable v: arrayVar)
		{
			if(!this.type.isDefaultType())
				pw.print(v.getName());
			else
				pw.print(v.getName());
			if(--size>0)
				pw.print(", ");
		}
	}

	public void genCplusplus(PW pw) {
		pw.print(this.type.getCname()+" ");
		int size = this.arrayVar.size();
		for(Variable v: arrayVar)
		{
			if(!v.getType().isDefaultType())
				pw.print("*"+v.getName());
			else
				pw.print(v.getName());
			if(--size>0)
				pw.print(", ");
		}
		
	}

}
