package modifier09;
/*
[static 블락]
-동일 클래스 안의 main보다 먼저 실행됨 즉 main에 실행코드가 없어도
 static블락안에 있는 내용이 실행됨
 단, 다른 클래스에 main이 있는 경우는 
 main이 순차적으로 실행되다 static블락이 있는 클래스를 인스턴스화 할때
 그때 생성자보다 먼저 static블락이 실행된다.  

-static 블락안에서는 정적 멤버만 사용가능	
-형식    
     static{
     
		
		
     
     } 
 */
public class StaticBlock {
	
	public StaticBlock() {
		System.out.println("StaticBlock의 생성자");
	}	
	//[인스턴스형 멤버]
	int instanceVar;
	void instanceMethod() {}
	//[정적 멤버]
	static int staticVar;
	
	static void staticMethod() {
		int localVar;//[o]정적 메소드안에서 선언된 지역변수
		System.out.println("정적 메소드");
	}
	
	static {
		System.out.println("[정적블락 시작]");
		//인스턴스형 멤버 X]
		//System.out.println(instanceVar);//[x]
		//instanceMethod()//[x]
		//정적 멤버 o]
		System.out.println(staticVar);//[o]
		staticMethod();//[o]	
		int localVar =100;//static블락안에서 선언한 지역변수
		System.out.println("static블락 안 지역변수:"+localVar);
		System.out.println("[정적블락 끝]");
	}
	/*
	public static void main(String[] args) {
		System.out.println("메인 메소드");
	}*/

}
