package interface18;

//클래스 하나,인터페이스 두개 상속]
public class Triangle extends FigureData implements Figure,Drawable  {

	public Triangle(int width,int height) {
		super(width,height);
	}///////////////////
	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을(를) 그리다");	
	}
	@Override
	public void area(String figureName) {
		System.out.println(figureName+"의 면적:"+width*height*0.5);
	}
	
}
