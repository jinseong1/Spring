package accesmodifier07;

// private class PivateClss{}   [x] class에는 private를 붙일 없음

class PackageClass{} // [o] 생략형 접근지정자가 붙은 클래스

public class AccesModifierOne {
	public int publicVar;
	int defaultVar;
	private int privateVar;
	
	//[멤버 메소드]
	public void publicMethod() {
		privateMethod();
	}
	void packageMethod() {}
	private void privateMethod() {
		System.out.println("privateVar : "+privateVar);
	} 
}//class
