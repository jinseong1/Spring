package method05;

public class CallByValueNReference {


	static void callByValue(int first, int second) {
		int temp;
		temp=first;
		first=second;
		second=temp;
		System.out.printf("[callByValue메소드 안]first;%d,second:%d%n",first,second);
	}//method
	
	static void callByRefernce(int []ref) {
		int temp = ref[0];
		ref[0]=ref[1];
		ref[1]=temp;
		System.out.printf("[callByRefernce메소드 안]ref[0]:%d,ref[1]:%d%n ",ref[0],ref[1]);
		
		
	}//mathod
	
	public static void main(String[] args) {
		
		int first=1;
		int second=100;
		System.out.printf("main Method 안 callbyValue호출 전 first:%d,second:%d%n",first,second);
		callByValue(first, second);
		System.out.printf("main Method 안 callbyValue호출 후 first:%d,second:%d%n",first,second);
		
		
		System.out.println();
		
		int []ref=new int[2];
		ref[0]=1;
		ref[1]=100;
		System.out.printf("main메소드 안 callbyRef호출전 ref[0]:%d ref[1]:%d%n",ref[0],ref[1]);
		callByRefernce(ref);
		System.out.printf("main메소드 안 callbyRef호출후 ref[0]:%d ref[1]:%d%n",ref[0],ref[1]);
		
		
	}//main
}//class