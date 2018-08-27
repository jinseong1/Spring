package modifier09;

// static class staticClass{} // [x] class앞에는 static을 붙일 수 없다
class MyStatic{
	
	int instanceVar;
	
	static int staticVar;
	
	//정적 메소드
	//인스턴스 메소드
	void instanceMethod() {
		System.out.println(instanceVar);
		System.out.println(staticVar);
	}
	//static메소드
	static void staticMethod() {
		//정적 메소드 안에서는 인스턴스형 멤버를 사용할 수 없다
		//System.out.println(instanceVar); [x]
		System.out.println(staticVar);
	}
	
	
	
}

public class StaticModifier {
	int instanceVar;
	void instanceMethod() {}
	static int staticVar;
	static void staticMethod() {}
	
	
	
	
	public static void main(String[] args) {
		//	System.out.println(instanceVar); [X]
		System.out.println(MyStatic.staticVar); // [O]
		MyStatic.staticMethod(); // [O]
		MyStatic ms = new MyStatic();
		System.out.println(ms.instanceVar);
		ms.instanceMethod();
		//정적 멤버도 인스턴스 변수로 접근 가능하나 실생활에 사용하지 않는다
		ms.staticMethod();
		System.out.println(staticVar);
		staticMethod();
		StaticModifier sm = new StaticModifier();
		System.out.println(sm.instanceVar);
		sm.instanceMethod();
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		ms.instanceVar=10;
		ms1.instanceVar=100;
		ms2.instanceVar=1000;
		
		
		System.out.printf("instanceVar : ms : %d,ms1 : %d,ms2 : %d%n",ms.instanceVar,ms1.instanceVar,ms2.instanceVar);
		
		ms.staticVar=10;
		ms1.staticVar=100;
		ms2.staticVar=1000;
		
		System.out.printf("staticVar : ms%d,ms1%d,ms2%d%n",ms.staticVar,ms1.staticVar,ms2.staticVar);
		
		
	}//main
}//class
