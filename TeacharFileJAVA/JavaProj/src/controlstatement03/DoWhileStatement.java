package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class DoWhileStatement {
	/*
	do ~ while() 문:반복문으로
	반드시 한번은 실행하고나서 반복하고자 하는 경우 사용
	형식:
	[초기식]
	do{	
			
		 	실행 문장;
		 	[증감식]
	}while(반복조건);  //끝에 반드시 ; 붙여라
		
		  
	무한루프]	
	do{
	
	}while(true);
		  
	*/	
	public static void main(String[] args) throws IOException {
		//1부터 10까지 누적합:do~while문 사용]
		int sum=0;//누적합을 저장할 변수
		int i=1;//[초기식
		do {
			sum+=i;//[반복할 실행 명령문
			i++;//[증감식
		}while(i<=10);//[반복조건
		System.out.println("1부터 10까지 누적합:"+sum);
		/*
		 * 무조건 1명의 점수를 입력받아 성적처리
		 * 그리고 더 입력 받고 싶으면 아무키나 누르고
		 * 종료하고 싶으면 'X' 나 'x'클릭 
		 */
		Scanner scanner = new Scanner(System.in);
		int kor,eng,math,exitCode;
		/*
		do {
			//점수 입력받는 부분
			System.out.println("국어점수?");
			kor = scanner.nextInt();
			System.out.println("영어점수?");
			eng = scanner.nextInt();
			System.out.println("수힉점수?");
			math = scanner.nextInt();
			//학점 즉 결과 출력
			switch((kor+eng+math)/30) {
				case 10:
				case 9:System.out.println("A학점");break;
				case 8:System.out.println("B학점");break;
				case 7:System.out.println("C학점");break;
				case 6:System.out.println("D학점");break;
				default:System.out.println("F학점");				
			}
			//추가 입력여부 확인하기
			System.out.println("계속 입력 받으시려면 아무키나\r\n종료 하려면 'x'나 'X'를 입력하세요");
			//종료여부 키값 입력받기
			exitCode = System.in.read();
			//엔터값 스킵
			System.in.skip(2);
		}while(!(exitCode=='x' || exitCode=='X'));
		*/
		//위의 do~while문을 while문으로 변경]
		/*
		 * STE1P]while(true){} 사용
		 * STEP2]while블락안에서 if문으로 특정조건일때 break;하도록
		 *       작성
		 */
		while(true) {
			//점수 입력받는 부분
			System.out.println("국어점수?");
			kor = scanner.nextInt();
			System.out.println("영어점수?");
			eng = scanner.nextInt();
			System.out.println("수학점수?");
			math = scanner.nextInt();
			//학점 즉 결과 출력
			switch((kor+eng+math)/30) {
				case 10:
				case 9:System.out.println("A학점");break;
				case 8:System.out.println("B학점");break;
				case 7:System.out.println("C학점");break;
				case 6:System.out.println("D학점");break;
				default:System.out.println("F학점");				
			}
			//추가 입력여부 확인하기
			System.out.println("계속 입력 받으시려면 아무키나\r\n종료 하려면 'x'나 'X'를 입력하세요");
			//종료여부 키값 입력받기
			exitCode = System.in.read();
			//엔터값 스킵
			System.in.skip(2);
			if(exitCode=='x' || exitCode=='X') { break;}
			
		}
		
		System.out.println("프로그램 끝!! 수고 했어요!!!!");
		
		
		
		
		
		
		
	}//////////main
}/////////////class
