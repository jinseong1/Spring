package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ExternalizableFileToObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		객체가 저장된 파일을 읽어오자
//		FileInputStream
//		필터스트림 ObjectInPutStream
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/io24/filter/Object.dat"));
//		ois로 읽어서 PersonExternalizable 타입에 저장
		Object object = ois.readObject();
		if(object instanceof PersonExternalizable) {
			PersonExternalizable pe1 = (PersonExternalizable)object;
			pe1.print();
		}
		PersonExternalizable pe2 = (PersonExternalizable)ois.readObject();
		pe2.print();
		PersonExternalizable pe3 = (PersonExternalizable)ois.readObject();
		pe3.print();
/*		PersonExternalizable pe4 = (PersonExternalizable)ois.readObject();
		pe4.print();*/// 객체를 생성하지 않아서 에러 뜸
		
		ois.close();
		
		
		
	}//main
}//class
