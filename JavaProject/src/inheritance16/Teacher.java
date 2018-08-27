package inheritance16;

//student is a person성림
public class Teacher extends Person {
//	재정의도 가능
	String subject;


	//인자생성자]

	public Teacher(String name, int age, String addr,String subject) {
		super();//Person의 기본생성자
		this.subject = subject;
		this.name=name;
		this.age=age;
		this.addr=addr;
		System.out.println("Teacher의 인자 생성자");
	}
	
//	
	void teach() {
		System.out.println(String.format("%s샘이 %s과목을 가르치다",name,subject));
	}
	String getTeacher() {
		return String.format("%s,담당과목:%s", getPerson(),subject);
	}
	void printTeacher() {
		System.out.println(getTeacher());
	}
	
	
	
}
