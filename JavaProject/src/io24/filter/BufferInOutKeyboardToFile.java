package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferInOutKeyboardToFile {
	public static void main(String[] args) throws IOException {
	
//	바이트 기반 입력용 노드 스트림 생성
	InputStream is = System.in;
//	바이트 기반 출력용 노드 스트림 생성
	FileOutputStream bs = new FileOutputStream("src/io24/filter/BufferInOutKeyboardToFile.txt");
		
//	필터터를 끼운 입력 스트림 생성
	BufferedInputStream bis = new BufferedInputStream(is);
//	필터를 끼운 출력 스트림 생성
	BufferedOutputStream bos = new BufferedOutputStream(bs);
//	bis로 읽고 bos로 출력
	int data;
	while((data=bis.read())!=-1) {
		bos.write(data);
		bos.flush();
		}
	bos.close();
	}
}