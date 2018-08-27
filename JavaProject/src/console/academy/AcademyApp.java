package console.academy;

import java.io.IOException;

public class AcademyApp {

	public static void main(String[] args) throws IOException {
		
		
		AcademyCollectionObjectLogic logic = new AcademyCollectionObjectLogic();
		
		while(true) {
			logic.printMainMenu();
//		메인번호 입력 받기
			int mainMenu=logic.getMenuNumber();
			logic.seperateMainMenu(mainMenu);
		}//while
		
		
		
		
	}//main
}//class
