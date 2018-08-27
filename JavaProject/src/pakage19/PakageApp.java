/*패키지 선언문*/
package pakage19;

import java.lang.String; // 의미없다
import java.util.Date;


public class PakageApp {

	public static void main(String[] args) {
	
		Date utileDate = new Date();
		System.out.println(utileDate);
		java.sql.Date sqlDate = new java.sql.Date(utileDate.getTime());
		System.out.println(sqlDate);
		
		
	}//main
}//class
