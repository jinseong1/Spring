package constructor15;

//싱글톤으로 미설계시
class NoSingleTone{
//멤버변수
int noShareVar;
//멤버 메소드
void print() {
	System.out.println(String.format("noShareVar : %d", noShareVar));
}
}
//싱글톤으로 설계시
class SingleTone{
int ShareVar;
private static SingleTone single = new SingleTone();
private SingleTone() {}
public static SingleTone getInstance() {
	return single;
}
void print() {
	System.out.println(String.format("ShareVar : %d", ShareVar));
}
}

public class SingleToneDesign {
	
	public static void main(String[] args) {
		NoSingleTone no1=new NoSingleTone();
		no1.noShareVar=100;
		no1.print();
		
		NoSingleTone no2=new NoSingleTone();
		no2.noShareVar=200;
		no2.print();

		System.out.println(String.format("no1:%s,no2:%s,no1의 noShareVar : %d, no2의 noShareVar : %d", no1,no2,no1.noShareVar,no2.noShareVar));
//		싱글톤으로 설계시
		SingleTone st1 = SingleTone.getInstance();
		st1.ShareVar=100;
		st1.print();
		
		SingleTone st2 = SingleTone.getInstance();
		st2.ShareVar=200;
		st2.print();
		
		System.out.println(String.format("st1:%s,st2:%s,st1의 ShareVar : %d, st2의 ShareVar : %d", st1,st2,st1.ShareVar,st2.ShareVar));
		
		
		
		
	}//mani
}//class
