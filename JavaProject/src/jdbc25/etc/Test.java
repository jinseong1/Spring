package jdbc25.etc;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
		System.out.println("아무거나 입력하여주세요");
		String user = sc.nextLine();

		if(user.trim().equals("conn")) {
			user+=";";
			System.out.println(user);
			System.out.println("conn이 검색되었습니다");
		}
		}

	}

}
