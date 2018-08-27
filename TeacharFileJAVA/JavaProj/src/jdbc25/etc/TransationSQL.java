package jdbc25.etc;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;
//※자바코드로 쿼리실행시 무조건 COMMIT이 일어난다
//단,Connection객체의 setAutoCommit(boolean)메소드로
//설정가능(COMMIT이 안일어 나도록)
public class TransationSQL extends IConnectImpl{

	
	@Override
	public void execute() throws Exception {
		try {
			//데이타베이스 연결]
			connect(ORACLE_URL, "SAMPLE", "SAMPLE");
			//1]자동 커밋이 일어나지 않도록 설정
			conn.setAutoCommit(false);
			//2]첫번째 쿼리문 작성-존재하는 아이디로 삭제
			String sql="DELETE member WHERE id=?";
			//3-1]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, getValue("삭제할 아이디?"));
			//3-2]첫번째 쿼리문 실행
			System.out.println(psmt.executeUpdate()+"행이 삭제됨.");
			//4]두번째 쿼리문 작성-중복된 아이디 입력
			sql="INSERT INTO member(id,pwd,name) VALUES(?,?,?)";
			//4-1]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, getValue("아이디"));
			psmt.setString(2, getValue("비밀번호"));
			psmt.setString(3, getValue("이름"));
			//4-2]두번째 쿼리문 실행
			System.out.println(psmt.executeUpdate()+"행이 입력됨");
			//커밋]
			conn.commit();
			System.out.println("커밋 되었습니다");
		}
		catch(Exception e) {
			//롤백]
			conn.rollback();
			System.out.println("롤백되었습니다");
		}
		finally {
			close();
		}
	}//////////////
	public static void main(String[] args) throws Exception {
		new TransationSQL().execute();
	}////////////////main

}///////////////////class
