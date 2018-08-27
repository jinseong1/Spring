package abstract17;

abstract class NoHavingAbstactMethod{
//	멤버상수
	public static final int MAX_INT = Integer.MAX_VALUE;
//	멤버변수
	int instanceVar;
	static int staticVar;
//	멤버메소드
	void instanceMethod() {}
	static void staticMethod() {}
	
}

//	추상클래스를 자식이 상속받음
class NoHavingChild extends NoHavingAbstactMethod{
	int newVar;
	
	
//	추상 메소드를 상속받은 경우 오버라이딩 안해도 됨
	@Override
	void instanceMethod() {
		// TODO Auto-generated method stub
		super.instanceMethod();
	}
	
	
	
}
abstract class HavingAbstactMethod{
	
//	void abstactMethod();  구현부{}가 없어서 에러
	abstract void abstactMethod();
	
}

class HavingChild extends HavingAbstactMethod{

//	추상클래스를 상속받으면 의무적으로 오버라이딩을 해야한다
	@Override
	void abstactMethod() {
		System.out.println("HavingChild에서 오버라이딩한 메소드 : abstactMethod()");
	}
	void newMethod() {
		System.out.println("HavingChild에서 새롭게 확장한 메소드 : newMethod()");
	}
	
}
//	추상클래스를 자식이 상속받았을때 오버라이딩하기 싫은 경우 자식 클래스를 추상클래스로 만든다
abstract class HavingChildNoOverriding extends HavingAbstactMethod{
	abstract void abstractNewMethod();

	
}
class HavingNewChild extends HavingChildNoOverriding{

	@Override
	void abstractNewMethod() {}
	@Override
	void abstactMethod() {}
}

public class AbstractClassbasic {

	public static void main(String[] args) {
//		일반적인 클래스로 인스턴스화가 됨
//		NoHavingAbstactMethod nam = new NoHavingAbstactMethod(); // error = Cannot instantiate the type NoHavingAbstactMethod
//		이질화 
		NoHavingAbstactMethod nam = new NoHavingChild(); // [O] 이질화 헤테로이지어스
//		자식이 새롭게 확장한 멤버 접근 방법으로 강제 형변환
		System.out.println(((NoHavingChild)nam).newVar);
//		추상메소드를 가진 클래스
//		이질화
		HavingAbstactMethod ham = new HavingChild();
//		오버라이딩한 메소드
		ham.abstactMethod();
//		자식에서 새롭게 확장한 멤버 사용 방법
		((HavingChild)ham).newMethod();
//		두개는 상속관계가 없어 주소대입연산불가 및 형변환 불가
//		HavingChild hc = new HavingNewChild();
//		abstract는 클래스명으로 접근
		System.out.println(NoHavingAbstactMethod.MAX_INT);
//		추상클래스를 상속받은 클래스로 접근
		System.out.println(NoHavingChild.MAX_INT);
		
		
		
		
		
		
		
	}//main
}//class
