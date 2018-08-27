package datetype01;

class ConstentVariable {
//class 안에 선언할때에는 반드시 바로 초기화를 시킨다
	//final double PI; //[초기화 안해서 안됨]
	public static final double PI=3.14; //[O]
	
	
	public static void main(String[] args) {
		System.out.println(PI);
		//PI = 3.141592653589793; 값변경 불가
		/* 주로 클래스 안에서 상수 선언함
		  
		  
		 
		 */
		
		final String NICKNAME; //[O]
		//System.out.println(NICKNAME);초기화 안해서 X
		NICKNAME="한소인";
		System.out.println(NICKNAME); //초기화해서 O
		//NICKNAME = "자바"; 상수이기때문에 변경 불가

		

		
		
		
		//락 페이퍼 시져스

	}//main
	
	//public static final int SCISSORE = 1;
	//public static final int ROOK = 2;
	//public static final int PAPER = 3;
	
	//int computer, user;
	//computer = 1;
	//user = 2;

	//System.out.println("컴퓨터 LOSE : 가독성이 낮다" );
	
	
	//computer = SCISSORE;
	//user = ROCK;
	
	
// class 안에 설정한 변수는 member변수
}//class
