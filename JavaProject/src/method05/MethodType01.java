package method05;

//method는 하나의 부품이라고 생각하면 좋다
//method는 class안에 저장하여야한다.
//method정의 시 반드시 반환타입이 있어야한다
//메소드명은 변수 명명규칙처럼 만들면된다
//메소드명은 소문자로 시작한다(권장)
//메소드명은 의미있는 이름으로 지어라

//접근지정자, 반환타입 메소드명([매게변수들]){
//처리할 일;
//[return 결과값;]
//}

//input x output x 
//output x의 경우 반환타입은 void 로 하여야한다

// 출력을 파라미터이나 아규먼트 하고 한다.


//메소드를 main에 호출함
public class MethodType01 {
	//메소드 정의
	static void noParamnoReturn() {
		System.out.println("==============메인메뉴==============");
		System.out.println("1.NEW 2.CONTINUE 3.EXIT");
		System.out.println("=================================");
	}//noParamnoReturn
	
	
	
	//static void noParamnoReturn() {} [X] //동일한 메소드명 불가
	
	static void noParamnoReturn2() {} //[O] // 일을 안하는 메소드다
	
	static void noParamnoReturn3() {
		int returnValue=100;
		System.out.println("[return문 이전]");
		if(returnValue%2==0) {
			System.out.println(returnValue+"는 짝수");
			return;
		}//if
		System.out.println(returnValue+"는 홀수");
		System.out.println("[return문 이후]"); //[O]
		
		// return returnValue; [X]   void의 경우 return(반환) 안됨.
		//return; // [O] ※단독으로 return; 을 사용하는 경우는 메소드를 빠져나가기 위한 경우에 사용한다
		// System.out.println("[return문 이후]"); [X] // Error : Unreachable code
		}//noParamnoReturn3
	
	
	public static void main(String[] args) {
		//input x output x 일때
		 
		//메소드 호출
		noParamnoReturn();
		noParamnoReturn2(); //아무것도 안함
		noParamnoReturn3();
		
		//static void noParamnoReturn4() {} [X] // method 안에서는 method 정의 불가
		//int valur = noParamnoReturn3(); //[X] 값을 반환하지 않으므로 안된다
		//System.out.println(noParamnoReturn3());//[X] 값을 반환하지 않으므로 안된다
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
