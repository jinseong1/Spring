package interface18;

public class FigureDrawbleApp {

	public static void main(String[] args) {
		//이질화
		Figure f = new Rectangle(10, 10);
		f.area("사각형");
		
		
		Rectangle r =(Rectangle)f;
		r.draw("사각형");
		r.area("사각형");
		
/*		
		((Drawble)f).draw("사각형");
//		((Drawble)f).area;  
		((Rectangle)f).draw("사각형");
		*/
		
		Drawble d = new Triangle(10, 10);
		d.draw("삼각형");
		((Triangle)d).area("삼각형");
		((Figure)d).area("삼각형");
		
//		동질화
		Circle c =new Circle(100);
		c.area("원");
		c.draw("원");
		
		
		
	}//main
}//class
