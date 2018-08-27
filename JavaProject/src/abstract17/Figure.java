package abstract17;

//추상클래스
public abstract class Figure {
//	멤버변수
	int width,height,redius;
	
	public Figure() {
		System.out.println("Figuer의 기본 생성자");
	}

	public Figure(int width, int height, int redius) {
		this.width = width;
		this.height = height;
		this.redius = redius;
		System.out.println("Figuer의 인자 생성자");
	}
//	도형의 면적을 구하는 추상 메소드
	abstract void arer(String figuerName);
}
