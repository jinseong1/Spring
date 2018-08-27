package stringclass11;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import wrapperclass10.WrapperClass03;

public class StringMethod {

	public static void main(String[] args) {
		//String class의 주요 메소드
		String str1="Welcome To Java!";
		String str2="안녕 자바!";
		//1] int length() : 문자열의 길이 반환
		System.out.println("[length()메소드]");
		System.out.println("str1의 문자열의 길이 : "+str1.length());
		System.out.println("str2의 문자열의 길이 : "+str2.length());
		//2] char charAt(int index)
		//문자열에서 index에 해당하는 하나의 문자를 반환한다.
		//index는 0부터 시작한다.
		System.out.println("str1의 5번째 문자 : "+str1.charAt(4));
		System.out.println("str2의 5번째 문자 : "+str2.charAt(4));
		//가가 인덱스 위치에 해당하는 문자열 출력
		for(int i=0;i<str1.length();i++) {
			System.out.printf("%d인덱스에 해당하는 문자 : %c%n",i,str1.charAt(i));
		}
		String jumin="012345-2234567";
		System.out.println(jumin.charAt(7)=='1'? "남자":"여자");
		
		int lastJumin=2234567;
		Integer inst = Integer.valueOf(lastJumin);
		String lastString=inst.toString();//inst가 참조하느느 메모리의 데이타(1234567)를 문자열로 변경
		System.out.println(lastString.charAt(0)=='2'?"여자":"남자");
		
		//방법 2]
		lastString=Integer.toString(lastJumin); // int → String
		System.out.println(lastString.charAt(0)=='2'?"여자":"남자");
		
		//방법 3]
		inst=lastJumin; //int →Integer Autoboxing
		System.out.println(inst.toString().charAt(0)=='1'?"남자":"여자");
		
		//3]
		System.out.println("str1의 4번째 문자의 아스키(유니코드) 값 :"+str1.codePointAt(3));
		System.out.println("str2의 4번째 문자의 아스키(유니코드) 값 :"+Integer.toHexString(str2.codePointAt(3)));
		System.out.println(WrapperClass03.isNumber("100")?"숫자의 형식이다":"숫자형식이 아니다");
		System.out.println(WrapperClass03.isNumber("10A")?"숫자의 형식이다":"숫자형식이 아니다");
		
		//두 문자열을 비교하는데 첫번째 문자부터 순차적으로 비교해나간다 첫번째 문자열의 아스키코드값이 크면
		//양수 첫번째 문자열의 아스키 코드값이 작으면 음수 첫번째와 주번째 문자열이 모두 같으면 0을 반환한다
		//두 문자열의 비교시에는 주로 equals()메소드 사용 compareTo()메소드는 문자열로 정렬할때 사용
		//(오버라이딩한 메소드 안에서)
		String str3="ABc";//c=99
		String str4="ABC";//C=67
		System.out.println(str3.compareTo(str4)); // 결과값 :  32
		System.out.println(str4.compareTo(str3)); // 결과값 : -32
		System.out.println("ABCD".compareTo("ABCD")==0?"두 문자열이 같다":"두 문자열이 다르다");
		System.out.println("ABCD".compareTo("A"));// 결과값 : 3(남은 문자수)
		System.out.println("ABCD".compareTo("a"));// 결과값 : 32
		System.out.println("A".compareTo("ABCD"));// 결과값 : -3(부족한 문자수)
		
		
		//5] String concat(String str) : 두 문자열을 연결할때    + 와 같은 기능
		System.out.println("JAVA".concat(" WORLD").concat(" HI"));
		System.out.println("JAVA"+" WORLD"+" HI");
		
		//6] contains()
		//   문자열에 특정 문자열이 포함되었지는 판단하는 메소드, 특정 문자열이 포함되었으면 ture, 아니면 false
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
		String email = "kim@nate.com";
		System.out.println(email.contains("@")?"이메일 형식이다":"이메일 형식이 아니다");
		
		
		//7] copyValueOf  char를 문자열로 변경
		char[] charr = {'A','C','A','D','E','M','Y','!'};
		System.out.println(String.copyValueOf(charr));
		System.out.println(String.copyValueOf(charr,3,4));  // 결과값 : DEMY
		System.out.println(String.valueOf(charr,0,charr.length));
		
		//위를 모른다면 아래와 같이 코드를 만들어야한다
		String stringPlus="";
		for(int i=0;i<charr.length;i++) {
			stringPlus+=charr[i];
			System.out.println(stringPlus);
		}
		
		
		//8] endWith
		//   문자열이 특정 문자열로 끝나면 true 아니면 false
		System.out.println("www.nate.com".endsWith(".com"));
		System.out.println("www.nate.com".endsWith(".co.kr"));
		
		
		// 9] startsWith()
		// 문자열이 특정 문자열로 시작되면  true 아니면 false
		System.out.println("www.nate.com".startsWith("www"));
		System.out.println("www.nate.com".startsWith("http"));
		System.out.println("www.nate.com".startsWith("nate",4));
		
		
		//10] format()
		//	    출력 형식을 지정하여 문자열로 반환할때
		System.out.printf("국어 : %d 영어 : %d 수학 : %d 평균 : %.2f%n",90,90,90,270/3.0);
		System.out.format("국어 : %d 영어 : %d 수학 : %d 평균 : %.2f%n",90,90,90,270/3.0);
		System.out.println(String.format("국어 : %d 영어 : %d 수학 : %d 평균 : %.2f",90,90,90,270/3.0));
		
		//11] getBytes()
		//	  문자열을 byte형 배열로 반환해줌, 배열로 반환될때 아스키 코드값으로 변환 됨
		System.out.println();
	    byte[] by="ABCD".getBytes();
	    for(int i=0;i<by.length;i++) {
	    //	System.out.println(String.format("by[%d]=%d",i,by[i])); 이것은 아스키 코드로 출력한 것
	    	System.out.println(String.format("by[%d]=%c",i,by[i])); // 이것은 문자로 출력한 것
	    }
	    System.out.println();// 줄바꿈
	    
	    
	    //12] toCharArray()  7번과 함께
	    //	  문자열을 char형 배열로 반환
	    charr="가나다라".toCharArray();
	    for(int i=0;i<charr.length;i++) {
	    	System.out.println(String.format("by[%d]=%c",i,charr[i]));
	    }
	    
	    //13] indexOf
	    // 	  특정 문자열의 시작 인덱스를 반환
	    System.out.println("JAVA".indexOf("JAVA"));
	    System.out.println("JAVA".indexOf("AVA"));
	    System.out.println("JAVA".indexOf("A"));
	    System.out.println("JAVA".indexOf("VA"));
	    System.out.println("JAVA".indexOf("aVA"));//특정 문자열이 없으므로 인덱스 반환을 할 수없어 결과물 -1이 나온다
	    jumin="123456-1234567";
	    int index=jumin.indexOf("-")+1;
	    System.out.println(jumin.charAt(index)=='1'?"남자":"여자");
	    
	    
	    
	    //14] lastIndexOf  특정 문자열의 마지막 인덱스를 반환
	    System.out.println("JAVAAVA".lastIndexOf("AVA"));
	    System.out.println("JAVA".lastIndexOf("A"));
	    System.out.println("JAVA".lastIndexOf("VA"));
	    System.out.println("JAVA".lastIndexOf("aVA"));
	    System.out.println("MY.FILE.TXT".lastIndexOf("."));// 확장자 찾는 용도로 많이 사용한다
	    
	    
	    //15] String replace 문자열을 서로 바꾼다
	    String str5=str1.replace('T', 'G');  //  T를 G로 변경한다
	    System.out.println("str1 : "+str1);
	    System.out.println("str5 : "+str5);
	    System.out.println(str1.replace('o', 'a'));
	    System.out.println(str1.replace("Java", "Korea"));
	    System.out.println(str1.replace("Welcome", "안녕"));
	    System.out.println("Hi Java".replace("Hello", "안녕"));
	    if("Hi Java".indexOf("Hello") !=-1) {
	    	System.out.println("Hi Java".replace("Hello", "안녕"));
	    	System.out.println("Hello를 안녕으로 변경");
	    }
	    else System.out.println("Hello라는 문자열이 없어요");

	    
	    //16] String[] split(String regex)
	    String tel="010-1234-5678";
	    String[] strarr=tel.split("-");
	    for(int i=0; i<strarr.length;i++) {
	    	System.out.println(String.format("strarr[%d]=%s", i,strarr[i]));
	    }
	    strarr=tel.split("@");
	    for(int i=0; i<strarr.length;i++) {
	    	System.out.println(String.format("strarr[%d]=%s", i,strarr[i]));}
	    email="kim@naver.com";
	    strarr=email.split("\\."); // .은 정규표현식이 아니라는 것을 알려주기 위해 \\를 붙인다
	    for(int i=0; i<strarr.length;i++) {
	    	System.out.println(String.format("strarr[%d]=%s", i,strarr[i]));}
	    
	    
	    //17] substring(int beginIndex)
	    // 시작인덱스부터 문자열 끝까지 추출하는 메소드
	    System.out.println("welcome".substring(3));
		String filename="my.file.homework.ppt";
		int beginIndex=filename.lastIndexOf(".")+1;
		System.out.println("확장자 : "+filename.substring(beginIndex));
		
		
		//18] substring
		//	시작엔덱스부터 끝 엔덱스 -1까지 문자열 추출
	    System.out.println("kim@nate.com".substring(4, 8));
	    
	    String[] emails= {
	    		"a@b.c",
	    		"kim@cyworld.com",
	    		"choi@daum.net",
	    		"lee@naver.com",
	    };
	    for(int i=0;i<emails.length ;i++) {
	    	beginIndex = emails[i].indexOf("@")+1;
	    	int endIndex =  emails[i].indexOf(".");
	    	System.out.println(emails[i].substring(beginIndex, endIndex));
	    }//for
	    
	    
	    //19] String toLoweCase() 대문자를 소문자로
	    //20] String toUpperCase() 대문자를 소문자로
	    System.out.println("대문자로 변경"+str1.toUpperCase());
	    System.out.println("소문자로 변경"+str1.toLowerCase());
	    
	    //대소문자 구분없이 아이디 체크하기 회원의 아이디가 소문자 park이라고 가정하자
	    Scanner sc = new Scanner(System.in);
	    System.out.println("id 입력");
	    String nick=sc.nextLine();
	    System.out.println("park".equalsIgnoreCase(nick.trim())?"회원":"비회원");
	    System.out.println("PARK".equals(nick.trim().toUpperCase())?"회원":"비회원");
	    System.out.println("park".equals(nick.trim().toLowerCase())?"회원":"비회원");
	    
	    //21] trim() 양쪽끝에 있는 공백 제거
	    System.out.println("트림 전 : X"+"         J    A  VA "+"X");
	    System.out.println("트림 후 : X"+"         J    A  VA ".trim()+"X");	    
		
	}//main
}//class
