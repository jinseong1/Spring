package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL {
//	멤버변수
	
	private Connection conn;
	private Statement stmt;
	
	public InsertSQL() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl", "sample", "sample");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 존재하지 않습니다 드라이버 로딩 실패");
		}	
		catch (SQLException e) {
			System.out.println("데이터베이스 생성 실패");
		}	
	}
	
	private void execute() {
		try {
			stmt=conn.createStatement();
//			쿼리문 작성
			String sql="INSERT INTO MEMBER(id,pwd,name) VALUES('LEE','1234','이길동')";
			try {
			int affected=stmt.executeUpdate(sql);
			System.out.println(affected+"행이 입력됨....");
			}
			catch (SQLException e) {
				System.out.println("입력커리문 실행 실패");
			}
		
		} catch (SQLException e) {
			System.out.println("Statement객체 생성 실패"+e.getMessage());
		}
		finally {
//			자원반납
			close();
		}
	}
	
	
	private void close() {

			try {
				if(stmt!=null)stmt.close();
				if(conn!=null) {conn.close();}
			}
			catch (SQLException e) {}
		}
		

	public static void main(String[] args) throws SQLException {
		new InsertSQL().execute();
		
		
		
		
		
		
		
	}//main
}//class
