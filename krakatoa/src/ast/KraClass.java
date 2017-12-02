/*
 * Gabriel Piovani Moreira dos Santos RA : 552216
 * Vitor Fernando Souza Silva		  RA : 552488
 * 
 * */

package ast;

import java.util.ArrayList;

import lexer.Symbol;

/*
 * Krakatoa Class
 */
public class KraClass extends Type {

	private KraClass superclass;
	private ArrayList<InstanceVariable> instanceVariableList;
	private ArrayList<MethodDec> publicMethodList, privateMethodList;

	public KraClass(String className) {
		super(className);
		this.instanceVariableList = new ArrayList<>();
		this.privateMethodList = new ArrayList<>();
		this.publicMethodList = new ArrayList<>();
	}

	public String getCname() {
		return getName();
	}

	public void setSuperclass(KraClass superclass) {
		this.superclass = superclass;
	}

	// métodos públicos get e set para obter e iniciar as variáveis acima,
	// entre outros métodos

	public boolean isSubClassOf(Type other) {
		KraClass current = this;
		while (current != other) {
			current = current.getSuperclass();
			if (current == null)
				return false;
		}
		return true;
	}

	public KraClass getSuperclass() {
		return superclass;
	}

	public ArrayList<InstanceVariable> getInstanceVariableList() {
		return instanceVariableList;
	}

	public ArrayList<MethodDec> getPublicMethodList() {
		return publicMethodList;
	}

	public ArrayList<MethodDec> getPrivateMethodList() {
		return privateMethodList;
	}

	public void addPublicMethod(MethodDec amethod) {
		publicMethodList.add(amethod);
	}

	public void addPrivateMethod(MethodDec amethod) {
		privateMethodList.add(amethod);
	}

	public MethodDec searchPublicMethod(String methodName) {
		for (MethodDec m : this.publicMethodList) {
			if (m.getName().equals(methodName))
				return m;
		}
		return null;
	}

	public MethodDec searchPrivateMethod(String methodName) {
		for (MethodDec m : this.privateMethodList) {
			if (m.getName().equals(methodName))
				return m;
		}
		return null;
	}

	public void addInstanceVariable(InstanceVariable instanceVariable) {
		this.instanceVariableList.add(instanceVariable);

	}

	public InstanceVariable searchVariable(String varName) {
		for (InstanceVariable m : this.instanceVariableList) {
			if (m.getName().equals(varName))
				return m;
		}
		return null;
	}

	public void genkra(PW pw) {
		if (this.superclass == null) {
			pw.println("class " + this.getName() + " {");
		} else {
			pw.println("class " + this.getName() + " extends " + this.superclass.getName() + " {");
		}
		pw.add();
		if (this.instanceVariableList != null) {
			pw.println("");
			for (InstanceVariable instvar : this.instanceVariableList)
				instvar.genkra(pw);
		}
		if (this.publicMethodList != null) {
			for (MethodDec mdec : this.publicMethodList) {
				if (mdec != null)
					mdec.genKra(pw);
				pw.println("");
			}
		}
		pw.sub();
		pw.println("}");
	}

	public void genCplusplus(PW pw) {
		if (this.superclass == null) {
			pw.println("class " + this.getName() + " {");
		} else {
			pw.println("class " + this.getName() + ": public  " + this.superclass.getName() + " {");
		}
		pw.add();
		if (this.instanceVariableList.size() > 0 ) {
			pw.println("");
			pw.println("private: ");
			pw.add();
			for (InstanceVariable instvar : this.instanceVariableList)
				instvar.genCplusplus(pw);
			pw.sub();
		}
		boolean publicflag = false;
		boolean privateflag = false;
		
		if (this.publicMethodList != null) {
			 for (MethodDec mdec : this.publicMethodList) {
				if (mdec != null){
					if(mdec.getQualifier() == Symbol.PUBLIC){
						publicflag = true;
						break;
					}
				}
			 }
			 if(publicflag){
				 pw.println("public: ");
				 pw.add();
				 for (MethodDec mdec : this.publicMethodList) {
						if (mdec != null){
							if(mdec.getQualifier() == Symbol.PUBLIC)
								mdec.genCplusplus(pw);
						}
						pw.println("");
				 }
				 pw.sub();
			 }
			 for (MethodDec mdec : this.publicMethodList) {
				 	if (mdec != null){
						if(mdec.getQualifier() == Symbol.PRIVATE){
							privateflag = true;
							break;
						}
					}
			 }
			 
			 if(privateflag){
				 pw.println("private: ");
				 pw.add();
				 for (MethodDec mdec : this.publicMethodList) {
						if (mdec != null){
							if(mdec.getQualifier() == Symbol.PRIVATE)
								mdec.genCplusplus(pw);
						}
						pw.println("");
				 }
				 pw.sub();
			}	 
		}
		pw.sub();
		pw.println("}");
	}
}
