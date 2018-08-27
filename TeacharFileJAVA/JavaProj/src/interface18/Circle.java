package interface18;

//클래스 하나,인터페이스 두개 상속]
public class Circle  implements Figure,Drawable  {

	int radius;	
	public Circle(int radius) {		
		this.radius=radius;
	}///////////////////
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을(를) 그리다");	
	}
	@Override
	public void area(String figureName) {
		System.out.println(figureName+"의 면적:"+radius*radius*Math.PI);
	}
	
}
