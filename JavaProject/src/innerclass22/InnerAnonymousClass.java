package innerclass22;
/*익명클래스
 *부모클래스의 메소드를 오버라이딩 하는 것이 주된 용도
 */

class Person{
	String name;

	public Person(String name) {
		this.name=name;
	}
	void print() {
		System.out.println("이름 : "+name);
	}
	
}//Person



class Student extends Person{

	String stNumber;
	
//	인자생성자 
	public Student(String name) {
		super(name);
	}
	
	public Student(String name, String stNumber) {
		super(name);
		this.stNumber = stNumber;
	}
	String get() {
		return String.format("학번:%s", stNumber);
	}
	
//	오버라이딩
	void print() {
		super.print();
		System.out.println(get());
		}
	}
	abstract class AbstractClass{
		abstract void abstactMethod();
}
	interface Inter{
		void abstactMethod();
	}







public class InnerAnonymousClass {

	public static void main(String[] args) {
		Person person=new Student("홍길동","2018학번");
		person.print();
		System.out.println(((Student)person).stNumber);
		System.out.println(((Student)person).get());
		Person anony = new Person("익명자") {
//			멤버변수
			int newVar;//익명클래스에서 새롭게 확장한 멤버
			void newMethod() {
				System.out.println("익명클래스에서 새롭게 확장한 메소드");
			}
			

			@Override
			void print() {
				newVar=100;
				newMethod();
				System.out.println("익명클래스에서 오버라이딩");
			}
			
			
		};
		
		
		
		anony.print();
		
		
		Student anony_Student = new Student("김길동", "2019학번") {
			int age=1;//새롭게 추가한 멤버
			@Override
			String get() {
				return "이름"+this.name+","+super.get()+",나이"+age;
			}
			@Override
			void print() {
				System.out.println(get());
			}
		};
		anony_Student.print();
		
		AbstractClass ac = new AbstractClass() {
			
			@Override
			void abstactMethod() {
				System.out.println("추상메소드 오버라이딩");
			}
		};
		ac.abstactMethod();
		Inter inter = new Inter() {
			
			@Override
			public void abstactMethod() {
				System.out.println("추상메소드 오버라이딩 : 인터페이스");
				
			}
		};
		inter.abstactMethod();
		
		
	}//main
}//class
