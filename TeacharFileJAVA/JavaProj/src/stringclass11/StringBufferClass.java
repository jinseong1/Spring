package stringclass11;

public class StringBufferClass {
	/*StringBuffer 클래스:
	 String클래스는 String클래스의 메서드를 이용해서
	 새로운 문자열을 생성하면 원래 문자열은 변하지 않고
	 새롭게 생성된 문자열을 저장하기 위해서
	 메모리가 새롭게 생성된다.
	 이런 메모리 낭비를 막기위해서
	 StringBuffer클래스가 사용된다.
	 즉 StringBuffer클래스는 원래값이 변한다
	 (메모리가 계속 생기지 않고)
	  */
	public static void main(String[] args) {
		/* [StringBuffer클래스의 주요 메소드] */
		//[StringBuffer클래스를 생성(인스턴스화,객체화)
		//  하면서 문자열 초기화 하지 않기]
		//StringBuffer buf ="HELLO";//[X]직접 대입 불가
		StringBuffer buf = new StringBuffer();
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf.length()="+buf.length());
		System.out.println("기본 버퍼 크기:"+buf.capacity());
		//위는 스트링 클래스를 아래처럼 생성한 거와 같다
		String str="";
		System.out.println("str="+str);
		System.out.println("str.length()="+str.length());
		//1]문자열 저장(계속 연결):StringBuffer append("문자열");
		buf.append("JAVA");
		System.out.println("[JAVA문자열 저장후]");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열 길이:"+buf.length());
		System.out.println("버퍼 크기:"+buf.capacity());
		buf.append("0123456789").append("ABCD");
		System.out.println("[JAVA문자열 저장후]");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열 길이:"+buf.length());
		System.out.println("버퍼 크기:"+buf.capacity());
		//2]trimToSize():저장된 문자열만큼 버퍼크기를 줄인다
		buf.trimToSize();
		System.out.println("trimToSize()호출 후 버퍼 크기:"+buf.capacity());
		//3]StringBuffer delete(int start, int end) 
		//:start인덱스부터 end-1 인덱스까지의 문자열을 삭제
		buf.delete(4, 14);//숫자 부분만 삭제
		System.out.println("삭제 후:buf="+buf);
		System.out.println("삭제 후 버퍼 크기:"+buf.capacity());
		//4]StringBuffer deleteCharAt(int index)  
				//:index위치의 하나의 문자 삭제
		buf.deleteCharAt(4);
		System.out.println("한 문자 삭제 후:buf="+buf);
		//5]StringBuffer insert(int index, String str)  
		//index 위치에 특정 문자열 삽입
		System.out.println("문자열 삽입후:"+buf.insert(4, "12345"));
		System.out.println("0번째 인덱스에 문자열 삽입:"+buf.insert(0, "가나다라"));
		//가나다라JAVA12345BCD
		//JAVA문자열만 알고 있다고 가정하고
		//JAVA이후의 문자열부터 끝까지 삭제하자
		int start = buf.indexOf("JAVA")+"JAVA".length();
		int end   = buf.length();
		System.out.println("JAVA문자열 이후 부터 끝까지 삭제:"+buf.delete(start, end));
		//6]StringBuffer replace(int start,int end,String str)
		//  start인덱스부터 end-1인덱스까지의 문자열을 
		//  str로 바꾼다.
		//가나다라JAVA  =>가나다라자바
		start = buf.indexOf("JAVA");
		end   = start+"JAVA".length();
		System.out.println("교체 후 : "+buf.replace(start, end, "자바"));
		//[특정 문자열로 초기화 하면서 StringBuffer클래스 객체 생성]
		buf = new StringBuffer("123456789");
		System.out.println("buf="+buf);
		System.out.println("buf.toString()="+buf.toString());
		System.out.println("buf에 저장된 문자열 길이:"+buf.length());
		System.out.println("버퍼 크기:"+buf.capacity());
		//7]StringBuffer reverse() 문자열을 반대로 배치
		System.out.println("문자열을 거꾸로:"+buf.reverse());
		//String타입을 StringBuffer로 변환후 reverse()호출
		String string="HELLO WORLD";
		buf = new StringBuffer(string);
		System.out.println("문자열을 거꾸로(StringBuffer 의 reverse()메소드사용):"+buf.reverse());
		//문]String클래스의 메소드를 이용해서 StringBuffer클래스의
		//   reverse()메소드와 같은 기능을 하는 메소드를 정의해라
		
		System.out.println("문자열을 거꾸로(내가 만든 reverse()메소드사용) :"+reverse(string));
	}///////////////main
	public static String reverse(String value) {
		//방법1]StringBuffer클래스의 reverse()메소드 이용
		//return new StringBuffer(value).reverse().toString();
		/*
		//방법2]char[] 2개 사용
		//원본 배열]
		char[] src=value.toCharArray();		
		//거꾸로 바꿔서 저장할 배열]
		char[] dest = new char[src.length];
		for(int i=src.length-1;i>=0;i--)
			dest[dest.length-1 - i]=src[i];
		//char[]를 String타입으로 변환해서 반환
		return String.valueOf(dest);
		*/
		//방법3]반복을 2분의 1로 줄이고 char[]하나 사용
		/*
		char[] src=value.toCharArray();		
		for(int i=0; i < src.length/2 ;i++) {
			char temp = src[i];
			src[i]= src[src.length-1-i];
			src[src.length-1-i] =temp;
		}
		return String.valueOf(src);*/
		//방법4]char[] 요소를 String에 누적
		char[] src=value.toCharArray();		
		StringBuffer buf = new StringBuffer();
		for(int i=src.length-1; i >=0;i--) {
			buf.append(src[i]);
		}
		return buf.toString();
	}///////////
	

}//////////////////class
