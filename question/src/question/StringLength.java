package question;

import java.util.Scanner;

public class StringLength {
	
	
	public static boolean stringleg(int str) {
		int length = (int)(Math.log10(str)+1);
		try {
		if(length>=4 && length <=6) {
			
			
			
			return true;
		}
		else {
			return false;
			
		}
		
		
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc  = new  Scanner(System.in);
		System.out.println("입력하세요");
		try {
			if(stringleg(sc.nextInt())) {
				System.out.println("맞아요");
			}
			else {
				System.out.println("틀려요");
			}
			
		}
		catch (Exception e) {
			System.out.println("틀립니다");
		}
		
		
	}

}
