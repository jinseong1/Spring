package modifier09;

public class StaticBlock {

	public StaticBlock() {
		System.out.println("StaticBlock의 생성자");
	}
	int instanceVar;
	void instanceMethod() {}
	static int staticVar;
	static void staticMethod() {
		int localVar; // 정적 메소드안에서 선언된 지역변수
		System.out.println("정적 메소드");
	}
	
	
	
	//static block은 main보다 먼저 실행된다
	//단 다른 클래스의 main이 있는 경우 main이 순차적으로 실행된다.
	//생성자보다 먼저 static block이 run된다
	//주로 초기화를 먼저 run할때 static을 사용한다
	static {
		System.out.println("[정적블락의 시작]");
		//인스턴스형 멤버  접근 x
		//System.out.println(insranceVar); [x]
		//insranceMethod(); [x]
		//정적멤버 o
		System.out.println(staticVar);
		staticMethod();
		int localVar =100; // static 블락 안에서 선언된 지역 변수
		System.out.println("static block in local : "+localVar);
		System.out.println("[정적블락의 끝]");
	}
	/*
	public static void main(String[] args) {
		
		System.out.println("Main Method");
		
		*/
	
		
	
}//class
