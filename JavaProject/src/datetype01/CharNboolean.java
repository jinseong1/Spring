package datetype01;

public class CharNboolean {

	public static void main(String[] args) {
		
		/*아스키 코드 : 영문자와 숫자는 1byte로 표현할 수 있는 문자
		A의 아스크 코드값: 65(이진수-1000001), B는 66 a는 97 
		유니코드! 한글이나 한자 2byte,  16진수로 표현
		char ""(문자열) ''(문자)
		메모리 생긴 모습 자체가 다름.(형변환 X)
		char ch1
		기본자료형과 참조형
		*/
		
		//char ch1 = "가"; [X] string		
		//char ch1 = '가나'; [X]
		char ch1 = '가'; //[O]
		System.out.println("ch1="+ch1); // 결과값 : 가 //+는 문자열 연결
		
		char ch2 = 'A'; //(캐릭터형)
		int num1 = 2; //(인트형)
		//char ch3 = ch2+num1; //[X]
		//캐릭터형과 인트형을 담으면 인트형으로 인식한다 캐릭터형은 인식을 하지 못한다
	
		int num2 = ch2+num1;
		
		System.out.println("num2="+num2);
		System.out.println("num2(아스키코드값)="+(char)num2); //강제로 캐릭터형으로 변환 대신 A+2=C로 대답한다
		
		//char ch3 = 67; //65,000까지 담김
		//char ch3 = num2; // 변수는 X
		//System.out.println(ch3);
		
		System.out.println("방법 1 형변환");
		//char ch3 = ch2+num1; // [X] 캐릭터+캐릭터 = 인트
		char ch3 = (char)(ch2+num1);
		System.out.println("ch3="+ch3);
		System.out.println("num2(문자)="+(char)num2);
		
		System.out.println("방법2 형변환");
		char ch4 = '1';
		char ch4_1 = 49;
			System.out.println("ch4="+ch4+"ch4_1="+ch4_1);
			
		char ch5 = 'a';
		char ch5_1 = 97;
			System.out.println("ch5="+ch5+"ch5_1="+ch5_1);
		
		char ch6 = '가';
		System.out.println("ch6(문자)"+ch6+"ch6(유니코드)="+(int)ch6);
		
		//   '\nAC00' '/u 뒤는 16진수로 인식

		
		char ch6_1 = 44032;
		char ch6_2 = 0xAC00;
		char ch6_3 = '\uAC00';
		
		
		
		System.out.println(ch6_1);
		System.out.println(ch6_2);
		System.out.println(ch6_3);
		
		
		//int num3 = 48;
		int num4 = '0' - 48;
		System.out.println(num4);
		
		boolean bl1 = true;
		boolean bl2 = false;
		
		//System.out.println(bl1+bl2); //[X]
		//System.out.println(bl1>l2); //[X]
		System.out.println(bl1 && bl2); //[O]
		
		
		boolean bl3 = '가' > 30000;
		System.out.println("bl3="+bl3);
		

		
		
		
		
		
		
	}//main

}//class
