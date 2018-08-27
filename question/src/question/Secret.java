package question;

import java.util.Scanner;

import org.omg.CORBA.Request;

public class Secret {

	public static String sec(String num , String code) {
		
		char alphabet[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		StringBuffer al = new StringBuffer();
		int nums = Integer.parseInt(num);
		
		char[] array_word = new char[code.length()]; // 스트링을 담을 배열

		for(int i=0;i<array_word.length;i++){ 
			array_word[i]=(code.charAt(i));//스트링을 한글자씩 끊어 배열에 저장
		}
		
		for(int i=0;i<array_word.length;i++) {
			for(int j=0;j<alphabet.length;j++) {
				if(array_word[i]==' ') {
					System.out.println("빈 공백");
					continue;
				}
				else if(array_word[i]==alphabet[j]) {
					int number = (nums+i)%26;
					al.append(alphabet[number]);
					System.out.println("인식됨");
				}//if
			}//
		}//for
		return al.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("넘길 숫자를 입력하여주세요");
		String num = sc.nextLine();
		
		System.out.println("암호화 할 코드를 입력하여주세요");
		String code = sc.nextLine();

		String result = sec(num,code);
		System.out.println(result);
	

	}

}
