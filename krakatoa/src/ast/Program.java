/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.*;
import comp.CompilationError;

public class Program {

	public Program(ArrayList<KraClass> classList, ArrayList<MetaobjectCall> metaobjectCallList,
			ArrayList<CompilationError> compilationErrorList) {
		this.classList = classList;
		this.metaobjectCallList = metaobjectCallList;
		this.compilationErrorList = compilationErrorList;
	}

	public void genKra(PW pw) {
		pw.println("");
		for (KraClass classe : classList) {
			if (classe != null)
				classe.genkra(pw);
			pw.println("");
		}
	}

	public void genCplusplus(PW pw) {
		pw.println("");
		for (KraClass classe : classList) {
			if (classe != null)
				classe.genCplusplus(pw);
			pw.println("");
		}
	}

	public ArrayList<KraClass> getClassList() {
		return classList;
	}

	public ArrayList<MetaobjectCall> getMetaobjectCallList() {
		return metaobjectCallList;
	}

	public boolean hasCompilationErrors() {
		return compilationErrorList != null && compilationErrorList.size() > 0;
	}

	public ArrayList<CompilationError> getCompilationErrorList() {
		return compilationErrorList;
	}

	private ArrayList<KraClass> classList;
	private ArrayList<MetaobjectCall> metaobjectCallList;

	ArrayList<CompilationError> compilationErrorList;

}