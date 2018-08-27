package accesmodifier07.sub;

import accesmodifier07.Super;

public class General {
	void access() {
		Super sup =new Super();
//		sup.packageMethod();
		sup.protectedMethod();
		sup.publicMehtod();
	}
}
