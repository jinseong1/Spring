package polymorphism14;

import java.sql.Driver;

/* 만약에 부모의 인스턴스 변수에 자식의 인스턴스 변수가 저장되어 있지 않다면 다운캐스팅 하더라도 실행시 에러
 */


class Base{
	
	void base() {
		System.out.println("Basr의 메소드 : base()");
	}//method
}//class
class NoDerived{}
class Derived extends Base{
	void derived() {
		System.out.println("Derived의 메소드 : derived()");
	}//method
	@Override
	void base() {
		System.out.println("Derived에서 오버라이딩:derive()");
		super.base();
	}
	
}//class

public class RefTypeCasting {

	public static void main(String[] args) {
		Base base = new Base();
		base.base();
		
		Derived derived = new Derived();
		derived.base();
		
		NoDerived noDerived = new NoDerived();
//		noDerived=base; [x] 상속관계가 없음
//		base=noDerived; [x] 상속관계가 없음
//		noDerived=(noDerived)base; [x] 상속관계가 없음
//		base=(base)noDerived; [x] 상속관계가 없음
		/*두 클래스간 상속 관계 존재 시 주소 대입 연산 및 형변환 가능*/
		System.out.println("[base인스턴스 변수에 derived인스턴스 변수 전]");
		System.out.println("Base가 참조하는 클래스명 ↓ ");
		System.out.println(base.getClass().getName());
		base=derived; // 상속관계가 있고 자동 형변환  up casting
		System.out.println();
		System.out.println("[base인스턴스 변수에 derived인스턴스 변수 대입 후 ]");
		System.out.println("Base가 참조하는 클래스명 ↓ ");
		System.out.println(base.getClass().getName());
		base.base(); // 오버라이딩 한 결과가 나옴
//		base.derived(); error = The method derived() is undefined for the type Base
		((Derived)base).derived(); // 강제적 형변환 down casting
		Derived dev=(Derived)base;
		dev.derived();
		
		
		
	}//main
}//class
