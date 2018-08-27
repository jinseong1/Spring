package inheritance16;

public class Animal {
	String species;
	int year;
	String gender;
//	기본생성자
	
	public Animal() {super();}
	public Animal(String species, int year, String gender) {
		super();
		this.species = species;
		this.year = year;
		this.gender = gender;
	}
//	멤버메소드
	void printAnmal() {
		System.out.print(String.format("종:%s,나이:%d,암수:%s", this.species,year,gender));
	}
	
	
	
	
}
