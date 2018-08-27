package abstract17;

public class Circle extends Figure{

	//[인자 생성자]
	public Circle(int radius) {
		//※추상 클래스의 생성자는 자식 클래스에서
		//호출된다.
		super(-1, -1, radius);		
		System.out.println("Circle의 인자 생성자");
	}
	@Override
	void area(String figureName) {
		System.out.println(figureName+"의 면적:"+radius*radius*Math.PI);	
	}/////////////////////////

	
}
