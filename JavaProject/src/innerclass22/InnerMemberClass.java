package innerclass22;

import innerclass22.OuterClass.InnerClass;

class OuterClass{
	int outerIstanceVar;
	int sameVar=100;
	static int outerStaticVar;
	
	
//	내부 클래스 인스턴스화 후
//	InnerClass inner = new InnerClass();  //Instance
/*	InnerClass inner;
	public OuterClass() {
		inner = new InnerClass();
		System.out.println("외부클래스의 생성자");
	}*/
	
	void outerInstanceMethod() {	
//		System.out.println(innerInstanceVar);//[X] 외부 클래스에서 내부 클래스 멤버 변수 접근 불가
//		innerInstanceMethod(); [X] 외부 클래스에서 내부 메소드 접근 불가
//		내부 상수 접근
		System.out.println(InnerClass.MAXINT);
		System.out.println(inner.innnerIstanceVar);
		inner.InnerInstanceMethod();		
	}
	static void outerStaticMethod() {
		System.out.println(InnerClass.MAXINT);
	}
	
	class InnerClass{
		int innnerIstanceVar;
		int sameVar=1;
		
//		내부클래스의 생성자
		void InnerInstanceMethod() {
//			내부에서 외부 데이터는 마음대로 사용 가능함
			System.out.println(outerIstanceVar);
			System.out.println(outerStaticVar);
			outerInstanceMethod();
			outerStaticMethod();
			this.sameVar =sameVar;
//			외부 변수 <= 내부 변수 할때
			OuterClass.this.sameVar=sameVar;
		}
		public InnerClass() {
			System.out.println("내부클래스의 생성자");
		}
//		static int innnerStaticVar; [X]
//		static void innnerStaticMethod() {} [X]
		static final int MAXINT=3; //[O]
//		내부클래스에서는 외부 모든 클래스 사용 가능
		
		
	}
	InnerClass inner;
	public OuterClass() {
		inner = new InnerClass();
		System.out.println("외부클래스의 생성자");
	}
}



public class InnerMemberClass {

	public static void main(String[] args) {
//		아에 다른 클래스에서 접근방법
		System.out.println(InnerClass.MAXINT);
//		InnerClass inner = new InnerClass(); 완전히 다른 클래스에서는 인스턴스화가 불가능하다
//		먼저 외부 클래스부터 인스턴스화를 시킨다
		OuterClass outer = new OuterClass(); // 내부클래스도 인스턴스화됨
		
		outer.inner.InnerInstanceMethod();
		
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.InnerInstanceMethod();
		
		
		
		
		
		
		
		
	}//main
}//class
