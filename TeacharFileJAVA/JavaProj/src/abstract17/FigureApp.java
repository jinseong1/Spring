package abstract17;

public class FigureApp {

	public static void main(String[] args) {
		//Figure f = new Figure();//[x]인스턴스화 불가
		Figure f = new Rectangle(100, 100);//이질화
		f.area("사각형");
		
		f= new Triangle(100, 100);
		f.area("삼각형");
		
		f= new Circle(100);
		f.area("원");
		
		Rectangle rect = new Rectangle(10, 10);//동질화
		rect.area("사각형");
		//[x]상속관계가 존재하지 않음으로
		//rect = new Triangle(10, 10);//[x]
		//System.out.println(rect instanceof Triangle);//[x]
		System.out.println(rect instanceof Figure);//[o]
	}///////////

}//////////////
