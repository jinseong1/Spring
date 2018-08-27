package method05;

import java.io.IOException;
import java.util.Scanner;

public class MethodType04 {
	static int getTotalOfAge(int personCount) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for(int i =0; i < personCount ; i++) {
			System.out.println(i+1+"번째 나이 입력");
			total+=sc.nextInt();	
		}//for
		return total;	
	}//method

	
	static int opMath(int fnum, int op, int snum) throws IOException {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("첫번째 숫자를 입력하여주세요");
	fnum = sc.nextInt();

	
	System.out.println("연산자 기호를 입력하여주세요");
	op = (char)System.in.read();
	
	System.out.println("두번째 숫자를 입력하여주세요");
	snum = sc.nextInt();
	
	switch (op){
	case '+' :return fnum+snum;
	case '-' :return fnum-snum;
	case '*' :return fnum*snum;
	case '/' :return fnum/snum;
	default: return Integer.MAX_VALUE;
		
		
	}//switch
	
	}//method
	
	
	
	static int maxNumber(int count) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int max=0;
		for(int i=1 ; i <= count ; i++) {
			System.out.println(i+"번째 숫자 입력");
		int inputNumber;
		if(i==1) max=sc.nextInt();
		else {
			inputNumber=sc.nextInt();
			if(max<inputNumber) max = inputNumber;
		
		}
		
	}
		return max;
	}//method maxNumber
	
	static int getMax(int Count) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		for(int i=1 ; i<=Count ; i++ ) {
			System.out.println(i+"번쨰 숫자 입력");
			int inputNumber;
			//최초 입력 값 max에 저장
			if(i==1) max=sc.nextInt();
			else {
				inputNumber=sc.nextInt();
		}	
		}
		return max;
		}
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수 입력?");
		int personCount = sc.nextInt();
		System.out.printf("%d명의 나이 총합 : %d%n",personCount,getTotalOfAge(personCount));		
		System.out.println("3명의 나이 총합 :"+getTotalOfAge(3));
		
		
		opMath(100, '+', 20);
		
		int returnValue = opMath(10,10,'%');
		if(returnValue==Integer.MAX_VALUE)
			System.out.println("잘못된 연산자 기호입니다.");
		else
			System.out.println("사칙연산 결과는"+returnValue);
		
		
		
		maxNumber(10);
		
		
	}//main

}//class
