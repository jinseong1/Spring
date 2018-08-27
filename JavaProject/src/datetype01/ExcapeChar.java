package datetype01;

public class ExcapeChar {

	public static void main(String[] args) {
		//    \t(Tab 기능)  이스케이프
		//    \n(줄바꿈 기능)
		//    \r(carrige return) 컷을 앞으로 땡김(하지만 이클롭스에는 \n과 똑같은 기능을 한다)
		//    \r\n (줄바꿈 끝판왕)
		
		
		
		
		
		
		
		
		System.out.println("HitHomeRun");
		System.out.println("Hi\tHomeRun");

		
		
		System.out.print("HitHomeRun");
		System.out.println("Hi\tHomeRun");
		
		System.out.print("Welcome To Java!!!\n");
		System.out.print("Hi Java!!!");
		System.out.println("\nLet Do It.\nGo Fithing!!!");
		
		System.out.print("My Nick is Supperman\rXX");
		
		System.out.println("국어t+영어t+수학t");
		System.out.println("국어\t+영어\t+수학");
		
		
		System.out.println("나의 닉네임은 '스마트보이'입니다");
		System.out.println("나의 닉네임은 \'스마트보이\'입니다");   //   \'는 의미 없음.
		System.out.println("나의 닉네임은 \"스마트 보이\"입니다");   //  \" 는 의미 있음.

		System.out.println("G\nDrive\table");
		System.out.println("G\\nDrive\\table"); //  (\\ → \ 로 출력된다)
		
		/* %d 정수값 출력
		 * %f 실수값 출력
		 * %c char 출력
		 * %b boolean 출력
		 * %s String 출력
		 * %n 줄바꿈 (\r\n도 가능) 
		 */
		
		
		int kor=99, eng=80, math=96;
		double avg = (kor+eng+math)/3.0;		
		System.out.println("[형식 문자열 미 사용]");
		System.out.println("국어:,"+kor+"영어:,"+eng+"수학:,"+math+"평균:,"+avg);
		//메소드에서 상용시 작동
		System.out.println("[형식 문자열 사용]");
		System.out.printf("국어:%d,영어:%d,수학:%d,평균:,%f%n",kor,eng,math,avg);
		System.out.printf("국어:%d\t영어:%d\t수학:%d\t평균:%f\r\n",kor,eng,math,avg);
		System.out.printf("국어:%s\t영어:%s\t수학:%s\t평균:%s\r\n",kor,eng,math,avg);
		
		
		/* %d 정수값 출력
		 * %f 실수값 출력
		 * %c char 출력
		 * %b boolean 출력
		 * %s String 출력
		 * %n 줄바꿈 (\r\n도 가능) 
		 */
		
		System.out.println("[출력자리수 미 지정]");
		System.out.printf("국어:%d영어:%d수학:%d평균:%f%n",kor,eng,math,avg);
		
		//실제 값보다 적은 자리수는 의미없다(error X)
		//단 실제 값보다 자리수는 크게 주면 여백의 효과가 있다
		System.out.println("[출력자리수 미 지정(양수)]");
		System.out.printf("국어:%4d영어:%4d수학:%4d평균:%7.2f%n",kor,eng,math,avg);

		System.out.println("[출력자리수 미 지정(음수)]");
		System.out.printf("국어:%-4d영어:%-4d수학:%-4d평균:%-7.2f%n",kor,eng,math,avg);
		System.out.printf("국어:%-4d영어:%-4d수학:%-4d평균:%.2f%n",kor,eng,math,avg);
		
		//모든 값을 %s로 입력하여도 된다.
		System.out.println("[기타]");
		System.out.printf("%c %b %.2f %s%n",'가',false,3.149461651,"문자열");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main

}//class
