package ast;

import java.util.ArrayList;

/*
 * Krakatoa Class
 */
public class KraClass extends Type {

	private String name;
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

	// m�todos p�blicos get e set para obter e iniciar as vari�veis acima,
	// entre outros m�todos

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

	public void addMethod(MethodDec amethod) {
		publicMethodList.add(amethod);
	}

	public MethodDec searchPublicMethod(String methodName) {
		for (MethodDec m : this.publicMethodList) {
			if (m.getName().equals(methodName))
				return m;
		}
		return null;
	}

	public void addInstanceVariable(InstanceVariable instanceVariable) {
		this.instanceVariableList.add(instanceVariable);

	}

	public void genkra(PW pw) {
		if(this.superclass!=null)
		{
			pw.println("class "+this.getName()+" {");
		}
		else
		{
			pw.println("class "+this.getName()+ " extends "+this.superclass.getName()+ " {");
		}
		pw.add();
		if (this.instanceVariableList != null) {
			for (InstanceVariable instvar : this.instanceVariableList) 
				instvar.genkra(pw);
		}
		if(this.publicMethodList!=null) {
			for(MethodDec mdec: this.publicMethodList)
				mdec.genKra(pw);
		}
		pw.sub();
		pw.println("}");
	}
}
