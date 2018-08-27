package etcclass12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {
	//두 날짜 차이를 반환하는 메소드
	//반환타입long
	//매개변수 String타입의 두 날짜 날짜패턴 구분자(단위)
	public static long getdiffrenceDate(
			String strFDate,
			String strSDate,
			String pattern,
			char dalim) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date fDate=dateFormat.parse(strFDate);
		Date sDate=dateFormat.parse(strSDate);
		
		long fTime=fDate.getTime();
		long sTime=sDate.getTime();
		long diff=Math.abs(fTime-sTime);
		
		switch (Character.toUpperCase(dalim)) {
		case 'D':return diff/(24*60*60*1000);
		case 'H':return diff/(60*60*1000);	
		case 'M':return diff/(60*1000);
		default:return diff/(1000);
		}//swith		
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) throws ParseException {
		Date today = new Date();
		System.out.println("today : "+today);
		System.out.println("today.toString() : "+today.toString());
		System.out.println("today.getYear() : "+(today.getYear()+1900));
		switch (today.getDay()) {
		case 0:System.out.println("일요일");break;
		case 1:System.out.println("월요일");break;	
		case 2:System.out.println("화요일");break;
		case 3:System.out.println("수요일");break;
		case 4:System.out.println("목요일");break;
		case 5:System.out.println("금요일");break;
		case 6:System.out.println("토요일");break;
		}//switch
		System.out.println(String.format("%d년%d월%d일%d시%d분%d초",
				today.getYear()+1900,
				today.getMonth()+1,
				today.getDate(),
				today.getHours(),
				today.getMinutes(),
				today.getSeconds()));
		today.setYear(2002-1900);
		System.out.println("[Year만 재설정 후]");
		System.out.println(String.format("%d년%d월%d일%d시%d분%d초",
				today.getYear()+1900,
				today.getMonth()+1,
				today.getDate(),
				today.getHours(),
				today.getMinutes(),
				today.getSeconds()));
		Date pasteDate = new Date(1970-1900,0,1,0,0,1);
		System.out.println(String.format("%d년%d월%d일%d시%d분%d초",
				pasteDate.getYear()+1900,
				pasteDate.getMonth()+1,
				pasteDate.getDate(),
				pasteDate.getHours(),
				pasteDate.getMinutes(),
				pasteDate.getSeconds()));
		
		long diff=pasteDate.getTime();
		System.out.println(diff+(9*60*60*1000));
		
		//Calendar cal= new Calendar(); [x]
		Calendar cal = Calendar.getInstance();
		System.out.println("cal"+cal);
		System.out.println("cal.toString()="+cal.toString());
		System.out.println("년도 : "+cal.get(Calendar.YEAR));

		
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:System.out.println("일요일");break;
		case 2:System.out.println("월요일");break;	
		case 3:System.out.println("화요일");break;
		case 4:System.out.println("수요일");break;
		case 5:System.out.println("목요일");break;
		case 6:System.out.println("금요일");break;
		case 7:System.out.println("토요일");break;
		}//switch
		
		System.out.println(String.format("%d년%d월%d일%s%d시%d분%d초",
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH)+1,
				cal.get(Calendar.DATE),
				cal.get(Calendar.AM_PM)==0?"오전":"오후",
				cal.get(Calendar.HOUR),
				cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND)
				));
		
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(dateFormat); //주소가 출력됨
		System.out.println("today : "+dateFormat.format(today));
		System.out.println("pasteDate : "+dateFormat.format(pasteDate));
		System.out.println("pasteDate : "+dateFormat.format(new Date()));
		dateFormat.applyPattern("yyyy년MM월dd일a HH시 mm분입니다");
		 
		System.out.println("today : "+dateFormat.format(today));
		System.out.println("pasteDate : "+dateFormat.format(pasteDate));
		System.out.println("pasteDate : "+dateFormat.format(new Date()));
		
		
		dateFormat.applyPattern("yyyy/mm/dd");
		String stringDate="2018/5/25";
		Date parseDate=dateFormat.parse(stringDate);
		System.out.println("parseDate : "+parseDate);
		
		String strFDate="2018.05.25";
		String strSDate="2018.05.26";
		SimpleDateFormat simple=new SimpleDateFormat("yyyy.MM.dd");
		Date sDate=simple.parse(strSDate);
		Date fDate=simple.parse(strFDate);
		long fTime=fDate.getTime();
		long sTime=sDate.getTime();
		
		diff = Math.abs(fTime-sTime);
		System.out.println(" diff= "+diff);
		System.out.println(" 초단위= "+diff/1000);
		System.out.println(" 분단위= "+diff/(1000*60));
		System.out.println("시간단위= "+diff/(1000*60*60));
		System.out.println("하루단위= "+diff/(1000*60*60*24));
		
		System.out.println(fDate.after(sDate)?"fDate가 최신":"sDate가 최신");
		System.out.println(fDate.before(sDate)?"sDate가 최신":"fDate가 최신");
		System.out.println(fDate.equals(sDate)?"날짜가 같다":"날짜가 다르다");
		
		System.out.println(fDate.compareTo(sDate));
		System.out.println(sDate.compareTo(fDate));
		System.out.println(fDate.compareTo(sDate)==0?"날짜가 같다":"날짜가 다르다");
		
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		
		cal1.set(2018,4,25,17,22,10);
		cal2.set(2018,11,25,17,22,10);
		
		Date currentDate=cal1.getTime();
		Date chrismas=cal2.getTime();
		
		simple.applyPattern("yyyy-MM-dd HH:mm:ss");
		String strCurrentDate=simple.format(currentDate);
		String strChrismas=simple.format(chrismas);
		System.out.println("크리스마스까지 남은 일 : "+getdiffrenceDate(strCurrentDate, strChrismas, simple.toPattern(), 'D'));
		
		
	}//main
}//class
