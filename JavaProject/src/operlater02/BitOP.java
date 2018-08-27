package operlater02;

public class BitOP {

	public static void main(String[] args) {
		/* Shift 연산자
		 * 두 항은 반드시 정수여야 한다.
		 * 정수 << 비트수 : 왼쪽으로 비트수만큼 이동하고 나머지는 0으로 채운다.
		 * 정수 >> 비트수 : 오른쪽으로 비트수만큼 이동하고 나머지는 부호비트로 채운다.
		 */
		
		byte b1=10, bit1=2;
		int result=b1<<bit1;
		System.out.printf("%d << %d의 결과 : %d%n",b1,bit1,result);
		
		result=b1>>bit1;
		System.out.printf("%d >> %d의 결과 : %d%n",b1,bit1,result);
		
		
		b1 = -9;
		/* -9 : 1111 0111
		 * << 
		 * 2
		 * 1101 1100 
		 */
		
		result=b1<<bit1;
		System.out.printf("%d << %d의 결과 : %d%n",b1,bit1,result);
		
		result=b1>>bit1;
		System.out.printf("%d >> %d의 결과 : %d%n",b1,bit1,result);
		
		b1=3;
		byte b2= -15;
		result=b1&b2;
		System.out.printf("%d & %d = %d%n", b1,b2,result);
		
		result=b1|b2;
		System.out.printf("%d | %d = %d%n", b1,b2,result);
		
		result=b1^b2;
		System.out.printf("%d ^ %d = %d%n", b1,b2,result);
		
		result = ~b2;
		System.out.printf("~%d = %d%n", b2,result);
		
		
		
	}

}
