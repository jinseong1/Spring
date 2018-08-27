package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class DeleteSQL extends IConnectImpl {

	
	@Override
	public void execute() throws Exception {
		//0]데이타베이스 연결
		connect(ORACLE_URL, "SAMPLE", "SAMPLE");
		//1]미리 쿼리문 준비
		String sql="DELETE FROM member WHERE id=?";
		//2]PreparedStatement객체 생성
		psmt = conn.prepareStatement(sql);
		//3]인파라미터 설정
		psmt.setString(1, getValue("삭제할 아이디"));
		//4]쿼리 실행
		System.out.println(psmt.executeUpdate()+"행이 삭제됨");
		//5]자원반납
		close();
	}//////////////////////

	public static void main(String[] args) throws Exception {
		new DeleteSQL().execute();

	}/////////////////////

}/////////////////
