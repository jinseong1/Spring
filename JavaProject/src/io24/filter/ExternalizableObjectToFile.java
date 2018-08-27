package io24.filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExternalizableObjectToFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		데이타 소스 (메모리) 준비 입력 스트림 불필요
		PersonExternalizable pe1 = new PersonExternalizable();
		pe1.name="김길동";
		pe1.age=20;
		pe1.addr="가산동";
		PersonExternalizable pe2 = new PersonExternalizable("나길동",30,"사당동");
		PersonExternalizable pe3 = new PersonExternalizable("다길동",40,"석촌동");
//		저장
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/io24/filter/Object.dat"));
		oos.writeObject(pe1);
		oos.writeObject(pe2);
		oos.writeObject(pe3);

		oos.close();

	}//main
}//class
