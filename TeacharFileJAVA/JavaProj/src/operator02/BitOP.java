package operator02;

public class BitOP {

	public static void main(String[] args) {
		//비트 연산는 비트 단위로 계산
		/*
		[쉬프트 연산자]
		-두 항이 반드시 정수여야한다
		 정수 <<  비트수: 왼쪽으로 비트수만큼 이동하고 
		                  오른쪽에     남은 비트는 0으로 채운다

		 정수 >> 비트수 : 오른쪽으로 비트수만큼 이동하고
		 	              왼쪽에 남은 비트는 부호비트로 
		 	              채운다(1:음수,0:양수)
		*/
		byte b1=10,bit1=2;
		/*
		 * 10 : 0000 1010
		 * <<
		 * 2
		 * ----------------------
		 *      0000 0000 0000 0000 0000 0000 0010 1000=>32+8=>40
		 * 
		 * 
		 */
		int result=b1 << bit1;
		System.out.printf("%d << %d 의 결과 : %d%n",b1,bit1,result);
		/*
		 * 10 : 0000 1010
		 * >>
		 * 2
		 * ----------------------
		 *      0000 0000 0000 0000 0000 0000 0000 0010 =>2
		 * 
		 * 
		 */
		result=b1 >> bit1;
		System.out.printf("%d >> %d 의 결과 : %d%n",b1,bit1,result);
		b1 = -9;
		/*
		 * -9 : 1111 0111
		 * <<
		 * 2  
		 * ------------------
		 *      1111 1111 1111 1111 1111 1111 1101 1100  =>-1*64+16+8+4=-36
		 * 
		 */
		result=b1 << bit1;
		System.out.printf("%d << %d 의 결과 : %d%n",b1,bit1,result);
		/*
		 * -9 : 1111 0111
		 * >>
		 * 2  
		 * ------------------
		 *      1111 1111 1111 1111 1111 1111 1111 1101 =>-1*4+1=-3
		 * 
		 */
		result=b1 >> bit1;
		System.out.printf("%d >> %d 의 결과 : %d%n",b1,bit1,result);
		
		b1=3;
		byte b2 = -15;
		/*
		 * 3  : 0000 0011
		 * &
		 * -15: 1111 0001
		 * ------------------
		 *      0000 0001 =>1
		 * 
		 * 
		 */
		result = b1 & b2;//3 & -15
		System.out.printf("%d & %d = %d%n",b1,b2,result);
		
		/*
		 * 3  : 0000 0011
		 * |
		 * -15: 1111 0001
		 * ------------------
		 *      1111 0011 =>-1*16 + 2+1=-13
		 * 
		 * 
		 */
		result = b1 | b2;//3 | -15
		System.out.printf("%d | %d = %d%n",b1,b2,result);
		/*
		 * 3  : 0000 0011
		 * ^
		 * -15: 1111 0001
		 * ------------------
		 *      1111 0010 =>-1*16 + 2=-14
		 * 
		 * 
		 */
		result = b1 ^ b2;//3 ^ -15
		System.out.printf("%d ^ %d = %d%n",b1,b2,result);
		
		result = ~b2;
		/*
		 * 
		 * ~-15: 1111 0001
		 * ------------------
		 *       0000 1110 =>8+4+2=14
		 * 
		 * 
		 */
		System.out.printf("~%d = %d%n",b2,result);
				
	}////////////////

}////////////////////
