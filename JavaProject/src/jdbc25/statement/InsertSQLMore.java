package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSQLMore {
//	멤버변수
	
	private Connection conn;
	private Statement stmt;
	private static Scanner sc = new Scanner(System.in);
	
	public InsertSQLMore() throws SQLException {
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
			while(true) {
//			쿼리문 작성
				try {
			String sql="INSERT INTO MEMBER(id,pwd,name) VALUES('"+getvalue("아이디").toString().trim()+"',"
					+ "'"+getvalue("비밀번호").toString().trim()+"',"
							+ "'"+getvalue("이름").toString().trim()+"')";
				int affected=stmt.executeUpdate(sql);
				System.out.println(affected+"행이 입력됨....");
				}
				catch (SQLException e) {
				System.out.println("입력커리문 실행 실패");
				}
			catch (NullPointerException e) {
				System.out.println("수고했어요...");
				break;
				}
			}//while
		
		} catch (SQLException e) {
			System.out.println("Statement객체 생성 실패"+e.getMessage());
		}
		finally {
//			자원반납
			close();
		}
	}
//	사용자 입력용 메소드
	public static Object getvalue(String title) {
		System.out.println(title+"를 입력하세요");
		String value=sc.nextLine();

		if("EXIT".equalsIgnoreCase(value)) {
			return null;			
		}
		return value;
	}
	
	
	
	
	
//	자원 반납용 메소드
	private void close() {

			try {
				if(stmt!=null)stmt.close();
				if(conn!=null) {conn.close();}
			}
			catch (SQLException e) {}
		}
		

	public static void main(String[] args) throws SQLException {
		new InsertSQLMore().execute();
		
		
		
		
		
		
		
	}//main
}//class
