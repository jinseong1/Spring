package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferInOutFileToFile {
//	파일로 읽어 파일을 출력하라 JAVA로 읽어 TXT로 출력하라
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis  = new BufferedInputStream(new FileInputStream("src/io24/node/FileReaderToMonitor.java"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/io24/node/FileReaderToMonitor.txt"));
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}//while
		bos.close();
		bis.close();
	}//main
}//class
