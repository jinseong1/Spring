package array03;

import java.util.Scanner;

public class ArrayExample { // 
	public static final int SUBJECT=3;
	public static void main(String[] args) {
		/*
		1.학생 수를 사용자로부터 입력받자
		   Scanner클래스 사용
		2. 입력받은  학생 수 만큼 국여수 점수 및 총점을 저장할 수 있는
		   int형 배열을 선언하고 메모리를 할당하라
		3. 학생수만큼 국영수 점수를 입력받아 2에서 생성한 배열에 저장하라
		4. 그리고 평균값 출력
		*/
		
		String[] subjects = {"국어","영어","수학"};
		Scanner sc = new Scanner(System.in);
		System.out.println("문제 1번 : 학생 수를  입력하여주세요");
		int numberOfstudent = sc.nextInt();
		
		int students[][] = new int[numberOfstudent][SUBJECT+1];
		
		for(int i=0 ; i < numberOfstudent  ; i++ ){	
			System.out.println(i+1+"번쨰 학생의 점수를 입력하세요");
			//총점을 저장할 변수
			int total=0;
			for(int k=0 ; k<SUBJECT ; k++ ) {
				System.out.println(subjects[k]+"점수 입력");
				//각 과목 점수 입력 받기
				students[i][k] = sc.nextInt();
				total+=students[i][k];
				
		}//in for
			//총점을 마지막 방에 저장
			students[i][SUBJECT]=total;
		}//out for
		//각 학생의 총점과 평균 입력
		for(int i = 0 ; i < students.length ; i++ ) {
			System.out.println("======================");
			System.out.println((i+1)+"번째 학생의 점수 및 성적");
			System.out.println("======================");
			//국영수 점수 및 총점 그리고 평균 출력

				System.out.printf("국어:%d,영어:%d,수학:%d",students[i][0],students[i][1],students[i][2]);
				System.out.printf("%n총점:%d%n",students[i][3]);
				System.out.printf("평균:%.2f%n",(double)students[i][3]/SUBJECT);
		}//out for
		

		
		
		
}//main
}//class
