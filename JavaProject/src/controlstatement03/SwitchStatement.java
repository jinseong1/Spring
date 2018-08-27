package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class SwitchStatement {

	public static void main(String[] args) throws IOException {
	
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하여주세요");
		int inputNumber = scanner.nextInt();
		System.out.println("입력한 숫자 :"+inputNumber);
	
		System.out.println("if문으로 판단");
	
		if(inputNumber%3==0)
			System.out.println("0입니다");
		else if(inputNumber%3==1)
			System.out.println("1입니다");
		else
			System.out.println("2입니다");
		
		
		System.out.println("Switch문으로 판단");
		
		int remain = inputNumber % 3;
		
		switch (remain) {
		case 0:
			System.out.println("나머지가 0");
			break;
		case 1:
			System.out.println("나머지가 1");
			break;
		default: 
			System.out.println("나머지가 2");
		}
		
		// switch (inputNumber % 3 == 0) {}  [X] Switch문에는 비교식 불가능
		// switch (inputNumber % 3 == 0 && inputNumber >= 100) {}  [X] Switch문에는 논리식 불가능
		
		byte b= 15;
		
		switch (b) { //byte, short, int, char 형만 가능
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;	
		case 3:
			System.out.println("4입니다.");
			break;
		case 4:
			System.out.println("4입니다.");
			break;
		case 5:
			System.out.println("5입니다.");
			break;
		case 15:
			System.out.println("15입니다.");
			break;
		case 20:
			System.out.println("20입니다.");
			break;
			
		default:
			break;
		}
		
		
		//long ln = 10L;
		// switch (ln%3) {    long 불가능
		// switch (ln)   long은 무조건 안된다
		
		System.out.println("첫번째 숫자 입력을 해주세요");
		int fnum = scanner.nextInt();
		
		System.out.println("연산자 기호(+-*/)를 입력하여 주세요");
		char op = (char)System.in.read();
		
		System.out.println("두번째 숫자 입력을 해주세요");
		int snum=scanner.nextInt();
		
		
		switch (op) {
		case '+':
			System.out.printf("%d + %d = %d%n",fnum,snum,fnum+snum);
			break;
		case '-':
			System.out.printf("%d - %d = %d%n",fnum,snum,fnum-snum);
			break;
		case '*':
			System.out.printf("%d * %d = %d%n",fnum,snum,fnum*snum);
			break;
		case '/':
			System.out.printf("%d / %d = %d%n",fnum,snum,fnum/snum);
			break;
		
		default:
			System.out.printf("잘못된 연산자 기호입니다%c%n",op);
		}
		
		String subject = "수학";
		switch (subject) {
		case "수학":
			System.out.println("과목은 수학");
			break;
		case "국어":
			System.out.println("과목은 국어");
			break;
		case "영어":
			System.out.println("과목은 영어");
			break;
		case "과학":
			System.out.println("과목은 과학");
			break;
			
		default:
			System.out.println("개설되지 않은 과목입니다");
		}
		
		
		int number2 = 2;
		switch (number2)
		{
		case 1:
		case 2:
		case 100:
		case 200:
			System.out.println("1이거나 2이거나 100이거나 200");
			break;
		case 300:
			System.out.println("300이다");
		}//Switch
		
		
		
		//평균 점수
		//90점 이상 A, 80점이상 B 70점이상 C, 60점이상 D, 60점 미만 F
		System.out.println("수학, 영어, 국어의 평균과 그 평균의 학점을 구하시오");
		System.out.println("국어 점수를 입력하여 주세요");
		int kor = scanner.nextInt();
		System.out.println("영어 점수를 입력하여 주세요");
		int eng = scanner.nextInt();
		System.out.println("수학 점수를 입력하여 주세요");
		int math = scanner.nextInt();
		
		int avg = (kor+eng+math)/30;	
		
		switch (avg)
		{
		case 10 :
		case 9 :
			System.out.println("A학점입니다");
			break;			
		case 8 :
			System.out.println("B학점입니다");
			break;
		case 7 :
			System.out.println("C학점입니다");
			break;
		case 6 :
			System.out.println("D학점입니다");
			break;
		default:
			System.out.println("F학점입니다");
		}
		
		
		
		
		
		
		
		
		
		}//main
}//class
								
	


