package interface18;
//defualt(pakage)가 생략된거임
//static interface MyInter{} //[X]  class와 동일 static 불가
//final interface MyInter{} [X] //클래스와 다름
//abstract interface MyInter{} //[O] 굳이 붙일 필요 없음

interface MyInter1{
//	인터페이스는 생성자를 만들수 없다
//	public MyInter1() {} [X] error Interfaces cannot have constructors
	public static final int MAX_INT = Integer.MAX_VALUE;
	double MAX_VALUE = Double.MAX_VALUE;
//	추상메소드
	public abstract void noOmit();
//	public abstract 생략된 것과 같다
	void omit();
	}
interface MyInter2{
	void omit();
}

abstract class AbstractClass implements MyInter1{
	
//	추상메소드
//	void abstractMethod(); [X]
	abstract void abstractMethod();
	
}

class MyClass implements MyInter2,MyInter1{

	@Override
	public void noOmit() {
		System.out.println("noOmit() 메소드");		
	}
	
	@Override
	public void omit() {
		System.out.println("Omit() 메소드");
	}
	
//	void omin() {} [X]
	
}

interface MyInter3 extends MyInter1,MyInter2{
	void abstractNerMethod(); // 새롭게 확장한 추상 메소드	
}

class LasyClass extends AbstractClass implements MyInter2,MyInter1{

//	MyInter1
	@Override
	public void noOmit() {}
//	AbstractClass
	@Override
	public void omit() {}
	@Override
	void abstractMethod() {}
}



public class IntefaceBasic {

	public static void main(String[] args) {
//		MyInter1 mi = new MyInter1()  //error : Cannot instantiate the type MyInter1
		
//		이질화
		MyInter1 mi1 = new MyClass();
		mi1.noOmit();
		mi1.omit();
		
		MyInter2 mi2 = new MyClass();
		mi2.omit();
		((MyClass)mi2).noOmit();
		
		MyClass mc=(MyClass)mi2;
		
		System.out.println(mc instanceof MyClass);
		System.out.println(mc instanceof MyInter1);
		System.out.println(mc instanceof MyInter2);
		System.out.println(MyInter1.MAX_INT);
		System.out.println(MyInter3.MAX_INT);
//		클래스명으로 접근
		System.out.println(AbstractClass.MAX_INT);
		System.out.println(MyClass.MAX_INT);
		
		
		
		
		
		
		
		
	}//main
}//////class
