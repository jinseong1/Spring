package jdbc25;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		1. 오라클용 jdbc드라이버 메모리 로딩
		Class.forName("oracle.jdbc.OracleDriver");
//		2-1. 연결시도[객체 준비]
		String url="jdbc:oracle:thin://localhost:1521:orcl";
		String user="scott";
		String password="scott";
//		2-2. 연결
		Connection conn=DriverManager.getConnection(url, user, password);
//		3. 연결 확인
		if(conn !=null) {
			System.out.println("데이터베이스 연결 성공");
			Statement stmt = conn.createStatement();
//			4. 쿼리문 작성
			String sql="SELECT * FROM emp ORDER BY hiredate DESC";
//			5. 쿼리문 실행
			ResultSet rs=stmt.executeQuery(sql);
//			6. 커서를 아래로 이동하면서 꺼내오기
			while(rs.next()) {//next() 더이상 꺼내올 레코드가 없으면 false반환
				int empto=rs.getInt(1);
				String ename=rs.getString(2);
				String job=rs.getString("job");
				int sal=rs.getInt(6);
				Date hiredate = rs.getDate("hiredate");
				System.out.println(String.format("%-5d %-10s %-9s %-6d %s", empto,ename,job,sal,hiredate));
			}//while
//			7. 자원반납
			rs.close();
			stmt.close();
			conn.close();
		}//if
		else {
			System.out.println("데이터베이스 연결 실패");
		}//else
		
		
		
		
		
		
		
	}//main
}//class
