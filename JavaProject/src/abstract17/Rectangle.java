package abstract17;

public class Rectangle extends Figure {

//	인자생성자

	@Override
	void arer(String figuerName) {
		System.out.println(figuerName+"의 면적"+width*height);
		
	}

	public Rectangle(int width, int height) {
		super(width, height, 0);
		System.out.println("Rectangle의 인자 생성자");
		// TODO Auto-generated constructor stub
	}
	
}
