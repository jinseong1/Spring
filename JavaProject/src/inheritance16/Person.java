package inheritance16;


public class Person /*extends Object*/{//모든 클래스는 오브젝트를 자동으로 상속받는다
	String name;
	int age;
	String addr;
	public Person() { //Person의 생성자
		super(); //Object기본 생성자로 일을 하지 않는다
		System.out.println("Person의 기본 생성자");
	}
	String getPerson() {
		return String.format("이름:%s,나이:%d,주소:%s",name,age,addr);
	}
	void printPerson() {
		System.out.println(getPerson());
	}
}