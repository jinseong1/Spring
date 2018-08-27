package accesmodifier07.another;

import accesmodifier07.AccesModifierOne; // 다른 패키지 클래스를 사용하려면 항상 import를 사용하여야한다


public class AccesModifierTwo {
	//[멤버변수]
	//같은 패키지 안은 import 사용 필요없음 다른 패키지이면 import를 사용하여야함
	AccesModifierOne one;
	//멤버메소드
	public void access() {
		//Member 변수
		one = new AccesModifierOne();
		//one.defaultVar=10; [x] 패키지가 달라서 안됨.
		one.publicVar=10;
		//one.privateVar=10;[x]
		//Member 메소드에 접근해보자
		//one.packageMethod();
		one.publicMethod();
		// one.privateMethod(); [x]
		//PackageClass pack = new PackageClass();
	}//void
}//class
