package classApp;

import java.util.Scanner;

public class Person {
	Scanner sc = new Scanner(System.in);
	
	String name;
	int age;
	String address;
	void personPrint() {
		System.out.println("[Information]");
		System.out.println("이름을 입력하여주세요");
		System.out.println("Name : "+name);
		System.out.println("나이를 입력하여 주세요");
		System.out.println("Age : "+age);
		System.out.println("주소를 입력하여주세요");
		System.out.println("Address : "+address);
		
	}// void personPrint
}//Person
