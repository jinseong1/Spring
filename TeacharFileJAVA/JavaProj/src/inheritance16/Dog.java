package inheritance16;

/*
 * 클래스 생성자하자 마자 Dog클래스명에 레드라인 해결법
 * 1.부모 클래스에 기본 생성자 정의하거나
 * 2.자식 클래스에서 부모클래스의 인자 생성자 호출
 */
//[Dog is a Animal성립]
public class Dog extends Animal{

	//[멤버변수]
	//[확장한 멤버]
	String dogKind;
	int year;//Dog에서 새롭게 추가(확장)한 멤버 변수
	
	//기본 생성자]
	public Dog() {
		super(null,0,null);
	}/////////////////
	//[인자 생성자]
	public Dog(String species, int year, String gender,String dogKind) {
		super(species,year,gender);	
		//this();//[x]동시 호출 불가
		/*
		this.species =species;
		//Dog의 year초기화
		//this.year=year;
		//Animal의 year초기화
		super.year=year;
		this.gender=gender;
		*/
		this.dogKind =dogKind;
		//super(species,year,gender);	//[x]항상 첫문장이어야한다
	}////////////////////////////
	//[멤버 메소드]
	void bark() {
		//super(null,0,null);//[x]생성자 안에서만 호출 가능
		System.out.println(super.year+"살인 "+dogKind+"가 짓다");
	}//////////////////
	
	void printDog() {
		printAnimal();
		System.out.println(String.format(",개 종류:%s",dogKind));
	}
	static void staticMethod() {
		//super.//[x]정적 메소드에서 super키워드 사용불가
	}
	int getSuperYear() {
		//Animal의 year반환
		
		return super.year;
	}
	
}

