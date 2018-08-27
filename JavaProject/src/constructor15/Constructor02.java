package constructor15;

public class Constructor02 {

	public static void main(String[] args) {
		Person person1=new Person();
		System.out.println("[초기화용 메소드 initialize()메소드 호출 전]");
		person1.print();
		
		System.out.println("[초기화용 메소드 initialize()메소드 호출 후]");
		person1.initialize("김길동", 20, "가산동");
		person1.print();
		
		System.out.println("[이름만 전달]");
		Person person2=new Person("나길동");
		person2.print();
		
		System.out.println("[이름과 나이 전달]");
		Person person3=new Person("다길동", 20);
		person3.print();
		
		System.out.println("[이름과 나이 전달]");
		Person person4=new Person("라길동", 20, "강남");
		person4.print();
		
		
		
	}//main
}//class
