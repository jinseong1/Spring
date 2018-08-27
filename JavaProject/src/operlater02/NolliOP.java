package operlater02;

public class NolliOP {

	public static void main(String[] args) {
		//논리연산자, 이항연산자는 결과값이 항상 false, true이다.
		// ^(이항연산자) xor연산자(베타) 두 항이 서로 배타적일때 참 두 항이 서로 같으면 거짓
		// ! > && > ||, ^
		// 산술 > 비교 > 논리연산자 
		int num1=15,num2=10;
		boolean b= num1 >= num2 && num1 == num2;
		System.out.printf("%d >= %d && %d == %d의 결과 %b%n",num1, num2, num1, num2, b);
		b= true;
		System.out.printf("%b || %b 의 결과 : %b%n",true, false,b);
		// b= num1+num2 && num1 !=num2; [X] 논리연산자와 비교연산자는 안됨.
		b=num1 <=num2 ^ num1 != num2;
		//format 써봄
		System.out.format("%d <= %d ^ %d != %d의 결과 %b%n",num1,num2,num1,num2,b);
		b= !(num1 != num2) || num1 >= num2 && num1 == num2;
		System.out.println("b="+b);
		 
		
		b= true;
		System.out.println(b);
		b= !true || true ^ false && true;
		System.out.println(b);
		
		num1=10;
		num2=100;
		 // &&의 경우 첫번째 항만 판단하며 &은 두번째항까지 무조건 판단 즉 CPU가 일을 더함
		System.out.println(num1 > num2 && num1<num2);
		System.out.println(num1 > num2 & num1<num2);
		
		Ref ref=null;
		//System.out.println(ref.data); [X]
		//System.out.println(ref.data == 100); [X]
		System.out.println("[&&연산자 사용(and연산)]");
		System.out.println(ref != null && ref.data == 100);		
		System.out.println("[&연산자 사용(and연산)]");
		//System.out.println(ref != null & ref.data == 100); [X]
		
		
		
	}

}
class Ref{
	int data=100;
}