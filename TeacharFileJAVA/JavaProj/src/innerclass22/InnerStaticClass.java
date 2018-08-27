package innerclass22;
/*
 * 
 * public class A {
 *  ※A클래스를 인스턴스화 할때  = 오른쪽의 new B()가 실행됨
 * 	B b  = new B();
 *  즉 위는 아래코드와 동일하다
 *  B b;
 *  public A(){
 *  	b= new B();
 *  }
 *  ※JVM에서 클래스 로드시점에 = 오른쪽의 new C()가 실행됨
 *    즉 C클래스의 인스턴스형 멤버도 다른 정적 멤버들처럼
 *    클래스 로드할 시점에 메모리에 생긴다
 *  static C c = new C();
 * 
 * 
 * }
 
 */
/*
내부 정적 클래스:클래스안의 클래스로 class앞에 
               static이 붙음
- 정적 멤버도 가질 수 있고
- 외부 클래스의 인스턴스형 멤버는 사용할 수 없다
- 외부클래스명$내부클래스명.class로 파일이 생긴다.
※ 원래 클래스 앞에는 static을 붙일 수 없으나 
   내부 클래스는 가능하다
*/
class OuterStatic{
	//내부 클래스 타입의 인스턴스변수 선언
	static InnerClass inner = new InnerClass();
	//[외부의 인스턴스형 멤버]
	int outerInstanceVar;
	//내부 클래스 타입의 인스턴스변수 선언
	void outerInstanceMethod() {
		/*
		 * ※내부의 정적 멤버는 내부 클래스 인스턴스화 필요없이
		 *   내부클래스명.내부정적멤버명 으로 접근
		 * ※내부 클래스의 인스턴스형 멤버 접근:
		 *   내부 클래스를 인스턴스화 한후 접근
		 */
		//내부 클래스의 정적 멤버
		System.out.println(InnerClass.innerStaticVar);
		InnerClass.innerStaticMethod();
		//내부 클래스의 인스터스형 멤버-인스턴스화한후 변수로 접근
		System.out.println(inner.innerInstanceVar);
		inner.innerInstanceMethod();
	}/////////////////////////////
	//[외부의 정적 멤버]
	static int outerStaticVar;
	static int sameVar;
	static void outerStaticMethod() {
		//내부 클래스의 정적 멤버
		System.out.println(InnerClass.innerStaticVar);
		//inner가 외부 클래스의 인스턴스형 멤버임으로
		//inner.//[x]-inner에 static이 없을때
		inner.innerStaticMethod();//[o]-inner에 static 붙일때
	}
	//[내부 정적 클래스]
	//※내부 정적 클래스에서는 외부의 정적 멤버만 사용 가능]
	static class InnerClass{
		//[내부의 인스턴스형 멤버]
		int innerInstanceVar;
		int sameVar;
		void innerInstanceMethod() {
			//outerInstanceMethod();//[x]
			//외부의 정적 멤버만 사용가능
			System.out.println(outerStaticVar);
			//외부 클래스명.this는 불가
			OuterStatic.sameVar = sameVar;
		}
		//[내부의 정적 멤버
		//※정적 멤버도 가질수 있다.
		static int innerStaticVar;
		static void innerStaticMethod() {
			System.out.println(outerStaticVar);
		}
	}/////////////////////////InnerClass
}
public  class InnerStaticClass {

	public static void main(String[] args) {
		/*
		 * ※외부 클래스가 아닌 별개의 다른 클래스에서
		 * 내부 정적 클래스에 접근할때는 외부 클래스를
		 * 먼저 인스턴스화 할 필요없이 내부 정적 클래스의
		 * 인스턴스화가 가능하다.	
		 */
		/*1]내부 정적 클래스의 정적 멤버에 접근할때는	    
	         외부클래스명.내부클래스명.정적멤버
		 */	
		OuterStatic.InnerClass.innerStaticMethod();
		//2]내부 클래스의 인스턴스형 멤버 접근시
		//외부 클래스명.내부클래스명 인스턴스변수 = 
		OuterStatic.InnerClass inner = new OuterStatic.InnerClass();
		inner.innerInstanceMethod();
	}///////////main

}//////////////class
