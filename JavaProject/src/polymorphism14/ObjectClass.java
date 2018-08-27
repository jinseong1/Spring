package polymorphism14;

class MyClass{
	int date;

	public MyClass(int date) {
		super();
		this.date = date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(date);
	}
	
	@Override
	public int hashCode() {
		return date;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyClass) {// 타입 비교
			MyClass mc = (MyClass)obj;
			if(mc.date==date) {
				return true;
			}//if
			else return false;
		}//if
		return false; // 타입이 MyClass가 아닌 경우
	}//equals
}//class
class Point{
	int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}//
	
//	문1] x=10, y=20 처럼 반환하도록 toString 메소드를 오버라이딩하여라
	
	public String toString() {
		return String.format("x=%d,y=%d",x,y);
	}	
	
//	문2] 저장된 x좌표와y좌표가 같은지 비교하도록 equals메소드를 오버라이딩하여라
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point point = (Point)obj;
			if(x==point.x &&y==point.y ) {
				return true;
			}
			else return false;
		}
		return false;
	}//equals
	
	
	
}





public class ObjectClass {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		System.out.println("[두 객체의 toStiong 메소드 호출]");
		System.out.println(mc1.toString());
		System.out.println(mc1.getClass().getName()+"@"+Integer.toHexString(mc1.hashCode()));
		System.out.println(mc2.toString());
		System.out.println(mc2.getClass().getName()+"@"+Integer.toHexString(mc2.hashCode()));
		
		System.out.println("두 객체를 equals로 비교");
		System.out.println(mc1.equals(mc2)?"같다":"다르다");
		
		
		Point point1 = new Point(10, 20);
		Point point2 = new Point(10, 20);
		System.out.println("[두 객체의 toStiong 메소드 호출]");
		System.out.println(point1.toString());
		System.out.println(point2.toString());
		System.out.println(point1.equals(point2)?"같다":"다르다");
		System.out.println("두 객체를 equals로 비교");
		
		point1.toString();
		point1.equals(point2);
		
		
		
		
	}//main
}//class
