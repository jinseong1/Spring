package question;

import java.util.Scanner;

public class RectangleApp {
	
	
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      System.out.print("점의 x좌표 입력: ");
	      String x = sc.nextLine();
	      ////////////////////////////////////////
	      System.out.print("점의 y좌표 입력: ");
	      String y = sc.nextLine();
	      
	      // 인자 생성자로 점의 x, y좌표 값 설정
	      TwoClass tc = new TwoClass(x,y);
	      tc.prints();

	}

}
