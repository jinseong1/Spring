package stringclass11;

class Aclass{}
class Bclass{}
public class StringBasic {

	public static void main(String[] args) {
		/*
		[값(데이타) 비교]
		기본 자료형에서 ==는 실제 저장된 값 
		비교하는 비교 연산자.
		참조형에서 == 는  주소 비교
		(단,같은 클래스 타입끼리만 비교가능)
		*/
		int num1=10,num2=20;
		String strResult = num1 == num2   ? "데이타가 같다" : "데이타가 다르다";
		System.out.println(strResult);
		//인스턴스화]
		Aclass ac = new Aclass();
		Bclass bc = new Bclass();
		//타입이 다름으로 주소비교 불가]
		//strResult = ac == bc   ? "주소가 같다" : "주소가 다르다";
		Aclass ac2 = new Aclass();
		//타입이 같음(Aclass타입)으로 주소비교(==) 가능]
		strResult = ac == ac2   ? "주소가 같다" : "주소가 다르다";
		System.out.println(strResult);
		System.out.println("ac="+ac + ",ac2="+ac2);
		ac =ac2;
		strResult = ac == ac2   ? "주소가 같다" : "주소가 다르다";
		System.out.println(strResult);
		System.out.println("ac="+ac + ",ac2="+ac2);
		//타입이 다름으로 대입연산도 불가]
		//ac =bc;//[x]단,타입이 다르더라도 두 클래스간의 상속관계가
               //존재하면 대입 및 형변환 가능
		//타입이 다르더라도 주소 비교 가능-equals()메소드 사용시]
		//결론-참조형의 주소 비교시에는 ==보다는 equals()사용
		strResult = ac.equals(bc)   ? "주소가 같다" : "주소가 다르다";
		System.out.println(strResult);
		System.out.println("ac="+ac+",bc="+bc);
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		
		System.out.println("[new 연산자 사용]");
		System.out.println("==로 비교 : "+(str1==str2));//false
		//String클래스의 equals()메소드(Object로 
		//부터 상속받은 메소드)
		//실제 저장된 문자열을 비교하도록 오버라이딩됨]
		System.out.println("equals()메소드로 비교 : "+(str1.equals(str2)));		
		//String클래스는 프로그래밍에서 기본 자료형처럼
		//워낙 많이 쓰기때문에
		//new 연산자로  메모리를 할당 안하고
		//바로 = "문자열" 대입이 가능.
		String str3="WORLD";		
		String str4="WORLD";
		System.out.println("[new 연산자 미사용-직접 문자열 저장]");
		System.out.println("==로 비교 : "+(str3==str4));
		System.out.println("equals()메소드로 비교 : "+(str3.equals(str4)));
		/*
		※String클래스에서 실제 저장된 문자열 비교시에는
		  equals()메소드 사용 (==는 안됨)
		
		 String클래스에서 Object클래스의 equals()메소드를 
		 주소값 비교가 아니라 실제 저장된 문자열값을 
		 비교하도록 오버라이딩 해놓음
		 ※Object클래스의 equals()메소드는 원래 두 클래스간의 
		   주소 비교를 하는 메소드임 		 
		 */
		String str5="Hello";
		String str6="HELLO";
		//[대소문자 구분해서 비교-equals()메소드]
		System.out.println(str5.equals(str6)?"문자열이 같다" :"문자열이 다르다");
		//[대소문자 구분하지 않고 비교-equalsIgnoreCase()메소드]
		System.out.println(str5.equalsIgnoreCase(str6)?"문자열이 같다" :"문자열이 다르다");
		/*
		역시 Wrapper클래스처럼 String클래스에서도
		Object클래스의 toString()메소드를 
		메모리 주소가 아닌 실제 저장된
		문자열을 반환하도록 오버라이딩 해 놓음
		*/
		String str7 = new String("자바");
		System.out.println("str7="+str7);
		System.out.println("str7.toString()="+str7.toString());
	}/////main

}////class
