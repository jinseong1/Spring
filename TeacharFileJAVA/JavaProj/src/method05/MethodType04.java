package method05;

import java.util.Scanner;

//메소드 형식 4:매개변수도 있고 반환값도 있는 경우
/*
접근지정자 [modifier] 반환타입 메소드명(매개변수들){

	처리할 일;
	return 결과값;   
} 
가장 활용빈도가 높은 메소드 타입]  
*/
public class MethodType04 {
	/*
	  * 인원수를 매개변수로 전달받아
	  * 인원수만큼 나이를 사용자로부터 입력받고
	  * 그 나이를 합을 반환하는 메소드 정의 
	  */
	 //1]메소드 정의
	static int getTotalOfAge(int personCount) {
		Scanner sc = new Scanner(System.in);
		int total=0;
		for(int i=0; i < personCount;i++) {
			System.out.println(i+1+"번째 나이 입력?");
			total+=sc.nextInt();			
		}
		return total;
	}//////////////getTotalOfAge
	/*문]매개변수로 두 숫자와 연산자(+,-,*,/)를
	전달 받아서 그 결과값을 반환하는 메소드를 정의해라
	그리고 main메소드에서 호출하여 
	그 결과값을 확인 하여라.반환타입은 int형*/
	static int getCalculator(int fnum,int snum,char op) {
		switch (op) {
			case '+':return fnum+snum;
			case '-':return fnum-snum;			
			case '*':return fnum*snum;
			case '/':return fnum/snum;
			default:return Integer.MAX_VALUE;
		}////////switch
		
	}////////////////////////getCalculator
	/*
	 * 문]여러개의 숫자를 입력받아서 그 중에
	 *    최대값을 구하는 메소드를 정의하자
	 *    단, 숫자의 개수는 매개변수로 입력받고
	 *    숫자의 개수 만큼 사용자로부터 숫자를
	 *    입력(Scanner)받아 최대값을 구해 
	 *    그 최대값을 반환하는 메소드이다.
	 *    그리고 main에서 호출하여 최대값을
	 *    출력하여라. 	
	 */
	
	static int getMax(int count) {
		Scanner sc = new Scanner(System.in);
		//최대값을 저장할 변수
		int max=0;
		//count만큼 반복하면서 숫자 입력받기
		for(int i=1;i <=count;i++) {
			System.out.println(i+"번째 숫자 입력?");
			int inputNumber;
			//최초 입력한 값을 max에 저장
			if(i==1) max=sc.nextInt();
			else {
				inputNumber=sc.nextInt();
				if(max < inputNumber) max=inputNumber;
			}
			
		}
		return max;
	}////////////////////getMax
	
	public static void main(String[] args) {
		//2]메소드 호출
		//Scanner sc = new Scanner(System.in);
		//System.out.println("인원수 입력?");
		//int personCount = sc.nextInt();
		//System.out.printf("%d명의 나이 총합:%d%n",personCount,getTotalOfAge(personCount));
		//System.out.println("3명의 나이 총합:"+getTotalOfAge(3));
		
		int returnValue=getCalculator(10,10,'+');
		if(returnValue == Integer.MAX_VALUE)
			System.out.println("잘못된 연산자 기호입니다");
		else
			System.out.println("사칙연산 결과는 "+returnValue);
		
		System.out.println("최대값:"+getMax(3));
	}//////////////////main
	
}/////////////////////class
