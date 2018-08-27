package wrapperclass10;

import java.util.Scanner;

public class WrapperClass02 {

	public static void main(String[] args) {
		/*[Integer Wrapper클래스의 주요 메소드]
		1] 숫자형식의 문자열을  숫자로 변경   
		   static int parseInt(String s)  ;
		   static Integer valueOf(String s)  ;
		*/
		String strNumber="1000";
		System.out.println("10+strNumber:"+(10+strNumber));
		System.out.println("strNumber를 숫자로 변경1:"+(10+Integer.parseInt(strNumber)));
		System.out.println("strNumber를 숫자로 변경2:"+(10+Integer.valueOf(strNumber)));
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요?");
		String ageString= sc.nextLine();
		System.out.println("당신의 10년후 나이: "+(10+Integer.parseInt(ageString)));
		*/	
		
		System.out.println("문자열 1000을 byte형 값으로 변경:"+Integer.valueOf(strNumber).byteValue());
		//int(매개변수 타입) -> Integer타입 전달:오토 언박싱
		System.out.println("문자열 1000을 16진수값 문자열로 변경:"+Integer.toHexString(Integer.valueOf(strNumber)));
		//int Integer.parseInt("숫자형식의 문자열"):
		//int형은 기본 데이터형임으로 멤버가 없다.
		int num1 = Integer.parseInt(strNumber);
		Integer numObj=num1;//오토박싱
		System.out.println("숫자 1000을 short형값으로 변경:"+numObj.shortValue());
		String money="1억원";
		//Integer.parseInt(money);//[x]실행시 NumberFormatException예외 발생
		String floatString="3.14";
		//Integer.parseInt(floatString);
		//실수형태(소수점이 포함된)의 문자열을 실수로 변경시:Float이나 Double 타입 사용
		System.out.println(Float.parseFloat(floatString)+10);
		System.out.println(Double.parseDouble(floatString)+10);
		//2]2진수 나 8진수나 16진수형식의 문자열을
		//십진수로 바꿀때 사용하는 메소드
		//static int parseInt(String s, int radix)  
		//static Integer valueOf(String s, int radix) 
		System.out.println("이진수 형태의 문자열 1000을 십진수로:"+Integer.parseInt(strNumber,2));
		System.out.println("8진수 형태의 문자열 1000을 십진수로:"+Integer.parseInt(strNumber,8));
		System.out.println("16진수 형태의 문자열 1000을 십진수로:"+Integer.parseInt(strNumber,16));
		//3]숫자를 문자열로 변경:
		//static String toString(int i):	
		//String toString()
		int num2=1000;
		//3-1]정적 메소드 사용
		System.out.println(Integer.toString(num2)+10);//숫자 1000 ->문자열 "1000"으로 변경
		//3-2]인스턴스형 메소드 사용
		Integer intObject = num2;//오토박싱
		System.out.println(intObject.toString()+10);
		/*4]십진수를 각 진수로 변환
	 	static String toBinaryString(int i)  :2진수
	   	static String toOctalString(int i)  :8진수
	   	static String toHexString(int i)  :16진수
		 */
		System.out.println(Integer.toHexString(15));
		Integer object =77;//오토박싱
		System.out.println("object="+object);
		System.out.println("object.toString()="+object.toString());
		System.out.println("object.hashCode()="+object.hashCode());
		
		WrapperClass02 wc = new WrapperClass02();
		//메모리 주소 출력됨(패키지명.클래스명@16진수형태)
		System.out.println("wc="+wc);
		System.out.println("wc.toString()="+wc.toString());
		//메모리 주소 출력됨(십진수 형태)
		System.out.println("wc.hashCode()="+wc.hashCode());
		
		//결론]
		//[1]숫자형식의 문자열을 숫자로:parse계열  메소드
		//static int parseInt();		
		//[2]valueOf()계열
		/*static Integer valueOf(int i) :
		 * int->Integer
		 * 위는 JDK5.0이후 부터는 의미없음.
		 * 오토박싱을 사용하면 되니까		
		 */		
		//[3]숫자를 문자열로: toString()계열
		//static String toString(int);
		//String toString()		
		//[1]번과 [3]은 기억
		Scanner sc = new Scanner(System.in);
		System.out.println("몸무게를 소수점 둘째 자리까지 입력하세요?");
		String string = sc.nextLine();
		//1]입력받은 몸무게에 10KG을 더해서 출력
		//방법1]
		//float weight=Float.parseFloat(string)+10;
		//방법2]오토박싱
		Float weight=Float.parseFloat(string)+10;
		System.out.println("현재 몸무게에 10KG추가시 : "+weight);
		//2]몸무게를 문자열로 변환해서 문자열의 길이 구하기
		//방법1]
		System.out.println(Float.toString(weight).length());
		//방법2]
		System.out.println(weight.toString().length());
	}//////////main

}//////////////class
