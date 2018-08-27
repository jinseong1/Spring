package stringclass11;

import java.util.Scanner;

import wrapperclass10.WrapperClass03;

public class StringConstructor {

	public static void main(String[] args) {
//		byte - 문자열 변환
		byte[] barr= {65,66,67,68,69,48};
		String byteToString = new String(barr);
		System.out.println("바이트형 배열을 문자열로 변환 : "+byteToString);
		byteToString=new String(barr,2,3);
		System.out.println("바이트형 배열을 일부분을 문자열로 변환 : "+byteToString);
//		문자열 - byte 변환
		barr = byteToString.getBytes();
		for(int i=0;i<barr.length;i++) {
			System.out.println(String.format("barr[%d] = %d",i,barr[i]));
		}
//		char - 문자열 변환
		char[] charr= {'H','I',' ','안','녕'};
		String charrToSring =new String(charr);
		System.out.println("char형배열을 문자열로 변환 : "+charrToSring);
		charrToSring=new String(charr,3,2);
		System.out.println("char형배열을 일부분을 문자열로 변환 : "+charrToSring);
//		문자열 char 변환
		charr=charrToSring.toCharArray();
		for(int i=0;i<charr.length;i++) {
			System.out.println(String.format("charr[%d] = %c",i,charr[i]));
		}
//		아스키코드가 저장된 int형 배열을 문자열로 변환
		int[] code={50,51,65,66,44032,44033,94};
		String intToString = new String(code,0,code.length);
		System.out.println("int형 배열을 문자열로 변환 : "+intToString);
		
/*		문제] Scanner클래스로 문자열을 입력받아
		nextLine을 char형 배열로 변환해서
		출력하고
		또한 입력받은 문자열을 숫자로 변환해서 2를 곱한
		값을 출력해라 단 입력받은 문자열이 숫자형식이 아니면
		숫자형식일때까지 계속 입력받아서
		위의 결과를 출력해라
		*/
		while(true) {
			System.out.println("숫자형태의 문자열을 입력하세요?");
			Scanner sc=new Scanner(System.in);
			String value=sc.nextLine();
			charr=value.toCharArray();
			for(int i=0;i<charr.length;i++) {
				System.out.println(String.format("charr[%d]=%c", i,charr[i]));
			}
			if(!WrapperClass03.isNumber(value)) {
				System.out.println("숫자형식만");
			continue;
			}
			System.out.println("2를 곱한 값"+Integer.parseInt(value)*2);
			break;
			}
		
	}//main
}//class
