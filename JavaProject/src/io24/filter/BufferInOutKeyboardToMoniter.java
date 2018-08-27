package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

//	단지 버퍼계열 필터만 끼운 것
//	키보드로 부터 데이터를 입력받아 모니터로 출력하자 단 필터 스트림을 이용하자
//	필터스트림 생성자에 노드스트림을 넣어주면 필터스트림을 끼우는 것임
//	필터를 사용하는 이유는 첫번째 속도를 개선 두번재는 필터가 가지고 있는 메소드 로드스트림에 없는 것 때문에 사용한다
//	또한 필터를 사용하면 효율적이다

public class BufferInOutKeyboardToMoniter {

	public static void main(String[] args) throws IOException {
//		필터터를 끼운 입력 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(System.in);
//		필터를 끼운 출력 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
//		bis로 읽고 bos로 출력
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}
		
		
		
		
		
	}//main
}//class
