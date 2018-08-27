package accessmodifier07.sub;

import accessmodifier07.Super;

public class Normal extends Super {
	/*
	 * 두 클래스는 상속 관계로
	 * 다른 패키지 안에 있기 때문에
	 * 생략형은 접근이 불가능함으로 
	 * 상속을 하더라도 보이지 않는다.
	 */
	void access() {
		//this.packageMethod();//[x]
		this.protectedMethod();
		this.publicMethod();
	}
}
