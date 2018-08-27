package abstraction06;

public class Person {
	public String name; //이름 속성 퍼블릭 접근지정자 사용
	public int age=1; // 나이 속성 생략형 접근지정자 사용 선언과 동시에 초기화
	public double weigth; // 몸무게 속성 생략형 접근지정자 사용
	//멤버 메소드 정의
	public void sleep() {
		System.out.println(name+"이(가) 자다");
	}//sleep
	void eat() {
		System.out.printf("나이가 %d살인 %s이(가) 먹다%n그러니 몸무게가 %.2f이지...",age,name,weigth);
	}//eat
	//프로그램 효율성을 위한 메소드들
	public String getPerson() {
		return "["+name+"의 정보]\r\n"+"나이:"+age+"\r\n몸무게:"+weigth+"Kg";	
	}
	void printPerson() {
		System.out.println(getPerson());
	}
	
	
	
}//class Person
