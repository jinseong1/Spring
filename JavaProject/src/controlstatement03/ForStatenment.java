package controlstatement03;

public class ForStatenment {

	public static void main(String[] args) {
		//for(;;) 무한루프
		int sum = 0;
		for(int i=1 ; i<=10 ; i++ )
		{
		sum+=i;
		}//for문
		System.out.println("1부터 10까지 누적합 :"+sum);
		
		sum=0;
		for(int i = 0; i <=10; i +=2 )
		{
		sum+=i;	
		}//for문
		
		
		
		System.out.println("1부터 10까지의 2의 배수의 합은"+sum);
		sum=0;
		for(int i=1 ; i<=10 ; i++)
		{
		if(i%2==0)//i값이 2의 배수일때만 누적
		{
			sum+=i;
		}//if문
		System.out.println("1부터 10까지의 2의 배수의 합은"+sum);
		
		}//for문
		
		 // System.out.println("for문이 끝난 후 i값:"+i);   i cannot be resolved to a variable
		
		
		int i = 5;
		for(i=5;i<10 ; i++) {}//for
		System.out.println("for문이 끝난 후 i값:"+i);
		
		
		for(int k=10; k > 0 ; k--)
		{
			System.out.println("hello world");	
		}//for
		
		
		sum=0;
		
		for(i =0; i<=100 ; i++){
			if(i%3==0 || i%5==0){
		sum+=i;	
		}//if
		
		}//for
		System.out.println("1부터100까지 3 or 5 의 배수 합"+sum);
		
		sum=0;
		for(i=1; i<=100 ; i++) {
			if((i%3==0 || i%5==0) && i % 15!=0) {
				sum+=i;
		}//if
		}//for
		System.out.println("1부터100가지 3 or 5의 배수 합 단 공배수 제외"+sum);
		
	
		sum=0;
		for(i=0;i<=100;i++) {
			if(i%3==0^i%5==0) {
				sum+=i;
		}//if
		}//for
		System.out.println("1부터100가지 3 or 5의 배수 합 단 공배수 제외"+sum);
		
		
		// 이증 for문 밖은 row(행) 안은 열(column)

		int repeatCount=1;
		for(int k=1;k<=3;k++) {
			for(int j=1 ; j<=3 ; j++)
				System.out.println("Hello:"+repeatCount++);
		}//for
			
		
		
		for(int k=0;k<=4;k++) { 				//행을 의미
			for(int j=0 ; j<=3 ; j++) {			//열을 의미
				if(k==j)
					System.out.printf("%-2d",1);
				else
					System.out.printf("%-2d",0);
					
			}
			System.out.println(); //줄바꿈 처리
					
		
		
		
		
		}//for
		
		
		for(int k=1;k<=5;k++) { 				//행을 의미
			for(int j=1 ; j<=5 ; j++){//열을 의미
				if(k+j==5) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
			}
			System.out.println();
				
		}	
				
		
		for(int k=0;k<=3;k++) { 				//행을 의미
			for(int j=3 ; j<=0 ; j--) {			//열을 의미
				if(k != j)
					System.out.println();
		}//if
		}//for
		
		/*
		 
		 
		 *
		 **
		 ***
		 ****
		 ***** 를 출력하라 (이중 for문을 사용)
		 
		 
		 
		 
		 */
		
		
		for(int d=1; d<=5 ; d++) {
			for(int z=1; z<=5 ; z++){
				if(d>=z)
					System.out.printf("*");
		
	}//첫번째 for문
			System.out.println();
	}//두번째 for문
	}

}
