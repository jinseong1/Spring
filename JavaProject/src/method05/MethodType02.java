package method05;

import java.io.IOException;
import java.util.Scanner;

public class MethodType02 {// input x return o 의 경우
	//
	static int noParamYesReturn() {
		int sum=0;
		for(int i=1 ; i <=10 ; i++ )
			sum+=i;
		return sum;
		// System.out.println("[return문 이후]"); [X] Error
	}//noParamYesreturn
	
	
	static String getGrade() {
		Scanner sc = new Scanner(System.in);
		String[] subject = {"국어","영어","수학"};
		//점수 저장용
		int[] jumsu=new int[3];
		//총합 저장용
		int total = 0;
		for(int i=0 ; i<jumsu.length ; i++ ) {
			System.out.println(subject[i]+"점수입력");
			jumsu[i]=sc.nextInt();
			total+=jumsu[i];
			
		}//for
		/*
		switch (total/30) {
		case 10:
		case 9 : return "A학점";
		case 8 : return "B학점";
		case 7 : return "C학점";
		case 6 : return "D학점";
		default: return "F학점"; //메소드에서 swich의 경우 
			
		}*/
		
		String value;
		switch (total/30) {
		case 10:
		case 9 : value= "A학점"; break;
		case 8 : value= "B학점"; break;
		case 7 : value= "C학점"; break;
		case 6 : value= "D학점"; break;
		default: value= "F학점"; 
		
		
		}
		return value;
		
		
		
	}//메소드
	
	/*  사용자로부터 숫자 두개(sc)와 메소드로 산술 결과는 메소드 안에서 바로 출력하고 산술 연산자 기호를 반환하는 메소드를 정의하라
	 * 	그리고 main메소드에서 호출하여 사용자가 입력한 연산자를 출력하여라
	 */
	
	static int getOperator() throws IOException {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("첫번째 숫자를 입력하여주세요");
	int fnum = sc.nextInt();

	
	System.out.println("연산자 기호를 입력하여주세요");
	char op = (char)System.in.read();
	
	System.out.println("두번째 숫자를 입력하여주세요");
	int snum = sc.nextInt();
	
	switch (op){
	case '+' :System.out.printf("%d+%d=%d%n",fnum,snum,fnum+snum); break;
	case '-' :System.out.printf("%d-%d=%d%n",fnum,snum,fnum-snum); break;
	case '*' :System.out.printf("%d*%d=%d%n",fnum,snum,fnum*snum); break;
	case '/' :System.out.printf("%d/%d=%d%n",fnum,snum,fnum/snum); break;
	default:
		break;
		
	}
	return op;


	}//getOperator()
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		// method 호출 및 출력
		System.out.println("1부터 10까지 누적합 : "+noParamYesReturn());  //메소드 호출 후 바로 출력
		int value = noParamYesReturn();
		System.out.println("1부터 10까지 누적합 : "+value); // 메소드 변수 사용 후 출력
		
		
		System.out.println(getGrade());
		
		System.out.println(getOperator());
		
		System.out.println();
		
		
		

		
		
		
		
	}//main
}//class
