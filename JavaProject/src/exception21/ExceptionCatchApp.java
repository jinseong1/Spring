package exception21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCatchApp {

	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int []array = new int[2];
		try {
			System.out.println("array[0]방에 입력할 숫자?");
			array[0]=Integer.parseInt(sc.nextLine());
			System.out.println("array[1]방에 입력할 숫자?");
			array[1]=Integer.parseInt(sc.nextLine());
			System.out.println("두 숫자 나누기 : "+array[0]/array[1]);
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			System.out.println("당신의 10년후 나이 : "+(age+10));

			
			
		}
			
		
/*		catch (Exception e) {
			System.out.println("예외가 발생했어요");
		}
*/		catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
		}
		catch (InputMismatchException e) {
			System.out.println("나이는 숫자만...");
		}
		catch (ArithmeticException e) {
			System.out.println("0으로 나눌수 없어요");
		}
		catch (Exception e) {
			System.out.println("예외가 발생했어요");
		}
		
		
		
		
	}//main
}//class
