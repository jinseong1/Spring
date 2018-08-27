package abstract17;

public class Triangle extends Figure{

	//[인자 생성자]
	public Triangle(int width, int height) {
		//※추상 클래스의 생성자는 자식 클래스에서
				//호출된다.
		super(width, height, 0);
		
		System.out.println("Triangle의 인자 생성자");
	}
	@Override
	void area(String figureName) {
		System.out.println(figureName+"의 면적:"+width*height*0.5);	
	}/////////////////////////

	
}
