package array03;

public class Arraytype02 {

	public static void main(String[] args) {
		
		int arrNum[][] = new int [2][3];
		System.out.println(arrNum);
		System.out.println("초기화 전 출력(주소나옴)");
		for(int i=0 ; i<arrNum.length ; i++ ) {
			for(int k=1 ; k<arrNum.length ; k++ ) {
				System.out.printf("arrNum[%d][%d]=%-2d",i,k,arrNum[i][k]);
			}//in for
			System.out.println();
		}//out for
		
		
		arrNum[0][0]=1;
		arrNum[0][1]=2;
		arrNum[0][2]=3;
		arrNum[1][0]=4;
		arrNum[1][1]=5;
		arrNum[1][2]=6;
		
		System.out.println("[초기화 후 출력]");
		for(int i=0 ; i < arrNum.length ; i++ ) {
			for(int k=1 ; k<arrNum.length ; k++ ) {
				System.out.printf("arrNum[%d][%d]=%-3d",i,k,arrNum[i][k]);
				
			}// in for
			System.out.println();
		}//out for
		
		System.out.println();
		
		System.out.println("5행5열 출력");
		int nember[][] = new int [5][5];
		for(int i=0 ; i < nember.length ; i++) {
			for(int k=0 ; k < nember[i].length ; k++ ) {
				nember[i][k] = i+k;
				System.out.printf("(%d행,%d열)=%-4d",i,k,nember[i][k]);
		}//in for	
			System.out.println();
		}//out for
		
			
		
		int arrInit[][] = {{1,2},{1,2,3},{1}};
		System.out.println("[2차원 배열 초기화자 사용]");
		for(int i=0 ; i<arrInit.length ; i++ ) {
			for(int k=0 ; k<arrInit[i].length ; k++ ) {
				System.out.printf("(%d행,%d열)=%-4d",i,k,arrInit[i][k]);
				
		}//in for
		System.out.println();
		}//out for
			
		
		System.out.println("문제 1번 : 2차원 배열 선언시 선언과 동시에 메모리 할당하라");
		
		int number2[][] = new int[5][5];
		
		
		System.out.printf("%d%n%d%n%d%n%d%n%d%n",19999,91999,99199,99919,99991);
			
		System.out.println("문제 2번 : 위의 값을 1번에서 선언한 배열에 저정하라");
		
		for(int i=0 ; i<number2.length ; i++ ) {
			for(int k=0 ; k < number2[i].length ; k++ ) {
				if(i==k) number2[i][k]=1;
				else number2[i][k]=9;
				
			}//in for
		}//out for
			System.out.println("문제 3번 : 2차원 배열에 저장된 값을 위 모양대로 출력하여라");
			for(int i=0 ; i<number2.length ; i++ ) {
				for(int k=0 ; k < number2[i].length ; k++ ) {
					if(i==k) number2[i][k]=1;
					else number2[i][k]=9;
					System.out.printf("%-2d",number2[i][k]);
					
				}//in for
				System.out.println();
			}//out for
			
			
}//main
}//class