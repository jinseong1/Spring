package abstraction06;

public class GradeApp {

	public static void main(String[] args) {
		GradeLogic logic = new GradeLogic();
		logic.setNumberOfSudent();
		/*
		for(int i=0 ; i<logic.records.length ; i++ ) {
			System.out.println(logic.records[i]);
			
		}//for
		*/
		logic.setNameJumsu();		
		logic.setRank();
		logic.print();
	}//main
}//class
