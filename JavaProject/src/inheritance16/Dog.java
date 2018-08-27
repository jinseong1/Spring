package inheritance16;

public class Dog extends Animal {

	String dogkind;
	int year;
//	기본생성자
	public Dog() {
		super(null,0,null);
	}
	//인자생성자
	public Dog(String species, int year, String gender, String dogkind) {
		super(species,year,gender);
		/*this.species=species;
//		자식의 year
//		this.year=year;
		super.year=year;
		this.gender=gender;*/
		this.dogkind=dogkind;
	}
	void bark() {
		System.out.println(super.year+"살인"+dogkind+"가 짖다");
	}
	void printDog() {
		printAnmal();
		System.out.println(String.format(",개 종류:%s", dogkind));
	}

	static void staticMethod() {}
	int getSuperYear() {
//		에니멀의 나이 반환
		return super.year;
	}
	
	
	
}//class
