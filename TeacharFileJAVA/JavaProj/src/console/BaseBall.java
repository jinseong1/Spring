package console;

import java.util.Scanner;

public class BaseBall {
	//1.랜덤하게 숫자 발생후 배열에 저장하는 메소드]
	public static void setArrayRandom(int[] random,int start,int end) {		
		
		for(int i=0; i < random.length;i++) {
			while(true) {
				//랜덤하게 숫자 발생 시키자
				int randomNumber = (int)(Math.random()*(end-start+1))+start;
				//랜덤하게 발생시킨 숫자의 중복 여부체크를 위한 변수 선언
				boolean isDuplicated= false;
				//배열 크기만큼 반복하면서 랜덤하게 발생시킨 숫자(randomNumber)와
				//중복 여부 체크
				for(int k=0; k < random.length;k++) {
					if(randomNumber == random[k]) {//중복된 경우
						isDuplicated=true;
						break;
					}
				}/////////////중복 체크용 for문
				//중복되지 않은 경우]
				if(!isDuplicated) {
					random[i]=randomNumber;
					//while문 빠져 나가기
					break;
				}			
			}////while			
		}///바깥 for
	}//////////////setArrayRandom()
	//2.사용자 입력용 메소드]
	private static void setUserNumber(int[] user) {
		
		Scanner sc = new Scanner(System.in);
		//문]입력한 3자리가 중복이 안되도록 수정하여라..
		// 만약 중복된 경우 , "중복된 숫자가 있어요"라는 메시지를 출력하고
		// 다시 입력받도록 하여라.
		while(true) {
			System.out.println("세자리 숫자를 입력하세요?(중복 안되게)");
			int inputNumber = sc.nextInt();
			
			user[0] = inputNumber / 100;
			user[1] = inputNumber % 100 /10;
			user[2] = inputNumber % 10;
			if(user[0]==user[1] || user[0] == user[2] || user[1]==user[2]) {
				System.out.println("중복된 숫자가 있어요\r\n다시 입력하세요");
				continue;
			}
			break;
		}
	}/////////////////setUserNumber
	//3. 비교후 스트라이크 볼 판단용 메소드]
	private static void setStrikeNBall(int[] strikeOrBall, int[] computer, int[] user) {
		for(int i=0; i< computer.length;i++)
			for(int k=0;k < user.length;k++)
				//자리수도 같고 값도 같은 경우 스트라이크
				if(i==k  && computer[i] == user[k])
					strikeOrBall[0]++;
				//자리수은 같지 않으나 값이 같은 경우 볼
				else if(i!=k  && computer[i] == user[k])
					strikeOrBall[1]++;		
	}////////////////////////////setStrikeNBall
	//4.게임 계속 여부 판단용 메소드]
	private static void isContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하려면 'X'나 'x'를 \r\n계속하려면 아무키나...");
		String exitCode=sc.nextLine();
		if(exitCode.equals("X") || exitCode.equals("x")) {
			System.out.println("즐거우셨죠.. 다음에...");
			System.exit(0);
		}
	}//////////////////isContinue()
	public static void main(String[] args) {
		while(true) {
			//1]랜덤하게 세자리 숫자를 발생시키자(컴퓨터)
			//랜덤하게 발생시킨 숫자를 저장할 1차원 배열 선언
			int[] computer = new int[3];
			//세자리 숫자를 배열에 설정하기 위해 아래 메소드 호출
			setArrayRandom(computer,1,9);
			//컴퓨터 숫자 확인하기위한 출력]
			for(int i=0;i < computer.length;i++)
				System.out.printf("%d",computer[i]);
			//줄바꿈
			System.out.println();
			
			// 시도 횟수 저장용  변수
			int tryCount =1;
			while(true) {
				//2]사용자로부터 3자리 숫자를 입력받자	
				//사용자 입력 숫자를 저장할 1차원 배열 선언
				int[] user = new int[3];
				//사용자 세자리 숫자를 입력받아 각 자리수별로 나눠서 위 배열에 넣는  메소드 호출
				setUserNumber(user);
				/*
				 * 사용자 입력 숫자 출력 확인용
				for(int i=0;i < user.length;i++)
					System.out.printf("%d",user[i]);
				//줄바꿈
				System.out.println();*/
				//3]비교 즉 자리가 같고 값이 같으면 스트라이크 ,자리는 다르고 값만 같으면 볼
				//스트라이크 및 볼값을 저장할 배열 선언
				//0번째 방에는 스트라이크,1번째 방에는 볼 저장
				int[] strikeOrBall = new int[2];
				setStrikeNBall(strikeOrBall,computer,user);
				//스트라이크/볼 출력
				System.out.printf("%d스트라크,%d볼%n",strikeOrBall[0],strikeOrBall[1]);
				if(strikeOrBall[0]==3) { 
					System.out.printf("빙고 짝!짝!짝! %d번째만에 맞혔어요%n",tryCount);
					break;
				}
				//시도횟수 증가
				tryCount++;
				
				
			}//안쪽 while
			//4]게임 계속여부 판단용 메소드 호출
			isContinue();
			
		}//바깥쪽 while
		
	}/////////////main
	
	

}////////////////class
