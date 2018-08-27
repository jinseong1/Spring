package io24.filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerilzableObjectToFile2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		데이타 소스 (메모리) 준비 입력 스트림 불필요
		PersonSerializal ps1 = new PersonSerializal();
		ps1.name="김길동";
		ps1.age=20;
		ps1.addr="가산동";
		PersonSerializal ps2 = new PersonSerializal("나길동",30,"사당동");
		PersonSerializal ps3 = new PersonSerializal("다길동",40,"석촌동");
//		저장
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/io24/filter/Object.txt"));
		oos.writeObject(ps1);
		oos.writeObject(ps2);
		oos.writeObject(ps3);

		oos.close();

	}//main
}//class
