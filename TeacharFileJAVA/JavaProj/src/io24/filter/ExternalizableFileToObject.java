package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
객체가 저장된 파일(Object.dat)로부터 객체를 읽어 오자
데이타 소스:파일
    노드 스트림:FileInputStream

필터 스트림:ObjectInputStream
    
데이타 목적지:객체(메모리)-인스턴스 변수 
*/
public class ExternalizableFileToObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//1]필터를 끼운 입력 스트림 생성
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream("src/io24/filter/Object.dat"));
		//2]ois로 읽어서 PersonExternalizable타입에 저장
		Object object=ois.readObject();
		if(object instanceof PersonExternalizable) {
			PersonExternalizable pe1=(PersonExternalizable)object;
			pe1.print();
		}
		PersonExternalizable pe2 = (PersonExternalizable)ois.readObject();
		pe2.print();
		
		PersonExternalizable pe3 = (PersonExternalizable)ois.readObject();
		pe3.print();
		//아래는 java.io.EOFException발생
		/*
		PersonExternalizable pe4 = (PersonExternalizable)ois.readObject();
		pe4.print();*/
		
		ois.close();

	}//////////////////main

}/////////////////////class
