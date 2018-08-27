package stringclass11;

import java.util.Scanner;

import wrapperclass10.WrapperClass03;

public class StringConstructor {

	public static void main(String[] args) {
		//[String클래스의 생성자]
		//1]byte형 배열을 문자열로 변환
		//String(byte[] bytes) 생성자 이용
		//String(byte[] bytes,int 시작인덱스,int 길이)
		byte[] barr= {65,66,67,68,69,48};
		String byteToString = new String(barr);
		System.out.println("바이트형 배열을 문자열로 변환:"+byteToString);
		byteToString = new String(barr,2,3);
		System.out.println("바이트형 배열 일부분을 문자열로 변환:"+byteToString);
		//1-1]문자열을 byte형 배열로:String 클래스의 getBytes()
		barr=byteToString.getBytes();
		for(int i=0; i < barr.length;i++) {
			System.out.println(String.format("barr[%d]=%d",i,barr[i]));
		}////
		//2]char형 배열을 문자열로 변환
		//  생성자 혹은 static String valueOf(char[])이용
		//String(char[] value) 
		//String(char[] value, int offset, int count)
		char[] charr = {'H','I',' ','안','녕'};
		String charToString = new String(charr);
		System.out.println("char형 배열을 문자열로 변환:"+charToString);
		charToString = new String(charr,3,2);
		System.out.println("char형 배열 일부분을 문자열로 변환:"+charToString);
		//2-1]문자열을 char형 배열로:String클래스의 toCharArray()
		charr=charToString.toCharArray();
		for(int i=0; i < charr.length;i++) {
			System.out.println(String.format("charr[%d]=%c",i,charr[i]));
		}////
		//3]아스키나 유니코드값이 저장된
		//  int형 배열을 문자열로 변환
		//String(int[] codePoints, int offset, int count) 
		int[] code ={50,51,65,66,44032,44033,94};
		String intToString = new String(code, 0, code.length);
		System.out.println("int형 배열을 문자열로 변환:"+intToString);
		/* 
		 * 문]Scanner클래스로 문자열를 입력받아
		 * (nextLine()사용) char형 배열로 변환해서
		 * 출력하고
		 * 또한 입력받은 문자열을 숫자로 변환해서 2를 곱한
		 * 값을 출력 해라.단 입력받은 문자열이 숫자 형식이 아니면
		 * 숫자 형식일때까지 계속 입력받아서
		 * 위의 결과를 출력해라.		
		 */
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("숫자형태의 문자열을 입력하세요?");		
			String value = sc.nextLine();
			//1]char형 배열로 변환후 출력
			charr=value.toCharArray();
			for(int i=0; i < charr.length;i++) {
				System.out.println(String.format("charr[%d]=%c",i,charr[i]));
			}////
			if(!WrapperClass03.isNumber(value)) {
				System.out.println("숫자형식만...");
				continue;
			}
			System.out.println("2를 곱한 값: "+Integer.parseInt(value)*2);
			break;
		}////////////while
	}//////////main

}
