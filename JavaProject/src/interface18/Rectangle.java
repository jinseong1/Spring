package interface18;

public class Rectangle extends FigureData implements Figure,Drawble {
	
	public Rectangle(int width, int heigt) {
		super(width, heigt);
	}

	@Override
	public void draw(String figureName) {//그림
		System.out.println(figureName+"을 그리다");
	}

	@Override
	public void area(String figureName) {//면적
		System.out.println(figureName+"의 면적 : "+width*heigt);
	}

}
