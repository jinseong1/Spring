package question;

public class MaxValue {
	
	public int maxvalues(int a, int b) {
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return Math.abs(a);
	}
	public int max(int a, int b) {
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
			if(a<=0) {
				a+=a*2;
			}
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		MaxValue max = new MaxValue();
		System.out.println(max.maxvalues(10, 15));
		System.out.println(max.max(100, -110));
	}

}
