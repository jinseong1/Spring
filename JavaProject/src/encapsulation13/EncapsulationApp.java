package encapsulation13;

public class EncapsulationApp {

	public static void main(String[] args) {
		EncapsulationDAO cap = new EncapsulationDAO();
		//데이터초기화
		cap.intialize("김길동", "123456", 10000);
		
		
		cap.print();
		cap.withDraw(1000);
		cap.deposite(100000);
		cap.print();
		
		
	}//main
}//class
