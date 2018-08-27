package innerclass22;

class OuterStatic{
	static InnerClass innner = new InnerClass();//내부 클래스 인스턴스 화 함
	
	
	
	int outerInstanceVar;
	void outerInstanceMethod() {
		System.out.println(InnerClass.innnerStaticVar);
		InnerClass.innerStaticMethod();
		System.out.println(innner.innerInstanceVar);
		innner.innerInstanceMethod();
	}
	
	static int outerStaticVar;//외부 정적 멤버
	static int sameVar;//외부 정적 멤버
	static void outerStaticMethod() {
		System.out.println(InnerClass.innnerStaticVar);
		innner.innerInstanceMethod();
	}
	//내부 정적 클래스
//	내부 정적 클래스에서 외부 정적클래스 멤버만 사용가능
//	내부에서 외부 쓸때 인스턴스 멤버는 사용 불가능
	static class InnerClass{//class로드할때 생성됨
		int innerInstanceVar;
		int sameVar;
		void innerInstanceMethod() {
			System.out.println(outerStaticVar);
			OuterStatic.sameVar=sameVar;	
		}
		static int innnerStaticVar;
		static void innerStaticMethod() {
			System.out.println(outerStaticVar);
		}
	}//내부 정적 클래스
}//class


public class InnnerStaticClass {

	public static void main(String[] args) {
		OuterStatic.InnerClass.innerStaticMethod();
		OuterStatic.InnerClass inner = new OuterStatic.InnerClass();
		inner.innerInstanceMethod();
		
		
		
		
	}//main
}//class