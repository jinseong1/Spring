package abstract17;

public class FigureApp {

	public static void main(String[] args) {
//		Figure f -new Figure(); [X] 인스턴스 불가
		Figure f = new Rectangle(100, 100);
		f.arer("사각형");
		f=new Triangle(100, 100);
		f.arer("삼각형");
		f=new Circle(100);
		f.arer("원");
		Rectangle rect = new Rectangle(10, 10); //동질화
		rect.arer("사각형");
		
//		rect = new Triangle(10, 10); [X] 상속관계가 없음
//		System.out.println(rect instanceof Triangle); [X] 상속관계 없음
		System.out.println(rect instanceof Figure); // [o]
	}

}
