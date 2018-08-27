package controlstatement03;

import java.io.IOException;

public class WhileStatement {

	public static void main(String[] args) throws IOException {
		//while문은 반복 횟수가 정해져 있지 않을때 사용
		
		int sum=0;
		int i=1;
		
		while(i<=10) {
			sum+=i; // 명령문
			i++;
		}
		System.out.println("1부터 10까지 누적합"+sum);
		
		sum=0;
		i=1;
		while(i<=1000){
				if(i%3==0 ^ i%5==0){
					sum+=i;
		}//if
					i++;
		}//while
		System.out.println("1부터 10까지 3과 5의 합은(공배수):"+sum);

		/*
		
		//사용자가 언제 ctrl+z(-1)나 문자를 입력할지 모르는 상황임으로 while문 사용
		System.out.println("문자를 입력하여주세요");
		int ascii;  // asciicode값을 저장하기 위한 변수
		String inputString=""; //read
		
		
			/*
			while((ascii=System.in.read()) !=-1) {
				// \r\n은 제외
				if(ascii!=13 && ascii !=10)
					inputString+=(char)ascii;
				if(ascii==10){
					System.out.println(inputString);
					inputString="";	
				}//if
			}//while	
			 */
	
		int k=1;//out while 초기식
		// int j=1; //in while초기화를 안쪽에 하는것이 가장 중요하다
		while (k<=4) {
			int j=1; //in while초기화
			while(j<=4) {
				if(k==j)
					System.out.printf("%-2d",1);
				else
					System.out.printf("%-2d",0);
				j++; // in while 증감식
			}// in while
			k++; //out while 증감식
			System.out.println(); // 줄바꿈
		}//out while
		
		k=1;
		while(k<=5){
			int j =1;
			while(k>=j){
				System.out.printf("%-2c",'*');
				j++;
			}//in while
			k++;
			System.out.println();
		}//out while
		
		k=1;
		while(k<=9) {
			int j=2;
			while(j<=9){
				System.out.printf("%d * %d = %-4d",j,k,j*k);
				j++;
			}//in while
			k++;
			System.out.println();
		}//out while
		
		
		
		while(true) {
			System.out.println("무한루프");
			break;
		}
		System.out.println("프로그램 끝");
	
}//main
}//class
