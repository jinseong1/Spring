package eltag;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.PageContext;

import model.BbsDAO;

public class MyTagLibrary {
	//메소드는 public 하고 static해야한다. 반드시 반환값이 있어야한다 -el태그(출력식)안에서 함수호출해서 써야하기 때문에 출력할때 반환값이 없으면 출력이 안되지~~ 
	//숫자형식인지 판별하는 메소드
	public static boolean isNumber(String value) {		
		for(int i=0; i < value.length();i++) {
			if(!(value.codePointAt(i)>='0' && value.codePointAt(i)<='9'))
				return false;
		}	
		return true;
	}///////////////isNumber
	
	/*문]주민번호를 인자로 받아 남성인 경우 "남자"
	 * 여성인 경우 "여자"를 반환하는 메소드(getGender) 정의
	 * 그리고 이를 tld파일에 정의하여라
	 * 주민번호 예]12356-1234567
	 */	
	public static String getGender(String value) {
		/*String[] num = value.split("-");
		if(num[1].startsWith("1")) return "남자";
		else return "여자";*/
		return value.substring(value.indexOf("-")+1, value.indexOf("-")+2).equals("1")?"남자":"여자";
	}///////////getGender
	
	public static boolean isMember(String user, String pass, ServletContext application) {
		BbsDAO dao = new BbsDAO(application);
		boolean flag =dao.isMember(user, pass);
		dao.close();
		return flag;
	}///////isMember
	//BBS글 읽어오기]-BbsDAO의 selectList()메소드 이용
	public static List selectList(ServletContext application) {
		BbsDAO dao = new BbsDAO(application);
		Map map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("end", 10);
		
		List bbsList = dao.selectList(map);
		dao.close();
		return bbsList;
	}
	//URL-인코딩
	public static String urlEncoding(String value) {
		String encoded="";
		try {
			encoded = URLEncoder.encode(value,"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
		return encoded;
	}//////////////////
	
}/////////////////////
