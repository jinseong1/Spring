package io24.filter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import comm.util.CommonUtility;

public class BufferdRwKeyboardToFile {
	public static void main(String[] args) throws IOException, InterruptedException {
	
	
	
/*	
//	키보드로 입력받아 파일로 출력
//	키보드 1바이트를 문자단위로 변환
		BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new FileWriter("Keyboard.txt"));
		String data;
		while((data=bis.readLine())!=null) {
			pw.println(data);
		}
		pw.close();
*/
	System.out.println("나이를 입력하세요");
	int age = nextInt();
	System.out.println("당신의 10년 후 나이는 : "+(age+10));
	
	System.out.println("이름을 입력하여주세요");
	String name = nextLine();
	System.out.println("당신의 이름은 : "+name);
		
		
	}//main
	static int nextInt() throws InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {inputString=br.readLine();
		}
		catch (IOException e) {
			if(!CommonUtility.isNumber(inputString)) {
				throw new InterruptedException();
			}
		}
		return Integer.parseInt(inputString);
	}
	
	
	static String nextLine() throws InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {inputString=br.readLine();
		}
		catch (IOException e) {
			if(!CommonUtility.isNumber(inputString)) {
				throw new InterruptedException();
			}
	
		}
		return inputString;
	}
	
	
	
	
}//class
