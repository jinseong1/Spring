package stringclass11;

class Aclass{}
class Bclass{}

public class StringBasic {

	public static void main(String[] args) {
		//값 비교는 == 를 사용했음
		//하지만 참조형에 ==는 주소 비교임(같은 클래스 타입까지만 가능하다)
		int num1=10, num2=20;
		String strResult = num1==num2 ? "데이터가 같다" : "데이터가 다르다" ;
		System.out.println(strResult);
		Aclass ac = new Aclass();
		Bclass bc = new Bclass();
		// strResult = ac == bc ? "주소가 같다" : "주소가 다르다" ;  // 타입이 다르므로 주소비교 불가
		Aclass ac2= new Aclass();
		//타입이 같으므로 주소비교 가능
		strResult = ac == ac2 ? "주소가 같다" : "주소가 다르다" ;
		System.out.println(strResult);
		System.out.println("ac : "+ac);
		System.out.println("ac2 : "+ac2);
		
		ac=ac2;
		strResult = ac == ac2 ? "주소가 같다" : "주소가 다르다" ;
		System.out.println(strResult);
		System.out.println("ac : "+ac);
		System.out.println("ac2 : "+ac2);
		
		
		// ac=bc; [x] // 타입이 다르므로 주소비교 불가 단 두 클래스간 상속관계가 존재하면 대입 및 형변환 가능
		// 결론 참조형의 주소 비교시에는 == 보다는 equals()사용
		
		strResult = ac.equals(bc) ? "주소가 같다" : "주소가 다르다" ; // 타입이 다를때에는 equals사용하여 주소 비교
		System.out.println(strResult);
		System.out.println("ac : "+ac);
		System.out.println("bc : "+bc);
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		System.out.println("[New 연산자 사용]");
		System.out.println("==로 비교 : "+(str1==str2));          // 주소를 비교하므로 false결과가 나온다
		System.out.println("equals로 비교 : "+str1.equals(str2)); // equals는 저장된 데이터 문자열을 비교하므로 true의 결과가 나온다
		
		String str3="WROLD";
		String str4="WROLD";
		System.out.println("[New 연산자 미사용-직접 문자열 저장]");
		System.out.println("==로 비교 : "+(str3==str4));     
		System.out.println("equals로 비교 : "+str3.equals(str4));
		
		String str5="Hello";
		String str6="HELLO";
		//대소문자 구분해서 비교eqluas비교
		System.out.println(str5.equals(str6)?"문자열이 같다":"문자열이 다르다");
		//equalsIgnoreCase 는 대소문자 구분없이 비교한다
		System.out.println(str5.equalsIgnoreCase(str6)?"문자열이 같다":"문자열이 다르다");
		
		String str7=new String("자바");
		System.out.println("str7 : "+str7);
		System.out.println("str7 : "+str7.toString());
		
		
	}//main
}//class
