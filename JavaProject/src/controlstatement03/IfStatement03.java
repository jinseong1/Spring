package controlstatement03;

import java.io.IOException;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class IfStatement03 {

	public static void main(String[] args) throws IOException {
		int kor=90,eng=80,math=89;
		double avg = (kor+eng+math)/3.0;
		if(avg>=90)System.out.println("A학점");
		else if(avg>=80)System.out.println("B학점");
		else if(avg>=70)System.out.println("C학점");
		else if(avg>=60)System.out.println("D학점");
		else System.out.println("F학점");
	
		//숫자 2의 배수인지 판단 2의 배수이면 표기 아니면 아니라고 표기 영어 소문자면 소문자라고 표기 대문자면 대문자라고 표기
		System.out.println("한 문자를 입력하여주세요");
		int asciicode = System.in.read();
		
		if(asciicode>='0' && asciicode <='9' && (asciicode-'0')%2==0)
				System.out.println("2의 배수입니다.");
			else if(asciicode>='0' && asciicode <='9' && (asciicode-'0')%2!=0)
				System.out.println("2의 배수가 아닙니다");
			else if(asciicode>='a'&&asciicode<='z')
				System.out.println("소문자입니다.");
			else if(asciicode>='A'&&asciicode<='Z')
				System.out.println("대문자입니다.");
			else System.out.println("2의 배수도 알파벳도 아닙니다");
		
		//숫자도 알파벳도 아니면 기타를 출력하라
		
		System.out.println("한 문자를 입력하여주세요");
		if(asciicode>='0' && asciicode<='9')
				System.out.println("숫자입니다");
			else if(asciicode>='a'&&asciicode<='z'||asciicode>='A'&&asciicode<='Z')
				System.out.println("영어입니다");
			else
				System.out.println("기타입니다");
		
		
		
		//문(종합)세 숫자 중 최대 값을 구하는
		// 로직을 작성하자(if문 형식 3개 중 아무거나 사용가능)
		
		int num1=300, num2=207, num3= 100;
		int max = num3;

		if(max < num1)
			max=num1;
		if(max < num2)
			max=num2;
		if(max < num3)
			max=num3;
		System.out.println(max);
		
		
		
		
	}

}
