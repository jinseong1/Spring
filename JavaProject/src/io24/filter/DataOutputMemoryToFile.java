package io24.filter;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//	자바의 자료형을 인코딩하여 파일로 저장하자
public class DataOutputMemoryToFile {

	public static void main(String[] args) throws IOException {
//		데이타 소스 준비 입력 스트림 준비불필요
		byte b=100;
		byte[] bArray = {97,98,99,100};
		char ch='가';
		int num = 256;
		boolean bool = false;
		String strObject = "안녕 자바!! Hello Java 1234567890";
		DataOutputStream dos =
				new DataOutputStream(new FileOutputStream("src/io24/filter/javaFile.txt"));
		dos.writeByte(b);
		dos.write(bArray);
		dos.writeChar(ch);
		dos.writeInt(num);
		dos.writeBoolean(bool);
//		문자열 저장하는 것 UTF는 다국어 지원
		dos.writeUTF(strObject);
		dos.close();
		
	}//main
}//class
