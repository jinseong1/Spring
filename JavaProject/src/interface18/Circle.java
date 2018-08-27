package interface18;

public class Circle implements Figure,Drawble {
	
	int radius;
	
	public Circle(int radius) {
		this.radius=radius;
	}

	@Override
	public void draw(String figureName) {//그림
		System.out.println(figureName+"을 그리다");
	}

	@Override
	public void area(String figureName) {//면적
		System.out.println(figureName+"의 면적 : "+radius*radius*Math.PI);
	}

}
