package console;

public class Test {

	public static void main(String[] args) {
		int[] lotto=new int[6];
		BaseBall.setArrayRandom(lotto,1,45);
		for(int i=0;i<lotto.length;i++) {
			System.out.printf("%-3d",lotto[i]);
		}

	}

}
