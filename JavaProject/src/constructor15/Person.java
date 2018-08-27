package constructor15;

public class Person {
	String name;
	int age;
	String addr;
	
/*	private Person() {} // 기본생성자이지만 다른 클래스에서 인스턴스화를 하지 못한다
*/	
	public Person() {
/*		name="이름미상";
		age=1;
		addr="부모님 주소";*/
		this("이름미상",1,"부모님주소");
		System.out.println("기본생성자");
	}
	
	public Person(String name) {
/*		this.name=name;
		age=1;
		addr="부모님 주소";*/
		this(name,1,"부모님주소");
		System.out.println("인자 생성자:name");
	}

	public Person(String name,int age) {
/*		this.name=name;
		this.age=age;
		addr="부모주소";*/
		this(name,1,"부모님주소");
		System.out.println("인자 생성자:name,age");
	}
	

	public Person(String name,int age,String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
		System.out.println("인자 생성자:name,age,addr");
	}
	
	void initialize(String name, int age, String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
		System.out.println("initialize Method");
	}
	void print() {
		System.out.println(String.format("[%s님의 정보]", name));
		System.out.println(String.format("나이 : %s", age));
		System.out.println(String.format("사는 곳 : %s", addr));
	}
	
	
	
	
}//class
