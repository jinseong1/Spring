package polymorphism14;

public class Overloading {
//	메소드명 동일, 매개변수타입 및 개수 및 순서가 동일하기 떄문에 동일메소드이다
//	int noOverloading(String str0,Date date) {return 0;} [X]
//	float noOverloading(String string,Date today) {return 0;} [X]
	
	void paramTypeDiff(int param) {}
	void paramTypeDiff(float param) {}
	void paramTypeDiff(double param) {}
	
	void paramCountDiff() {}
	void paramCountDiff(int param) {}
	void paramCountDiff(int param1, int param2) {}
	
	void paramOrderDiff(int param1, float param2, double param3) {}
	void paramOrderDiff(int param1,double param3, float param2) {}
	void paramOrderDiff(double param3,int param1, float param2) {}
	
	
//	※VarArgs※
/*	static int getTotal(int param) {
		int total=0;
		total+=param;
		return total;
	}
	static int getTotal(int param, int param2) {
		int total=0;
		total+=param+param2;
		return total;
	}	
	static int getTotal(int param, int param2,int param3) {
		int total=0;
		total+=param+param2+param3;
		return total;
	}	*/
//	※VarArgs※ 기능 적용
	static int getTotal(int...param) {
		int total=0;
		for(int i=0;i<param.length;i++) {
			total+=param[i];
		}
		return total;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getTotal(10));
		System.out.println(getTotal(10, 20));
		System.out.println(getTotal(10, 20, 30));
		System.out.println(getTotal(1,2,3,4,5,6,7,8,9,10));
		
		
		
		
		
		
		
	}//main
}//class
