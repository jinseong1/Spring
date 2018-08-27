package operlater02;

public class HaldangOP {

	public static void main(String[] args) {
		//  +=       -=        *=          %=  축약표현
		int num1=100;
		System.out.println(num1);
		int num2=100;
		System.out.println(num2);
		num1+=100;
		System.out.println(num1);
		num1%=num2;
		num2*=2+10;  //num2= num2*(2+10);
		System.out.println(num2);
		//num1&&num2; [X]
		boolean b1=true, b2=false;
		System.out.println(b1&&b2);
		//b1&&=b2; //[X] 축약처리 안됨
		b1=b1 && b2;
		int num4=10;
		int r =num4++ + 100;
		System.out.println(r);
		System.out.println(num4);
		
		// ++(1씩 증가시킴) --(1씩 감소시킴)
		
		int num3 = 10; num4 = 10;
		//num3++; 단독사용 11
		++num3;// 단독사용 11
		int result = num4 + num3++;
		
		System.out.printf("result:%d%n",result);
		System.out.printf("num3:%d%n",num3);
		
		result = num4 + ++num3;

		System.out.printf("result:%d%n",result);
		System.out.printf("num3:%d%n",num3);
		
		int num5=10;
		System.out.println(num5++);
		System.out.println(num5);
		System.out.println(++num5);
		
		
		
		
		

	}

}
