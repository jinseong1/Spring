package operlater02;

public class Beekyo0P {

	public static void main(String[] args) {
		int num1=10, num2=10;
		System.out.println(num1>=num2);
		
		boolean b = num1>=num2;
		System.out.printf("%d >= %d 의 결과 :%b%n",num1,num2, b);
		b = num1 != num2;
		System.out.printf("%d != %d 의 결과 :%b%n",num1,num2, b);
		b = 15%3*2+4 > (10-2)*4 != true;		
		System.out.printf("15%%3*2+4 > (10-2)*4 != true의 결과 : %b%n",b);
		// 형식문자열을 구성한다. 
		// 
		
	}//main

	
}//class
