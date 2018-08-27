package question;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TodayMM {
	
	
	public String start(int user) {
		if(user<=31) {
		String aaa[] = {"일","월","화","수","목","금","토"};
	    Calendar cal= Calendar.getInstance ();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.DATE, user);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String days = aaa[day].toString();
		return days;
		}
		else {
			String error = "지정된 날자 범위를 넘었습니다";
			return error;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("2018년 07월 nn일의 요일 구하기");
		System.out.println("날짜를 입력하여 주세요");
		int user = sc.nextInt();
		
		TodayMM mm = new TodayMM();
		
	
		if(mm.start(user).toString()=="지정된 날자 범위를 넘었습니다") {
			System.out.println("1부터 31까지만 입력하세요 ");
		}
		else {
		System.out.println("2018년 07월 "+user+"일은 "+mm.start(user)+"요일 입니다");
		}
	}

}
