package datetype01;

public class SilsuType {

	public static void main(String[] args) {
		//float, double
		//고정소수점방식1비트 + 15비트(정수)+16비트(실수),
		//부동소수점방식 -1비트 + 8비트(지수부)+23비트(가수부)		
		//byte<short<int<long(정수)<<float(실수)<double
		//float a = 10; //실수는 기본적으로 더블형으로 인식된다.
		
		long ln = 100;
		float f1 = 200;
		//long ln1=ln+f1;
		float f2=ln+f1; // [O]
		System.out.println("f2="+f2);
		
		long ln1=ln+(long)f1;
		System.out.println("ln1="+ln1);
		
		ln1=(long)(ln+f1);
		System.out.println("ln1="+ln1);
		
		float kor = 99, eng = 80, math = 96;
		float avg = (kor+eng+math) / 3;
		System.out.println("평균:"+avg);
		//float소수점 6자리, double 소수점 14자리
		System.out.println("평균(소수점 제거):"+(int)avg);
		
		int kor1 = 99, eng1 = 80, math1 = 96;
		double avg1 = (kor1+eng1+math1) / 3.0;
		System.out.println("평균:"+avg1);
		System.out.println("평균(소수점 제거):"+(int)avg1);
		
		
		
		//float f3 = 100;
		// float f4 = 3.14; //[X]
		//float f4 = 3.14F; //[O]
		float f4 = (float)3.14;
		System.out.println("f4="+f4);
		f4 = 3.14F;
		System.out.println("f4="+f4);
		
		
		
		float ff1=100,ff2=3.14F,fresult;
		double d1=100,d2=3.14,dresult;
		fresult = ff1+ff2;
		System.out.println("fresult="+fresult);
		dresult = d1+d2;
		System.out.println("dresult="+dresult);
		dresult = ff1+d2;
		System.out.println("dresult="+dresult);
		
		
		//문제 1. int, float, double 의 반지름 값을 구하시오
		
		int redius = 10;
		double pi = 3.14;
		
		int intredius;
		float flredius;
		double doredius;
		
		intredius = (int)(redius*redius*pi);
		flredius = (float)(redius*redius*pi);
		doredius = redius*redius*pi;
		
		//System.out.println(redius*redius*(int)pi); //[X]
		//System.out.println(redius*redius*(float)pi);
		//System.out.println(redius*redius*pi);
		//System.out.println((int)(redius*redius*pi));
		//System.out.println((float)(redius*redius*pi));
		//System.out.println(redius*redius*pi);
		
		System.out.println("int:"+intredius);
		System.out.println("float:"+(int)flredius);
		System.out.println("double:"+(int)doredius);
			
		
		
		

	}//main

}//class
