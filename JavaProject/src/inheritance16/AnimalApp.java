package inheritance16;

public class AnimalApp {

	public static void main(String[] args) {
		Dog dog =new Dog("포유류",2,"수컷","치와와");
		dog.printAnmal();
		System.out.println();
		dog.printDog();
		dog.bark();
//		부오의 멤버에 접근하려면 별도의 메소드를 자식에 적용해서 만들어야 한다.
		System.out.println("Dog의 year : "+dog.year);
		System.out.println("Animal의 year : "+dog.getSuperYear());
		
	}//main
}//class
