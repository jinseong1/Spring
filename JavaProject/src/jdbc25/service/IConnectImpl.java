package jdbc25.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {
   
   public Connection conn;
   public ResultSet rs;
   public Statement stmt;
   public PreparedStatement psmt;
   public CallableStatement csmt;
   
   static {
	   try {
		   Class.forName(ORACLE_DRIVER);
	   } catch (ClassNotFoundException e) {
		   System.out.println("드라이버 로드 실패: "+e.getMessage());
	   }
   }
   
   public IConnectImpl() {}
   
   
   public IConnectImpl(String url, String user, String password) {
      connect(url,user,password);
   }
   
   
   @Override
   public void connect(String url, String user, String password) {
	      try {
	         conn = DriverManager.getConnection(url, user, password);
	      }
	      catch (SQLException e) {
	    	  System.out.println("데이타 베이스 연결 실패: "+e.getMessage());
	      
	  }
   }
   
   @Override
   public void execute() throws Exception {}

   @Override
   public void close() {
      try {
    	  if(rs !=null) rs.close();
    	  if(stmt != null) stmt.close();
    	  if(psmt != null) psmt.close();
    	  if(conn != null) conn.close();    	
    	  if(csmt != null) csmt.close();    
      }
      catch (Exception e) {}
   }
   Scanner sc = new Scanner(System.in);

   @Override
   public String getValue(String title) {
	   System.out.println(title+"을 입력하세요");
	   String value=sc.nextLine();
	   
	   if("EXIT".equalsIgnoreCase(value)) {
		   System.out.println("프로그램을 종료합니다");
//		      데이터베이스 연결 끊기
		   close();
//		      프로그램 종료
		   System.exit(0);
	   }
      return value;
   }

   @Override
   public String getQueryString() {
	   System.out.print("SQL>");
      return sc.nextLine();
   }
   
}//class