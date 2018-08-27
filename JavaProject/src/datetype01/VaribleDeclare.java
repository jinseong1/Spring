package datetype01;

public class VaribleDeclare {

	public static void main(String[] args) {
		//변수를 선언하면 램에 공간이 생긴다.
		int num;
		num = 100; //최초로 값을 저장하는 것을 변수 초기화라고 한다
		//System.out.println(num);//[x]
			System.out.println("[변수선언방법1]");
			System.out.println(num);
		int iniNum = 200; //선언과 동시에 초기화
			System.out.println("[변수선언방법2]");
			System.out.println(iniNum);
			System.out.println("[변수선언방법3]");
		int fnum, snum = 1000, tnum;
		//System.out.println(fnum);//
		fnum = snum; //fnum 초기화
			System.out.println("fnum="+fnum);
		
		//fnum = snum+tnum; 을하면 tnum가 초기화가 안돼 오류 남.
		tnum = 500;
		fnum = snum+tnum;
		//System.out.println(fnum);
			System.out.println("fnum="+fnum);
			
			//100 = fnum;//[X]
			
			
			// = 할당연산자, 대입연산자 (항상 왼쪽에는 변수가 와야함.)
			//
			//int = fnum//[X] 같은지역 안에서는 동일한 변수 사용 불가

			//int fNum;//[O] //대문자 소문자 구분됨.
			//int 4you; //[X]
			//int you4, y4ou; //[O]
			//int special@var; //[X] 특수문자 불가
			//int spe_cialvar; // [O] $, _ 는 특수문자 사용가능
			//public 등 예약어는 사용 불가
			//int public
			//int Public; //[O] // 변수명은 소문자로 시작(권장사항)
	
	
	}

}
