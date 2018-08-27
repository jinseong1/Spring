package etcclass12;

import java.util.Random;

public class Mathclass {

	
//	문]Math클래스의 abs()메소드와 같은 기능을 하는 
//	메소드를 정의하라

	private static int abs(int value) {
		return value<0? -value : value;
	}//abs
	private static long round(double value) {
		return value>0?(long)(value+0.5):(long)(value-0.4);
	}//round
	
	private static int pow(int i, int j) {
		int number=1;
		for(int k=0; k<j;k++)
			number*=i;
		return number;
	}//pow
	
	
	public static void main(String[] args) {
//		Math클래스는 인스턴스화 불가
//		Math math = new Math(); 
//		Math클래스의 정적 멤버 상수
		System.out.println("PI : "+Math.PI);
		float f=3.14F;
		double d=-100.9;
		int num =-10;
		System.out.println("[abs메소드]");
		System.out.println("f :"+Math.abs(f));
		System.out.println("d :"+Math.abs(d));
		System.out.println("num :"+Math.abs(num));
	
		System.out.println(abs(-100));
		System.out.println(abs(100));
		System.out.println(abs(-99));
		
		//올림값
		System.out.println("[ceil()Mathod]");
		System.out.println(Math.ceil(3.4));
		System.out.println(Math.ceil(3.9));
		System.out.println(Math.ceil(-3.4));
		
		//내림값
		System.out.println("[floor()Mathod]");
		System.out.println(Math.floor(3.4));
		System.out.println(Math.floor(3.9));
		System.out.println(Math.floor(-3.4));
		
		//반올림
		System.out.println("[round()Mathod]");
		System.out.println(Math.round(3.49999999));
		System.out.println(Math.round(3.54444444));
		System.out.println(Math.round(-1.4));
		System.out.println(Math.round(-1.8));
		System.out.println(Math.round(-0.4));
		System.out.println(Math.round(-0.8));
		System.out.println(Math.round(-1.5));
		
		
		System.out.println("[My make round()Mathod]");
		System.out.println(round(3.49999999));
		System.out.println(round(3.54444444));
		System.out.println(round(-1.4));
		System.out.println(round(-1.8));
		System.out.println(round(-0.4));
		System.out.println(round(-0.8));
		System.out.println(round(-1.5));
		
		
		//최대값, 최소값
		System.out.println("[Max,min()Mathod]");
		System.out.println(Math.max(100, 99));
		System.out.println(Math.min(100, 10));
		
		//제곱값
		System.out.println("[pow()Mathod]");
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(3, 2));
		
		System.out.println("[My make pow()Mathod]");
		System.out.println(pow(2, 3));
		System.out.println(pow(3, 2));
		
		
		System.out.println("[Random()Mathod]");
		Random rand= new Random();
		System.out.println(rand.nextInt(6)+5);
		
	}//main
}//class
