package constructor15;
class Saram{
	String name;
	String lastJumin;
	
	//멤버 변수 초기화용 메소드
	void initialize(String name, String laStJumin) {
		this.name=name;
		this.lastJumin=laStJumin;
	}
	void print() {
		System.out.println(String.format("%s는 %s입니다",name,lastJumin.charAt(0)=='1'?"남자":"여자"));
	}
}//class

class Saram2{
	String name;
	String lastJumin;
	
	public Saram2(String name) {
		name="기본값";
		lastJumin="1234567";
	}
	
	public Saram2() {
		name="기본값";
		lastJumin="1234567";
	}
	
	public Saram2(String name,String lastJumin) {
		this.name=name;
		this.lastJumin=lastJumin;
	}//method
	void print() {
		System.out.println(String.format("%s는 %s입니다",name,lastJumin.charAt(0)=='1'?"남자":"여자"));
	}
}//class


public class Constructor01 {

/*	public Constructor01() {
		super();
		// TODO Auto-generated constructor stub
	}
	*/
	

	

	
	public static void main(String[] args) {
		Saram saram= new Saram();
		saram.initialize("홍길동", "1234567");
		saram.print();
		Saram2 saram2_1=new Saram2();
		saram2_1.print();
		
		Saram2 saram2_2=new Saram2("홍길동");
		saram2_2.print();
		
		Saram2 saram2_3=new Saram2("홍길녀","1234567");
		saram2_3.print();
		
		
		
		
		
		
	}//main
}//class
