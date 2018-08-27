package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

//	파일로 입력받아 모니터로 출력한다
public class BufferInOutFileToMonitor {

	public static void main(String[] args) throws IOException {
//		파일 입력을 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/io24/filter/BufferInOutKeyboardToFile.txt"));
//		모니터로 출력할 스트림 준비
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}
		bos.close();
	}//main
}//class
