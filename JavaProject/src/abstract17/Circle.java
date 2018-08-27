package abstract17;

public class Circle extends Figure {

//	인자생성자

	@Override
	void arer(String figuerName) {
		System.out.println(figuerName+"의 면적"+redius*redius*Math.PI);
		
	}

	public Circle(int redius) {
		super(-1, -1, redius);
		System.out.println("Circle의 인자 생성자");
		// TODO Auto-generated constructor stub
	}
	
}
