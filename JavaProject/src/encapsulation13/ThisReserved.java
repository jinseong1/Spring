package encapsulation13;

public class ThisReserved {
//	this; 인스턴스형 메소드 안에서만 사용가능
	int instanceVar,anotherInstanceVar;
	void instanceMethod() {
		System.out.println(this.instanceVar);
		System.out.println(staticVar);
		System.out.println(ThisReserved.staticVar);
		System.out.println(staticVar);
	}
//	정적멤버
	static int staticVar;
	static void staticMethod() {
//		this.;
	}
	void initialize(int instanceVar, int another, int staticVar) {
		this.instanceVar=instanceVar;
		anotherInstanceVar=another; // 이름이 달라 구분이 되므로 굳이 this사용을 추천하지 않음
//		this.staticVar=staticVar; 이 방법은 추천하지 않음
		ThisReserved.staticVar=staticVar;
	}
	public static void main(String[] args) {
		ThisReserved reserved = new ThisReserved();
		reserved.initialize(10, 100, 1000);
		System.out.println("[Member 변수 초기화 후]");
		System.out.println(reserved.instanceVar);
		System.out.println(reserved.anotherInstanceVar);
		System.out.println(staticVar);
	}//main
}//class