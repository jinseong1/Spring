package polymorphism14;

class Parent{
	int parentMember;
	void parentMember() {
		System.out.println("부모의 메소드 : parentMember()");
	}
}
class Child extends Parent{
	int childMember;

	void childMember() {
		System.out.println("자식에서 새롭게 확장한 메소드 : ChildMember()");
	}
	@Override
	void parentMember() {
		System.out.println("자식에서 오버라이딩한 메소드 : parentMember()");
		super.parentMember();
	}
	void parentMember(int childMember) {
		System.out.println("자식에서 오버로딩한 메소드 : parentMember(int childMember)");
		super.parentMember();
	}
}
public class Heterogenious {

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.parentMember);
		System.out.println(child.childMember);
		child.childMember();//새롭게 추가
		child.parentMember();//오버라이딩
		child.parentMember(10);//오버로딩
		Parent parent = new Child();
		System.out.println();
		System.out.println(parent.parentMember);
		parent.parentMember();
//		[이질화]
		Parent parent2 = new Child();
		System.out.println(parent2.parentMember);
		parent2.parentMember();
		((Child)parent2).childMember();
		((Child)parent2).parentMember(10);
//		변수에 저장
		Child child2= (Child)parent2;
		child2.childMember=10;
		child2.childMember();
		child2.parentMember(10);
		
		
		
		
	}//main
}//class
