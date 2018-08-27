package datetype01;

public class JungsuType {

	public static void main(String[] args) {
		byte b1;
		b1 = 127;
			System.out.println("b1="+b1);
		//b1 = 128;//[X] 강제로 형변환
		b1 = (byte)128; //[O] 캐스팅연산자
			System.out.println("b1="+b1); //예상치 못한 값이 나옴
		byte b2=20, b3=30;
		//byte b4 = b2+b3; //[X] 
		int num1 = b2+b3;
			System.out.println(num1);
		byte b4 = (byte)(b2+b3);//[O]
			System.out.println("b4="+b4);
		
		short s1 = 1000, s2 = 2000;
		//short s3 = s1+s2; //[X]
		num1 = s1+s2; //[O]
		System.out.println("num1="+num1);
		short s3 = (short)(s1+s2); //[O]
		System.out.println("s3="+s3);
		
		//s3 = b1+s1;
		num1 = b1+s1;
		System.out.println("num1="+num1);
		s3 = (short)(b1+s1);
		System.out.println("s3="+s3);
		
		int num2 = 100, num3 = 200;
		long ln1 = 1000, ln2 = 2000;
		num1 = num2+num3;
		System.out.println("num1="+num1);
		
		long ln3 = ln1+ln2;
		System.out.println("ln3="+ln3);
		ln3 = ln1+num1;
		System.out.println("ln3="+ln3);
		
		//int num4 = ln1+num2; //[X]
		int num4 = (int)(ln1+num2); //[O]
		num4 = (int)ln1+num2; // [O]
		System.out.println("num4="+num4);
		
		
		
		//long ln4 = 220000000; // long 형은 상수 뒤에 바로 L 붙어준다
		long ln4 = 220000000L; // long 형은 상수 뒤에 바로 L 붙어준다
		System.out.println("ln4="+ln4);
		
		
		num4 = (int)220000000L;
		System.out.println("num4="+num4);
		
		
		num4 = 0412; //4+8^2 + 1*8^1 + 2*8^0=266
		// 숫자앞에 0을 붙이면 8진수를 의미한다(알고리즘 프로그램 짤때 많이 씀)
		System.out.println("num4="+num4);
		
		num4 = 0x12; //숫자앞에 0x를 붙이면 16진수를 의미
		//1*16^1 + 2*16^0 = 16+2=18
		System.out.println("num4="+num4);
		
		int kk, ee, mm, total; //변수 선언
			kk = 89;  //변수 지정
			ee = 99;
			mm = 78;
			total = kk+ee+mm;
			
			System.out.println("한국어="+kk); // 결과
			System.out.println("영어="+ee);
			System.out.println("수학="+mm);
			System.out.println("한영수의 총합="+total);
					
		
		
		
	}//////main

}/////class


