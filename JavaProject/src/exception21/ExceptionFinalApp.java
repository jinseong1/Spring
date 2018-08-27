package exception21;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionFinalApp {
	
	static void tryCatchFinally() {
		Scanner sc =new Scanner(System.in);
		int age = Integer.MAX_VALUE;
		try {
			System.out.println("나이를 입력하세요");
			age = sc.nextInt();
//			return;
			System.exit(0);
			
		}
		catch (InputMismatchException e) {
			System.out.println("나이는 숫자만");
		}
		finally {
			System.out.println("당신의 10년후 나이 : "+(age+10));
		}
	}
	
	static void compile() throws IOException {
		
		
		
		System.out.println("한 문자만 입력하세요");
		
		int ascii = System.in.read();
		System.out.println("입력한 문자 :"+(char)ascii);
		
//		방법 2
		/*
		try {int ascii = System.in.read();}
		catch (Exception e) {}
		*/
		
		
	}
	
	static void runtime() {
		Integer.parseInt("백십");
	}
	
	
	static void tryFinally() throws IOException {
		try {
		compile();
		}
		finally {
			System.out.println("반드시 실행할 명령문");
		}

	}
	
	
	public static void main(String[] args) throws IOException /*throws NumberFormatException*/ /*throws IOException*/ {
		/*
//		직접처리 방법
		try {
			compile();
		} catch (IOException e) {}
//		try catch로 처리해준다
		try {
		runtime();
		}
		catch (Exception e) {
			System.out.println("숫자형식이 아닙니다 : "+e.getMessage());
		}
		*/
		
	
//		tryCatchFinally();
		
		tryFinally();
		
		
		
		
		
		
		
}
}
