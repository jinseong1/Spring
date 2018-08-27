package inheritance16;

public class PersonApp {

	public static void main(String[] args) {
		System.out.println("[기본생성자 객체 생성]");
		Student student1=new Student();
		student1.printStudent();
		//인스턴스 변수로 접근해서 멤버 초기화
		student1.name="홍길동";
		student1.age=20;
		student1.addr="가산동";
		student1.stNumber="2000학번";
		student1.printStudent();
		student1.study();
		System.out.println("[인자생성자 객체 생성]");
		Student student2=new Student("김길동", 30, "강남", "2018학번");
		student2.printStudent();
		student2.study();
		System.out.println("[기본생성자 객체 생성:Teacher]");
//		Teacher teacher = new Teacher(); 기본 생성자를 직접 정의해주어야한다
		Teacher teacher = new Teacher("박길동", 40, "인천", "JAVA");
		teacher.printTeacher();
		teacher.teach();
		
		
	}//main
}//class
