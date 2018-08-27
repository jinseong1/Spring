package abstract17;

public class Triangle extends Figure {

//	인자생성자

	@Override
	void arer(String figuerName) {
		System.out.println(figuerName+"의 면적"+width*height*0.5);
		
	}

	public Triangle(int width, int height) {
		super(width, height, 0);
		System.out.println("Triangle의 인자 생성자");
		// TODO Auto-generated constructor stub
	}
	
}
