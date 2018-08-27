package wrapperclass10;

public class WrapperClass01 {

	public static void main(String[] args) {
		int num1=200;
		int num2=20;
		int result = num1+num2;
		System.out.println("result = "+result);
		Integer num10 = new Integer(10);
		Integer num20 = new Integer(20);
		Integer resultObj = num10+num20;
		result=num10.intValue()+num20.intValue();
		result=num10+num20; // jdk5.0부터는 이렇게 사용한다
		System.out.println("result = "+result);
		// num1. 기본자료형은 멤버가 없다
		Integer num10ject = new Integer(num1);
		System.out.println("num1(int)을 byte형 값으로 변경 : "+num10ject.byteValue());
		System.out.println("num1을 이진수로 변경 : "+Integer.toBinaryString(num1));
		System.out.println("num10 = "+num10);
		System.out.println("num10 = "+num10.toString());
		
		num10 = num1; // auto boxing
		num20 = 20; //  auto boxing
		int num3 = num10; // auto unboxing
		Integer num30=300; // auto unboxing
		System.out.println("int형 최대값 : "+Integer.MAX_VALUE);
		System.out.println("int형 최소값 : "+Integer.MIN_VALUE);
		System.out.println("num1을 이진수 문자열로 변경 :"+Integer.toBinaryString(num1));
		System.out.println("num1을 8진수 문자열로 변경 :"+Integer.toOctalString(num1));
		System.out.println("num1을 16진수 문자열로 변경 :"+Integer.toHexString(num1));
		System.out.println(num10.getClass().getName());
		
		Integer remodel = new Integer(99);
		System.out.println("remodel : "+remodel);
		System.out.println("remodel : "+remodel.toString());
		System.out.println("remodel : "+remodel.hashCode());
		
		
		WrapperClass01 wc = new WrapperClass01();
		//java의 모든
		// wc = (WrapperClass01)num1; 기본자료형과 참조형과는 형변환이 되지 않는다
		
		System.out.println("wc = "+wc);
		System.out.println("wc.toString = "+wc.toString());
		System.out.println("wc.hashCode() = 10진수- "+wc.hashCode());
		System.out.println("wc.hashCode() = 16진수- "+Integer.toHexString(wc.hashCode()));
		
	}//main
}//class
