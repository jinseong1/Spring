package wrapperclass10;

import java.util.Scanner;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class WrapperClass02 {

	public static void main(String[] args) {
		String strNumber = "1000";
		System.out.println("10+strNumber : "+(10+strNumber));
		System.out.println("strNumber를 숫자로 변경 : "+(10+Integer.parseInt(strNumber)));
		System.out.println("strNumber를 숫자로 변경 : "+(10+Integer.valueOf(strNumber)));
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하여주세요");
		String ageString = sc.nextLine();
		System.out.println("당신의 10년후 나이는 :"+(10+Integer.parseInt(ageString)));
		*/
		System.out.println("문자열 1000을 byte형 값으로 변경 : "+Integer.valueOf(strNumber).byteValue());
		System.out.println("문자열 1000을 16진수값 문자열로 변경 : "+Integer.toHexString(Integer.valueOf(strNumber)));
		int num1 = Integer.parseInt(strNumber);
		Integer numObj=num1;
		System.out.println("숫자 1000을 short형 값으로 변경 : "+numObj.shortValue());
		String money="1억원";
		// Integer.parseInt(money); [x] error NumberFormatException
		String floatString="3.14";
		//Integer.parseInt(floatString); // [x] error NumberFormatException
		//소수점이 포함된 문자열을 경우 Float, Double
		System.out.println(Float.parseFloat(floatString)+10);
		System.out.println(Double.parseDouble(floatString)+10);
		System.out.println("이진수 형태의 문자열 1000을 십진수로 : "+Integer.parseInt(strNumber, 2));
		System.out.println("8진수 형태의 문자열 1000을 십진수로 : "+Integer.parseInt(strNumber, 8));
		System.out.println("16진수 형태의 문자열 1000을 십진수로 : "+Integer.parseInt(strNumber, 16));
		//숫자를 문자열로 변경
		int num2=1000;
		System.out.println(Integer.toString(num2)+10); // 
		Integer IntObject = num2;
		System.out.println(IntObject.toString()+10);
		//10진수를 각 진수로 변환
		System.out.println(Integer.toHexString(15));
		System.out.println(Integer.toHexString(num2));
		Integer object = 77;
		System.out.println("object = "+object);
		System.out.println("object = "+object.toString());
		System.out.println("object = "+object.hashCode());
		
		WrapperClass02 wc = new WrapperClass02();
		//메모리 주소가 출력됨
		System.out.println("wc = "+wc);
		System.out.println("wc = "+wc.toString());
		System.out.println("wc = "+wc.hashCode());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몸무게를 소수점 둘째 자리까지 입력하세요");
		String string = sc.nextLine();
		Float weigth = Float.parseFloat(string)+10;
		System.out.println("현재 몸무게에 10kg추가시 : "+weigth);
		//방법 1]
		System.out.println(Float.toString(weigth).length());
		//방법 2]
		System.out.println(weigth.toString().length());
		
		
		
	}//main
}//class
