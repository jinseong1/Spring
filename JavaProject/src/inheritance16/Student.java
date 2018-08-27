package inheritance16;

//student is a person성림
public class Student extends Person {
//	재정의도 가능
	String stNumber;

	public Student() {//부모의 생성자 소환!
		super();//Person의 기본 생성자 호출
		System.out.println("Student의 기본 생성자");
	}
	//인자생성자]

	public Student(String name, int age, String addr,String stNumber) {
		super();//Person의 기본생성자
		this.stNumber = stNumber;
		this.name=name;
		this.age=age;
		this.addr=addr;
		System.out.println("Student의 인자 생성자");
	}
	
//	
	void study() {
		System.out.println(String.format("나이가 %d인 %s가 공부한다", age,name));
	}
	String getStdent() {
		return String.format("%s,학번:%s", getPerson(),stNumber);
	}
	void printStudent() {
		System.out.println(getStdent());
	}
	
	
	
}
