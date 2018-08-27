package method05;

import java.util.Scanner;


/*메소드에서 필요한 값을 매개변수를 통해서 받고 그 값을 계산하여 바로 사용하고자 할때 사용함
 */
public class MethodType03 {
	static void printSum(int start, int end) {
		int sum=0;
		for(int i=start ; i<end ; i++ ) {
			sum+=i;			
		}
		System.out.printf("%d부터%d까지 누적합은 : %d%n",start,end,sum);
	}//
	
	
	//국영수 세 과목의 점수를 매개변수로 전달받아 평균을 구하고 학점을 출력하는 메소드를 정의해라
	//그리고 메인 메소드에서 호출하여 결과를 확인하여
	
	
	static void kemAvg(int kor,int eng,int math) {			
		switch ((kor+eng+math)/30) {
		case 10:
		case 9:  System.out.println("A학점입니다"); break;
		case 8:  System.out.println("B학점입니다"); break;
		case 7:  System.out.println("C학점입니다"); break;
		case 6:  System.out.println("D학점입니다"); break;
		default: System.out.println("F학점입니다"); break;
		}
	}//kemAvg()
	
	
	static void printName(String name, int age) {
		System.out.println("이름은 :"+name+"나이는 :"+age);	
	}
	
	static void gogoDan(int start, int end) {
		for(int i=1 ; i<end ; i++) {
			for(int j=start ; j<end ; j++ ) {
				System.out.printf("%d*%d=%d",i,j,i*j);
				
			}//in for
				System.out.println();
		}//out for
		
	}//gogoDan

	
	
	
	
	public static void main(String[] args) {
		
		int start = 1;
		int end = 10;
		printSum(start,end);
				
		printSum(10,100);
		printSum(20,100);
		printSum(100,1000);
		kemAvg(100,100,70);
		kemAvg(70,56,89);
		printName("홍길동",20);
		gogoDan(2,9);
		
		int[][] score = {
				{90,67,89},
				{45,67,12},
				{89,67,45},
				{77,89,54},
				{91,75,65},
		};
	
		
		
		
		
		
		
		
	}//main
}//class
