package question;

public class TwoClass {
	static int xPoints=0;
	static int yPoints=0;
	
	
	public TwoClass(String x, String y) {
		try {
		
		 int xPoint = Integer.parseInt(x);
		 xPoints=xPoint;
		 int yPoint = Integer.parseInt(y);
		 yPoints=yPoint;
		 System.out.println("정보 저장이 완료되었습니다");
		}
		catch (Exception e) {
		System.out.println("정보 저장이 실패되었습니다");
		}
	}
	
	public static void prints() {
		 if(xPoints<=100 && xPoints>=50 && yPoints<=100 && yPoints>=50) {
			System.out.println("사각형의 안에 있음");
		 }
		 else {
			 System.out.println("사각형의 밖에 있음");
		 }		
	}
	
	
}
