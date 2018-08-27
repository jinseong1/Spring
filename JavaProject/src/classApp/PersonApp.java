package classApp;

import java.io.IOException;
import java.util.Scanner;

public class PersonApp {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Person person1 = new Person();
		System.out.println("이름을 입력하여 주세요");
		person1.name=sc.nextLine();
		System.out.println("나이를 입력하여 주세요");
		person1.age=sc.nextInt();
		System.out.println("주소를 입력하여 주세요");
		person1.address=sc.nextLine();
		
		
		
		
		
		
		
		
	}//void	
}//class
