package array03;

import java.util.Scanner;

public class Arraytype { // 1차열 배열

	public static void main(String[] args) {
		//
		
		int [] arrNum;  //배열 선언        int arrNum[] 도 가능
		// arrNum=100;	 [X]
		arrNum = new int[5];  // 참조형 메모리 할당 선언시는 항상 new 사용,  new=실제 데이터를 저장할 메모리를 heap영역에 할당하라는 의미
		System.out.println(arrNum);
		System.out.println("[배열 초기화 전]");
		for(int i=0 ; i<5 ; i++) {System.out.printf("arrNum[%d]=%d%n",i,arrNum[i]);}
		
		
		arrNum[0]=10;
		arrNum[1]=20;
		arrNum[2]=30;
		arrNum[4]=50;
		System.out.println("[배열 초기화 후]");
		for(int i=0 ; i<5 ; i++) {System.out.printf("arrNum[%d]=%d%n",i,arrNum[i]);}
		// arrNum[5]=60; [X] 범위를 벗어나면 오류가 남
		
		int localVar; // 지역변수
		//System.out.println(localVar); error : The local variable localVar may not have been initialized
		
		// ##
		System.out.println("배열의 크기"+arrNum.length);
		for(int i=0 ; i<arrNum.length ; i++){
		if(arrNum.length-1==i) System.out.printf("arrNum[%d]=%d ",i,arrNum[i]);
		else System.out.printf("arrNum[%d]=%d, ",i,arrNum[i]);}

		
		String strArray[] = new String[3];
		System.out.println("[배열 초기화 전]");
		for(int i = 0;i < strArray.length;i++) {
			System.out.printf("%s인덱스 방 : %s%n",i,strArray[i]);	
		}//for
		
		strArray[1] = "소프트웨어";
		strArray[0] = "한국";
		strArray[2] = "인재개발원";	
		
		System.out.println("[배열 초기화 후]");
		for(int i = 0;i < strArray.length;i++) {
			System.out.printf("%s인덱스 방 : %s%n",i,strArray[i]);	
		}//for
		//배열 선언과 동시에 초기화
		/*
		System.out.println("배열 선언과 동시에 초기화 방법 1");
		double dbArr[] = {100,3.14,99.9}; // {}배열초기화자
		for(int i=0;i<dbArr.length;i++)
		System.out.printf("dbArr[%s] : %.2f%n",i,dbArr[i]);
		*/
		System.out.println("배열 선언과 동시에 초기화 방법 2");
		double dbArr[] = new double[] {100,3.14,99.9};
		for(int i=0;i<dbArr.length;i++)
		System.out.printf("dbArr[%s] : %.2f%n",i,dbArr[i]);
		
		
		
		//boolean blArr[]; // boolean형 배열 선언
		//blArr= {true , 3>2 , 3>2&&5>3 , false};[X] // 배열 선언 후 초기화 불가능
		
		
		boolean blArr[]={true , 3>2 , 3>2&&5>3 , false}; //[O]
		for(int i = 0; i<blArr.length ;i++)
			System.out.printf("blArr[%d] : %b%n",i,blArr[i]);
		
		
		//nextInt 숫자를 읽는다
		//nextLine 무조건 문자열로 처리한다 엔터값을 버린다
		Scanner scn = new Scanner(System.in);
		System.out.println("학생수를 입력하세여주세요");
		int numberOfStudent = scn.nextInt();
		System.out.println("입력받은 학생 수:"+numberOfStudent);
		
		String[] names = new String[numberOfStudent];

		
		
		scn.nextLine(); //엔터값을 읽어서 사용안함
		for(int i=0 ; i<names.length ; i++) {
			System.out.printf("%d번째 학생의 이름을 입력하여주세요%n",i+1);
			names[i]=scn.nextLine();
			
		}//for
		for(int i=0 ; i<names.length ; i++)
			System.out.printf("%d번째 학생의 이름 : %s%n",i+1,names[i]);
		
		int sum=0;
		int jumsu[] = {90,99,75,9000,66,100,89,78,67,45,90,56,999,109};
			for(int i=0 ; i<jumsu.length ; i++)
				sum+=jumsu[i];
			
			System.out.println("jumsu의 총합은:"+sum);
			System.out.println("jumsu의 평균은:"+(double)sum/jumsu.length);
		
			
			// jumsu배열에 저장된 값 중 최대 값을 구하여라
			System.out.println("jumsu값 중 최대 값을 구하시오");
			
			int max=0;
			for(int i =1 ; i<jumsu.length ; i++){
				if(jumsu[i] > max)
					max=jumsu[i];
				
			}
			System.out.println("최대값은:"+max);
			
			
			
			System.out.println("jumsu[]을 큰 순서대로 정리하시요");
			
			for(int i=0 ; i<jumsu.length-1 ; i++ ){
				for(int k=i+1 ; k<jumsu.length ; k++){
					if(jumsu[i] < jumsu[k]) {
						int temp = jumsu[k] ;
						jumsu[k] = jumsu[i] ;
						jumsu[i] = temp;
						
						
			}//if
			}//in for
			}//out for
				
			for(int i=0 ; i < jumsu.length ; i++ )
			System.out.println(jumsu[i]+" ");
		
	}//main
}//class
