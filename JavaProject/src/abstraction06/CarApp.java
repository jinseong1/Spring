package abstraction06;

class Car{
	//상수 정의
	public static final String AUTO="자동";
	public static final String MANUAL="수동";
	//member 변수
	String carModel; // 차량 모델 등등
	int carYear; // 차량 연식
	String carGear=AUTO; // car Gear
	Person owner; // 차량 소유주
	//member method
	void drive() {
		System.out.println(owner.name+"님이"+carModel+"을(를) 운전한다");
	}// drive
	//프로그램 효율을 위한 멤버 메소드들 멤버 변수 초기화용 메소드
	void initialize() {
		carModel="포르쉐";
		carYear=2018;
		owner = new Person();
		owner.name="회사";
		owner.age=20;		
	}
	//정보출력용 메소드
	void printCar() {
		System.out.println("[차량정보]");
		System.out.println("모델명 : "+carModel);
		System.out.println("연식 : "+carYear);
		System.out.println("기어 : "+carGear);
		System.out.println("소유주 : ");
		owner.printPerson();
		
	}
	public void printPerson() {
		System.out.println();
		
	}
	
	
	
}//car class



public class CarApp {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println("[멤버변수 초기화용 메소드(initialize())호출 전]");
		// car1.printPerson();
		car1.initialize();
		System.out.println("[멤버변수 초기화용 메소드(initialize())호출 후]");
		car1.printCar();
		car1.owner.age=30;
		car1.owner.name="조선기";
		car1.owner.weigth=70;
		System.out.println("[멤버변수 초기화용 메소드(initialize())호출 후]");
		car1.printCar();
		Car car2 = new Car();
		car2.carGear=Car.MANUAL;
		car2.carModel="벤틀리";
		car2.carYear=2018;
		car2.owner=new Person();
		car2.owner.name="조현아";
		car2.owner.weigth=40;
		car2.printCar();
		car2.drive();
				
		
		
		
		
	}//main
}//class
