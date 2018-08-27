package io24.filter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonExternalizable implements Externalizable {

	String name;
	int age;
	String addr;	
	
//	기본 생성자
	public PersonExternalizable() {super();}
	
//	인자생성자
	public PersonExternalizable(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	void print() {System.out.println(String.format("이름: %s, 나이 : %d, 주소 : %s", name,age,addr));}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeObject(age);
		out.writeObject(addr);
	}
	
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name=(String)in.readObject();
		age	=(Integer)in.readObject();
		addr=(String)in.readObject();
		
	}
	
	
	
	
	
	
	
}//class
