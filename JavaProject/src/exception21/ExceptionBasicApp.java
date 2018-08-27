package exception21;

import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionBasicApp {
	static Date toDay;
	public static void main(String[] args) /*throws IOException*/ {
//		컴파일 에러 
//		Syntax에러(문법오류),IOException(예외 발생했으니 너가 처리해 객체 돌려줌),SQException(대표적인 컴파일 에러(데이타베이스 에러(외부자료)))등
		
//		1-1 Syntax error
//		Int num;   I를 i로 변경해야함
		int num;
		
		
		if(true); {}
//		else {}  //Syntax error on token "else", delete this token
		
//		1-2 외부자원 사용시 발생하는 
		
		
//		방법1 예외 던지기
//		System.in.read();  //Unhandled exception type IOException
//		방법2
		/*
		try {
			System.in.read();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		*/
//		2 런타임 에러
//		런타임 에러는 개발자가 직접 처리하여야한다
		try {
		int[] array = new int[2];
		array[0]=100;
		System.out.println("array 0번방은 : "+array[0]);
		array[1]=200;
		System.out.println("array 1번방은 : "+array[1]);
		array[2]=300;
		System.out.println("array 2번방은 : "+array[2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외가 발생했어요");
			System.out.println("관리자에게 문의바랍니다");
			System.out.println("02-0000-0000");
		}
		
//		int형으로 변환시 해당 문자열이 숫자형식이 아닐때
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("나이를 입력하세요");
		/*
		String stringAge = sc.nextLine();
		int age = Integer.parseInt(stringAge);
		*/
		int age = sc.nextInt();
		System.out.println("당신의 10년후 나이 :"+age+10);
		}
		
		catch (NumberFormatException | InputMismatchException e) {
			System.out.println("숫자만 입력하여주세요");
		}
		
		System.out.println("toDay : "+toDay);
		try {
		System.out.println(toDay.getTime());
		}
		catch (NullPointerException e) {
			System.out.println("toDay는 null입니다");
		}
		String emptyString = "";
		System.out.println("문자열 길이 : "+emptyString.length());
		try {
		String nullString = null;
		System.out.println("문자열 길이 : "+nullString.length());
		}
		catch (NullPointerException e) {
			System.out.println("결과값이 null입니다");
		}
		
		int result=10;
		try {
			result/=0;
			System.out.println("0으로 나눈 결괴");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요");
		}
		Object object = new Object();
		try {String strObject = (String)object;}
		catch (ClassCastException e) {
//			System.out.println("형변환 할 수 없어요"); 평소에는 이 방법을 추천
//			System.out.println(e.toString());
//			System.out.println(e.getMessage());
//			e.printStackTrace(); 개발할때 오류 찾을때 사용함
		}
		
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
