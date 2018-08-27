package stringclass11;

public class StringBufferClass {

	public static void main(String[] args) {
		// StringBuffer buf="Hello"; [X] 직접대입불가
		StringBuffer buf = new StringBuffer();
		System.out.println("buf : "+buf);
		System.out.println("buf.toString() : "+buf.toString());
		System.out.println("buf.length() : "+buf.length());
		System.out.println("기본버퍼크기 : "+buf.capacity());
		String str=new String();
		System.out.println("str : "+str);
		System.out.println("str.length() : "+str.length());
		
		buf.append("JAVA");
		System.out.println("[JAVA문자열 저장후]");
		System.out.println("buf : "+buf);
		System.out.println("buf : "+buf.toString());
		System.out.println("buf.length : "+buf.length());
		System.out.println("기본버퍼크기 : "+buf.capacity());
		
		
		buf.append("0123456789").append("ABCD");
		System.out.println("[JAVA문자열 추가 저장 후]");
		System.out.println("buf : "+buf);
		System.out.println("buf : "+buf.toString());
		System.out.println("buf.length : "+buf.length());
		System.out.println("버퍼크기 : "+buf.capacity());
		
		
		//trimToSize 저장된 문자열만큼 버퍼크기를 줄인다
		buf.trimToSize();
		System.out.println("[trimToSize호출 후]");
		System.out.println("버퍼크기 : "+buf.capacity());
		System.out.println();//줄바꿈
		
		
		//delete(int start, int end)
		buf.delete(4, 14);
		System.out.println("[delete 삭제 후]");
		System.out.println("삭제 후 버퍼크기 :"+buf.capacity());
		System.out.println("buf : "+buf);
		System.out.println();// 줄바꿈
		
		buf.deleteCharAt(4);
		System.out.println("[deleteCharAt 삭제 후]");
		System.out.println("buf : "+buf);
		System.out.println();
		
		
		//inesrt(int index, String str) intex위치에 문자열 삽입
		System.out.println("[문자열 삽입 후]");
		System.out.println("buf : "+buf.insert(4, 12345));
		System.out.println("buf : "+buf.insert(0, "가나다라"));
		System.out.println();
		
		int start=buf.indexOf("JAVA")+"JAVA".length();
		int end=buf.length();
		System.out.println("JAVA문자열 이후부터 끝까지 삭제:"+buf.delete(start, end));
		
		//replacd
		start=buf.indexOf("JAVA");
		end=start+"JAVA".length();
		System.out.println("교체 후 : "+buf.replace(start, end, "자바"));
		System.out.println();
		
		buf=new StringBuffer("123456789");
		System.out.println("buf : "+buf);
		System.out.println("buf : "+buf.toString());
		System.out.println("buf.length : "+buf.length());
		System.out.println("기본버퍼크기 : "+buf.capacity());
		
		
		//문자열 반대로 배치 reversc()
		System.out.println("문자열을 거꾸로"+buf.reverse());
		
		String string="HELLO WORLD";
		buf=new StringBuffer(string);
		System.out.println("문자열을 거꾸로"+buf.reverse());
		
		
		
		
		
		
		
		//System.out.println(reverse(string));
		
	}//main
	
	//문제 String클래스의 메소드를 이용하여 StringBuffer클래스의 reverse메소드와 같은 기능을 하는 메소드를 정의하라
	public static String reverse(String value) {
		//방법1] return new StringBuffer(value).reverse().toString();
		//방법2] 
		/*
		char[] src= value.toCharArray();
		char[] dest = new char[src.length];
		for(int i=src.length-1;i>=0;i--) {
			dest[dest.length-1-i]=src[i];
		}
		return String.valueOf(dest);
		}
		*/
		//방법3]
		/*
		char[] src= value.toCharArray();
		for(int i=0;i<src.length/2;i++) {
			char temp = src[i];
			src[i]=src[src.length-1-i];
			src[src.length-1-i]=temp;
		}
		return String.valueOf(src);
	}
		*/
		//방법4]
		char[] src= value.toCharArray();
		StringBuffer buf=new StringBuffer();
		for(int i=src.length-1;i>=0;i++) {
			buf.append(src[i]);
		}
		return buf.toString();	
	}
	
}//class
