package console;

import java.util.Scanner;

/*
 * Math클래스의 random()메소드:
 * 0.0사이에서 1.0사이의 double형값을 무작위로
 * 발생시켜주는 메소드(단,1.0은 미 포함)
 * 
 * 특정 범위의 숫자를 랜덤하게 발생 시키려면
 * 
 * (int)(Math.random()*차이값)+시작값
 * 단,끝값은 포함 안됨
 * 끝값을 포함 시키려면
 * (int)(Math.random()*(차이값+1))+시작값
 * 
 * 예] 5부터 15사이의 숫자를 랜덤하게 발생시키려면
 * 차이값: 15-5 =10;
 * 시작값: 5
 * 끝값:15
 * 
 * (int)(Math.random()*10)+5 : 단,15는 발생 안됨
 * 
 * 끝값도 발생시키려면 
 * (int)(Math.random()*11)+5
 */
public class RockPaperScissors {
	//상수 정의]
	public static final int SCISSORS =1;
	public static final int ROCK =2;
	public static final int PAPER =3;
	
	//메뉴 출력용 메소드]
	private static void printMenu() {
		System.out.println("============메뉴 번호==============");
		System.out.println("1.가위  2.바위  3.보  9.프로그램 종료");
		System.out.println("=================================");
	}//////////printMenu()
	//랜덤하게 숫자(1~3사이)를 발생시키는 메소드]
	private static int getComputerNumber() {
		
		return (int)(Math.random()*3)+1;
	}/////////////////getComputerNumber()
	//사용자로부터 숫자를 입력받는 메소드]
	static int getUserNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴번호를 입력하세요?");
		int menu = sc.nextInt();
		return menu;
	}///////////////////////////////
	//가위바위보 결과 판단용 메소드]
	static void process(int computer,int user) {
		//컴퓨터와 사용자의 상세내용
		System.out.printf("[컴퓨터:%s,당신:%s] ",getString(computer),getString(user));
		
		if(computer==SCISSORS && user==ROCK ||
		   computer==ROCK && user==PAPER ||
		   computer==PAPER && user==SCISSORS)
			System.out.println("당신이 이겼어요");
		else if(computer == user)
			System.out.println("비겼어요");
		else
			System.out.println("당신이 졌어요");
	}///////////////////process()
	//메뉴번호 1,2,3을 문자열로 변환하는 메소드]
	static String getString(int menu) {
		switch(menu) {
			case SCISSORS: return "가위";
			case ROCK:return "바위";
			default: return "보";
		}
	}/////////////getString
	
	public static void main(String[] args) {
		//3 ~ 5사이의 숫자 랜덤하게 발생시키자
		//시작값:3,끝값:5 ,차이값:2
		//int random=(int)(Math.random()*3)+3;
		//System.out.println(random);
		while(true) {
			//1]메뉴 출력
			printMenu();
			//2]컴퓨터 숫자 랜덤하게 발생
			int computer=getComputerNumber();
			//System.out.println("컴퓨터:"+computer);
			//3]사용자 숫자 입력 받기
			int user=getUserNumber();
			if(user == 9) {
				System.out.println("수고 하셨어요");
				break;
			}
			//System.out.println("사용자:"+user);
			//4]게임 승리여부 판단
			process(computer,user);
		}
		//System.out.println("수고 하셨어요");
	}//////////////main


	




}/////////////////class
