package abstraction06;

public class PersonApp {

	public static void main(String[] args) {
		Person person1=new Person(); //statck 에 주소를 저장할수 있는 메모리를 생성과 동시에 메모리 할당
		//instanceof는 타입을 비교할때 많이 사용한다    ex) sysout(person1 instanceof Person);
		System.out.println("Person1 : "+person1);
		person1.printPerson();
		// person1 calss  초기화
		person1.name="홍길동";
		person1.age=20;
		person1.weigth=80;
		System.out.println("[Member변수 값 할당 후]");
		person1.printPerson();
		person1.eat();
		person1.sleep();
		
		Person person2=new Person();
		System.out.println("Person2 : "+person2);
		System.out.println(person2.getPerson());
		//멤버변수에 데이터저장
		person2.name="김길동";
		person2.weigth=3.14;
		System.out.println("[Member변수 값 할당 후]");
		System.out.println(person2.getPerson());
		
		
		//GC가 돌아다니며 기존의 person2 데이터를 제거한다
		person2 = new Person();
		System.out.println("Person2 : "+person2);
		System.out.println(person2.getPerson());
		

		
		
		
	}//main
}//class
