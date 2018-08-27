package datetype01;

public class StringType {

	public static void main(String[] args) {
		// String은 문자를 저장할 수 있는 타입
		int number; //변수 선언
		number = 99; //변수 초기화
		//참조형과 기본자료형 사이에는 형변환 불가
		//String strnumber = (String)number; //[X] 
		//int intString = (int)"100"; //[X]
		
		String strNumber = "100";
		System.out.println(strNumber+number); //결과는 10099
		
		 String newString = new String("new 연산자 사용");
		 System.out.println(newString);
		 
		 String stringLikeBasic = "기본자료형처럼 문자열 저장";
		 System.out.println(stringLikeBasic);
		 // +가 문자열에 사용될때는 연결을 의미

		 String plusString;
		 plusString=newString+stringLikeBasic;
		 System.out.println(plusString);
		 int kor=100,eng=100,math=100;
		 System.out.println("총점: "+kor+eng+math); //결과값 총점: 100100100
		 System.out.println("총점: "+(kor+eng+math)); // 총점: 300
		  
		 
		 
		
		
		
		
		
		
	}

}
