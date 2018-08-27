package polymorphism14;

import java.util.Date;

public class Student extends Peroson {
	String stNumber;
	//인자 생성자
	
	
	public Student(String name, int age, String stNumber) {
		super(name, age);//받은걸 그대로 부모에게 넘겨줌
		this.stNumber=stNumber;
	}
	void study() {//자식이 확장한 멤버
		System.out.println(name+"이(가) 공부하다");
	}
//	@Override
	private void eat() {
		System.out.println("학생이 먹다");
	}
	@Override
	public String sleep(int age) {//부모보다 접근지정자가 같거나 넓으야 한다
		System.out.println("학생이 잔다");
		return "";
	}
	int walk(int date) {
		System.out.println("나이가"+age+"인 학생이 걷다");
		return 0;
	}
	@Override
	public void exercise() {
//		super.exercise(); //부모의 메소드를 그대로 사용한 것임
		System.out.println("학생이 운동한다");
	}
//	@Override 정적메소드는 오버라이드 대상이 아님
	static void staticMethod() {
		System.out.println("학생의 정적 메소드");
	}
	@Override
	String getPerson() {
		return super.getPerson()+",학번:"+stNumber;
	}
	@Override
	void printPerson() {
		System.out.println(getPerson());
	}
	
	
	
}//class
