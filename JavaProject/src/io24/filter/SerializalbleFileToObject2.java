package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializalbleFileToObject2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		객체가 저장된 파일을 읽어오자
//		FileInputStream
//		필터스트림 ObjectInPutStream
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/io24/filter/Object.txt"));
//		ois로 읽어서 PersonExternalizable 타입에 저장
		Object object = ois.readObject();
		if(object instanceof PersonSerializal) {
			PersonSerializal ps1 = (PersonSerializal)object;
			ps1.print();
		}
		PersonSerializal ps2 = (PersonSerializal)ois.readObject();
		ps2.print();
		PersonSerializal ps3 = (PersonSerializal)ois.readObject();
		ps3.print();
/*		PersonExternalizable pe4 = (PersonExternalizable)ois.readObject();
		pe4.print();*/// 객체를 생성하지 않아서 에러 뜸
		ois.close();
		
	}//main
}//class
