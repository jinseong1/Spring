package controlstatement03;

import java.io.IOException;

public class IfStatement01 {

	public static void main(String[] args) throws IOException {
		//조건문을 분기문이라고도 한다.
		int num1 = 10;
		//결과값이 boolean 값이 아닌 것은 불가		
		// if(num1 % 2){} [X]
		//if(num1){} [X]
		
		
		if(num1 % 2 == 0){
			System.out.printf("%d는 짝수다%n",num1);
		}
		if(num1 % 2 != 0){
			System.out.printf("%d는 홀수다%n",num1);
		}
		if(num1 % 2==0 && num1 >= 10) {
			System.out.printf("%d는 짝수이고 10보다 크거나 작다%n",num1);
		}
		if(true) {
			System.out.println("true는 무조건 실행이다");
		}
		/*if(false) {
			System.out.println("false는 실행되지 않는다");
		}*/		
		
		if(num1 % 2 != 0);{         // () 후 ; 를 넣으면 {} 안은 항상 실행됨.
			System.out.printf("%d는 홀수다%n",num1);
		}
		
		if(num1 % 2 == 0)
			System.out.printf("%d는 짝수%n",num1);
		if(num1 % 2 != 0)
			System.out.printf("num1은 %d이다%n",num1); //조건문에 따라 실행
			System.out.printf("%d는 홀수다%n",num1);  // 항상 실행
			
			
			
			/*
			int ascii=System.in.read(); //read는 int형이다
			System.out.println("사용자가 입력한 문자:"+ascii);
			System.out.println("사용자가 입력한 문자:"+System.in.read());
			System.out.println("사용자가 입력한 문자:"+System.in.read());
			
			
			System.out.println("한 문자를 입력하세요?");
			int asciicode=System.in.read();
			System.out.println("사용자가 입력한 아스키 코드값"+asciicode);
			System.out.println("사용자가 입력한 문자"+(char)asciicode);
		*/
			//아스키 코드값을 알떄
			/*
				System.out.println("한 문자를 입력하세요?");
			int asciicode=System.in.read();
			boolean inNumber = asciicode >= 48 && asciicode <= 57;
			if(inNumber)
				System.out.println("입력한 문자는 숫자다");
			if(!inNumber)
				System.out.println("입력한 문자는 숫자가 아니다");
			*/
		
					
			//아르키 코드값을 모를때
			/*
			System.out.println("한 문자를 입력하세요?");
			int asciicode=System.in.read();
			boolean inNumber = asciicode >= '0' && asciicode <= '9';
			if(inNumber)
				System.out.println("입력한 문자는 숫자다");
			if(!inNumber)
				System.out.println("입력한 문자는 숫자가 아니다");
			*/
			//아스키 코드값은 대문자 A(65~90) 소문자 a(97~122)이다
			
			/*
			System.out.println("한 문자를 입력하세요?");
			int asciicode=System.in.read();
			
			boolean isAIphaber = (asciicode >= '0' && asciicode <= '9') ||
								 (asciicode >= 'A' && asciicode <= 'Z') ||
								 (asciicode >= 'a' && asciicode <= 'z') ;
		
			if(isAIphaber)
				System.out.println("알파벳 혹은 숫자");
			if(!isAIphaber)
				System.out.println("기타");
			//엔터값 스킵
			//System.in.skip(2);
			System.in.read(); // read \r
			System.in.read(); // read \n
			*/
			
			System.out.println("한 문자를 다시 입력하세요?");
			char word = (char)System.in.read();
			System.in.skip(2);
					
			
			boolean ismultiple  = word >= '0' && word <='9';	
			if(ismultiple) {
				ismultiple = (word-'0') % 2 == 0;
				if(ismultiple)
					System.out.println("2의 배수입니다");
				if(!ismultiple)
					System.out.println("2의 배수가 아닙니다");				
			}

	}//main

}//class
