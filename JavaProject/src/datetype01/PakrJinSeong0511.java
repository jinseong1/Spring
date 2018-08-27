package datetype01;

public class PakrJinSeong0511 {

	public static void main(String[] args) {
		
		
		int hongKor=98,hongEng=99,hongMath=67,kimKor=99,kimEng=99,kimMath=99,parkKor=56,parkEng=78,parkMath=45;
		int tkor=hongKor+kimKor+parkKor,teng=hongEng+kimEng+parkEng,tmath=hongMath+kimMath+parkMath;
		
		System.out.println("=====================================================");
		System.out.printf("NAME\t%-10s%-10s%-10s%-10s%s%n","KOR","ENG","MATH","TOTAL","AVG");
		System.out.println("=====================================================");
		System.out.printf("Hong\t%-10s%-10s%-10s%-10s%.2f%n",hongKor,hongEng,hongMath,(hongKor+hongEng+hongMath),(hongKor+hongEng+hongMath)/3.0);
		System.out.printf("Kim\t%-10s%-10s%-10s%-10s%.2f%n",kimKor,kimEng,kimMath,(kimKor+kimEng+kimMath),(kimKor+kimEng+kimMath)/3.0);
		System.out.printf("Park\t%-10s%-10s%-10s%-10s%.2f%n",parkKor,parkEng,parkMath,(parkKor+parkEng+parkMath),(parkKor+parkEng+parkMath)/3.0);
		System.out.println("=====================================================");
		System.out.printf("Total\t%-10s%-10s%s%n",tkor,teng,tmath);
		
		
		
		
		
		
		

	}

}
