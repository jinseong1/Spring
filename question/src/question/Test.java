package question;

import java.util.Scanner;

class Test {
    String caesar(String s, String n) {
    	 int num = Integer.parseInt(n);
    	 
    	 
    	 
        String result = "";
        num = num%26; //밀어낼 자리수 n의 계산
        int cs = s.length(); //cs = 5 , 공백도 똑같이 출력해줘야하기 때문에 그냥 length로 받음
         
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);  //하나씩 저장
            if(Character.isLowerCase(ch)) {
                // 계산시 -'a'와 +'a'를 해줘야 하는 이유에 대해 파악해야함
                ch = (char) ((ch-'a'+num) % 26 +'a'); 
                 
            }else if(Character.isUpperCase(ch)) {
                ch = (char) ((ch-'A'+num) % 26 +'A');
                 
            }
            result = result + ch;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Test c = new Test();
        Scanner sc = new Scanner(System.in);
        System.out.println("밀어낼 숫자를 입력하여주세요");
        String num = sc.nextLine();
        
        System.out.println("코드를 입력하여주세요");
        String code = sc.nextLine();
        
        System.out.println(c.caesar(code, num));
    }
}