package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
	//[멤버 변수]
	private Connection conn;
	private Statement stmt;
	//[생성자]
	public DeleteSQL() {
		//드라이버 로딩]
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+e.getMessage());
		}
		
	}////////////////////	
	//[데이타베이스 연결용 메소드]
	private void connect() {
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SAMPLE", "SAMPLE");
		} 
		catch (SQLException e) {
			System.out.println("데이타베이스 연결 실패:"+e.getMessage());
		}
	}/////////////////////
	//[쿼리 실행용 메소드]
	private void execute() {
		//데이타 베이스 연결]
		connect();
		try {
			//Statement객체 생성]
			stmt = conn.createStatement();
			try {
				//쿼리 실행]
				System.out.println(stmt.executeUpdate("DELETE FROM member WHERE id='PARK'")+"행이 삭제됨");
			}
			catch(SQLException e) {
				System.out.println("삭제 쿼리문 실패:"+e.getMessage());
			}
		} 
		catch (SQLException e) {
			System.out.println("Statement객체 생성 실패:"+ e.getMessage());
		}
		finally {
			//자원 반납]
			close();
		}
		
	}/////////////////////////////
	//자원 반납용 메소드]
	private void close() {
		try {
			if(stmt !=null) stmt.close();
			if(conn !=null) conn.close();
		} 
		catch (Exception e) {}
	}///////////////
	public static void main(String[] args) {
		new DeleteSQL().execute();
	}////////////main

}////////////////class
