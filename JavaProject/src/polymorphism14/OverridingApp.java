package polymorphism14;

import javax.jws.soap.SOAPBinding.Style;



public class OverridingApp {

	public static void main(String[] args) throws InterruptedException {
//		인스턴스 변수와 메모리 타입이 같으면 동질화라고 한다
		Student student = new Student("홍길동", 20, "2018학번");
		System.out.println("[자식타입의 인스턴스 변수 - 오버라이딩한 메소드 호출]");
		student.exercise();
		student.sleep(20);
		System.out.println(student.getPerson());
		student.printPerson();
		System.out.println("[자식타입의 인스턴스 변수 - 자식에서 새롭게 확장한 메소드 호출]");
		student.study();
		student.walk(10);
//		
		Student.staticMethod();
		
		Student person = new Student("김길동",30,"2017학번");
		System.out.println("[부모타입의 인스턴스 변수 - 오버라이딩한 메소드 호출]");
		person.exercise();
		person.sleep(10);
		System.out.println(person.getPerson());
		person.printPerson();
//		Student s = new Person(); 
		System.out.println("[부모타입의 인스턴스 변수 - 자식에서 새롭게 확장한 메소드 호출]");
//		Student person.study();
		((Student)person).walk(10);
		((Student)person).study();
		Student st=(Student)person;
		st.wait(10);
		
		
		
		
		
		
		
		
	}//main
}//class
