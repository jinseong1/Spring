package constructor15;

class Point{
	private int x,y;
	public Point() {
		this(1,1);
		System.out.println("[기본생성자]");
	}
//	[인자생성자]
	public Point(int y) {
		this(1,y);
		
		System.out.println("[인자생성자 :y]");
}
	
	
	public Point( int x,int y) {
		this.x=x;
		this.y=y;
		System.out.println("[인자생성자 :x, y]");
}
	//일반 멤버 메소드
	void print() {
//		this(1,1) [x]
		System.out.println(String.format("X좌표:%d  Y좌표:%d",x,y));
	}
}



public class Constructor03 {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.print();
		Point point2 = new Point(10);
		point2.print();
		Point point3 = new Point(10, 20);
		point3.print();
		
		
		
		
		
	}//main
}//class
