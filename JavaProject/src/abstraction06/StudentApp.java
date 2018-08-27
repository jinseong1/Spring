package abstraction06;

class Student{
	//멤버 변수
	Person person;
	Person another = new Person();
	String stNumber; //학번 속성
	//
	void study() {
		System.out.println(person.name+"가(이) 공부하다");
	}
	void printStudent() {
		person.printPerson();
		System.out.println("학번 :"+stNumber);
	}
	
	
	
	
	
}




public class StudentApp {

	public static void main(String[] args) {
		Student student1 = new Student();
		System.out.println("student1="+student1);
		// student1.printStudent();
		// student1.study();
		System.out.println("student1.person = "+student1.person);//null
		//해결
		student1.person = new Person();
		System.out.println("student1.person = "+student1.person);
		System.out.println("[초기화 전]");
		student1.printStudent();
		//초기화
		student1.person.name="박길동";
		student1.person.age=30;
		student1.person.weigth=80;
		student1.stNumber="8853999";
		System.out.println("[초기화 후]");
		student1.printStudent();
		student1.person = student1.another;
		System.out.println("student1.person : "+student1.person);
		System.out.println("student1.another : "+student1.another);
		System.out.println("[초기화 후]");
		student1.printStudent();
		student1.person.name="박길동";
		student1.person.age=30;
		student1.person.weigth=80;
		student1.stNumber="8853999";
		System.out.println("[초기화 후]");
		student1.printStudent();
		
		
	}//main
}//class
