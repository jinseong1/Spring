package polymorphism14;

import java.util.Date;

public class Peroson {
	String name;
	int age;
	public Peroson() {}
	public Peroson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep(int age) {
		System.out.println("부모님이 주무신다");
		return null;
	}
	protected int walk(Date date) {
		System.out.println("부모님이 산책하신다");
		return 0;
	}
	public void exercise() {
		System.out.println("부모님이 운동하신다");
	}
	String getPerson() {
		return String.format("이름 : %s, 나이 : %d", name,age);
	}
	void printPerson() {
		System.out.println(getPerson());
	}
	static void staticMethod() {
		System.out.println("부모님의 정적 메소드");
	}

}//class
