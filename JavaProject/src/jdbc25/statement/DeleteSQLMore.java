package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQLMore {
//	멤버변수
	private Connection conn;
	private Statement stmt;
	private void execute() {
//		데이터베이스 연결
		connect();
		try {
//			Statement 객체 생성
			stmt = conn.createStatement();
				while(true) {
				try {
				System.out.println(stmt.executeUpdate("DELETE FROM MEMBER WHERE ID='"+InsertSQLMore.getvalue("삭제할 아이디").toString().trim()+"'")+"행이 삭제되었어요");
				}
				catch (SQLException e) {
					System.out.println("삭제커리문 실패"+e.getMessage());
				}
				catch (NullPointerException e) {
					System.out.println("수고했어요");
					close();
					System.exit(0);					
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Statement객체 생성 실패"+e.getMessage());
		}
		finally {
//			자원 반납
			close();
		}
	}
	
	
	public DeleteSQLMore() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+e.getMessage());
		}
	}

//	데이터베이스 연결용 메소드 
	private void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl", "sample", "sample");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패:"+e.getMessage());
		}
	}
//	자원반납용 메소드
	private void close() {
		try{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		catch (Exception e) {}
	}
	

	public static void main(String[] args) {
		
	new DeleteSQLMore().execute();
		
		
		
		
		
	}//main


}//class
