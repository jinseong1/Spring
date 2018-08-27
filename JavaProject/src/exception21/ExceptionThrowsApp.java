package exception21;

import java.io.IOException;

public class ExceptionThrowsApp {

	static void throwsMehtodByJava() throws IOException {
		System.out.println("문자입력");
		System.in.read();
	}
	
	static void callBtJava() throws IOException {
		throwsMehtodByJava();
	}
	static void throwsMethodByUser(int value) throws Exception {
		if(value%2==0) {
			Exception e = new Exception("짝수는 안되요");
			throw e; // 
//			System.out.println("throws이후 출력문"); [X]
		}
		System.out.println(value+"는 홀수");
	}
	
	static void callByUser(int value) throws Exception {
		throwsMethodByUser(value);
	}
	
	public static void main(String[] args) /*throws Exception*/  /* throws IOException*/ {
		
//		callBtJava();// 던진다
		/*
		try { //직접처리
			callBtJava();
		} catch (IOException e) {}
		*/
		try {
			callByUser(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}//main
}//class
