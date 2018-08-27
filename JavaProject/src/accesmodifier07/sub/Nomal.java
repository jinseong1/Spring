package accesmodifier07.sub;

import accesmodifier07.Super;

public class Nomal extends Super {
	void access() {
//		this.packageMethod();
		this.protectedMethod();
		this.publicMehtod();
	}
}
