package io24.filter;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputFileToMemory {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/io24/filter/javaFile.txt");
		
		/* 잘못된 방법 1
		int data;
		while((data=fis.read())!=-1) {
			System.out.println(data);
		}
		*/
		/* 잘못된 방법 2
		int data;
		while((data=fis.read())!=-1) {
			System.out.write(data);
			System.out.flush();
		}
		*/
		DataInputStream dis = new DataInputStream(fis);
		byte by= dis.readByte();
		System.out.println(by);
		byte[] b = new byte[4];
		dis.read(b);
		for(byte value:b) {
			System.out.println(value);
		}
		char ch= dis.readChar();
		System.out.println(ch);
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readUTF());
		
//		닫음
		dis.close();
	}//main
}//class
