package controlstatement03;

import java.io.IOException;

public class IfStatement02 {

	public static void main(String[] args) throws IOException {
		int num1 = 100;
			System.out.println("if문 형식 1로 짝홀수 판단");
		if(num1%2 == 0) {
			System.out.println("짝수");
		if(num1%2 != 0) {
			System.out.println("홀수");
		}
		}
		
		System.out.println("if문 형식 1로 짝홀수 판단");
		if(num1%2 == 0) System.out.println("짝수");
		else System.out.println("홀수");
		
		// ? : ; 삼항 연산자 가장 많이 씀
		System.out.println("삼항 연산자로 짝홀수 판단");
		String strResult = num1%2 == 0 ? "짝수" : "홀수" ;
		System.out.println(strResult);
		
		System.out.println("짝홀수 판단 후 짝수인 경우 100이상인지 판단(if~else문)");
		if(num1%2==0) {
			if(num1>=100)
				System.out.println("짝수이면서 100이상");
			else System.out.println("짝수이면서 100미만");
		}
		
		System.out.println("짝홀수 판단 후 짝수인 경우 100이상인지 판단(삼항연산자)");
		strResult = num1%2 == 0 ? num1>=100 ? "짝수이면서 100이상" : "짝수이면서 100미만"  : "" ;
		System.out.println(strResult);
		
		/*
		if(num1%2 != 0) {
			System.out.println("num1은"+num1);
			System.out.println(num1+"은 홀수");
		
		else
			System.out.println(num1+"은 짝수");
			
		}
		*/
		System.out.println("한 문자를 입력하세요");
		int asciicode=System.in.read();
		
		System.out.println("[if~else문 사용]");
		if(asciicode>='0' &&asciicode<='9') System.out.println("입력하신 값은 숫자입니다");
			else System.out.println("입력하신 값은 숫자가 아닙니다");
		
		System.out.println("삼항연산자");

		strResult = asciicode >='0' && asciicode >='9'? "숫자다" : "숫자아니다";
		System.out.println(strResult);
		System.in.skip(2); // 엔터값 스킵
		System.out.println("한 문자를 입력하세요");
		char word=(char)System.in.read();
		//숫자의 경우 2의 배수 만 출력, 혹은 알파벳의 경우 소문자만 출력
		
		System.out.println("[if~else문]");
		if(word>='0' &&word<='9') {
			if((word-'0')%2==0)
				System.out.println("2의 배수");
			else
				System.out.println("2의 배수가 아니다");
		}
			else {
					if(word >= 'a' && word <= 'z')
					System.out.println("소문자");
					else System.out.println("대문자");
				
		}
		
		System.out.println("삼항연산문");
		strResult = word>='0' && word<='9'?(word-'0')%2==0?word>='a'&&word<='z'?"2의 배수":"2의 배수가 아니다": "소문자":"대문자" ;
		System.out.println(strResult);
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
