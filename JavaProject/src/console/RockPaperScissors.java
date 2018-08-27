package console;

import java.io.IOException;
import java.util.Scanner;

public class RockPaperScissors {

	//상수 정의
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	
	
	private static void printMenu() {
		System.out.println("===========메뉴번호===========");
		System.out.println("1.가위  2.바위 3. 보 9.프로그램 종료");
		System.out.println("============================");
		
		
	}
	//사용자로부터 숫자를 입력받는 메소드
	static int getUserNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴번호를 입력하세요?");
		int menu=sc.nextInt();
		return menu;
		
	}//method

	
	static void process(int computer,int user) {
		//컴퓨터와 사용자의 상세내용
		System.out.printf("[컴퓨터:%s,당신:%s]  ",getString(computer),getString(user));
		if(computer==SCISSORS && user==ROCK ||
		   computer==ROCK && user==PAPER ||
		   computer==PAPER && user==SCISSORS) {;
			System.out.println("당신이 이겼어요");}
			else if(computer==user)
				System.out.println("당신이 비겼어요");
			else
				System.out.println("당신이 졌어요");
		
	}//method
	
	
	static String getString(int menu) {
		switch (menu) {
		case SCISSORS: return "가위";
		case ROCK: return "바위";
		default: return "보";
		}//switch
		
	}//method
	
	public static void main(String[] args) {
		 // 0.0 <= random <1.0
		//System.out.println(Math.random());
		//1부터 10까지 사이의 숫자를 랜덤하게 발생(난수)
		//(rendom()*45)+1
		/*
		int random= (int)(Math.random()*3)+3;
		System.out.println(random);
		*/
		while(true) {
		
		//메뉴출력
		printMenu();
		//컴퓨터 숫자 랜덤하게 발생
		int computer=getComputerNumber(); // 1부터 3사이
		int random= (int)(Math.random()*3)+1;
		//사용자 숫자 입력 받기
		//System.out.println("컴퓨터"+computer);
		int user=getUserNumber();
		if(user==9) {System.out.println("게임이 종료되었습니다 정말 수고하셨어요"); break;}
		//System.out.println("사용자"+user);
		
		//게임 승리여부 판단
		process(computer, user);
		
		}//while	
		
	}//main

	private static int getComputerNumber() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*3)+1;
	}
	}
//class
