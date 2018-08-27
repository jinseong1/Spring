package globalnlocal08;

public class GlobalNLocalVar {
	
	private int mNoInit;
	int mInit = 100;
	int[] mArray = new int[3];
	int getTotal(int start, int end) {
		int total = 0;
		for(int i=start;i<=end;i++) {
			// 지역변수 초기화
			//total=i; [x]
			total+=i;
		}//for
		 // System.out.println("for 문이 끝난 후:"+i); [x] 지역변수 난 for문 안에서만 사용 사능 
		System.out.printf("%d부터%d까지 누적합 :%d%n",start,end,total);
		if(total % 2==0) {
			String strResult="총합은 짝수";
			// System.out.println(strResult); [x]지역초기화를 안해서
			System.out.println(strResult);
		}//if
		 //else 
			//strResult="총합은 홀수";
		System.out.println("멤버변수:mNoInit= "+mNoInit);
		return total;
	}//int getTotal
	public static void main(String[] args) {
		//인스턴스화 및 메모리 초기화
		GlobalNLocalVar globalNLocalVar= new GlobalNLocalVar();
		System.out.println("멤버변수:mNoInit= "+globalNLocalVar.mNoInit);
		System.out.println("멤버변수:mInit= "+globalNLocalVar.mInit);
		System.out.println("멤버변수:mArray= "+globalNLocalVar.mArray);
		int total=globalNLocalVar.getTotal(1, 10);
		//지역변수 앞에는 접근지정자를 붙일수 없다
		//public int start; [x] 
		int start,end;
		// total = globalNLocalVar.getTotal(start, end); // [x] 초기화를 하지 않아서 에러남
		start=1;
		end=100;
		total = globalNLocalVar.getTotal(start, end);
		System.out.println("[클래스의 멤버인 배열 : 초기화 안함]");
		for(int i=0; i<globalNLocalVar.mArray.length ;i++) {
			System.out.printf("%d번방:%d%n",i,globalNLocalVar.mArray[i]);
		}//out for
		int[] localArray = new int[3];
		System.out.println("[지역에서 선언한 배열 : 초기화 안함]");
		for(int i=0; i<globalNLocalVar.mArray.length ;i++) {
			System.out.printf("%d번방:%d%n",i,localArray[i]);
		}//out for
	}//void
}//class
