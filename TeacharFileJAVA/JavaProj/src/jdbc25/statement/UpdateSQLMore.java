package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class UpdateSQLMore extends IConnectImpl{

	
	@Override
	public void execute() throws Exception {		
		//0]데이타 베이스 연결
		connect(ORACLE_URL, "SAMPLE", "SAMPLE");
		//1]쿼리 전송용 Statement객체 생성
		stmt = conn.createStatement();
		while(true) {
			String id  = getValue("수정할 아이디");
			String name = getValue("이름");
			String tel  = getValue("전화번호");
			String pwd  = getValue("비밀번호");
			
			//2]쿼리문 작성
			String sql="UPDATE member SET name='"+name+"',tel='"+tel+"',pwd='"+pwd+"' WHERE id='"+id+"'";
			//3]쿼리 실행
			System.out.println(stmt.executeUpdate(sql)+"행이 수정됨");
		}
		
	}//////////////////////////
	public static void main(String[] args) throws Exception {
		new UpdateSQLMore().execute();
	}/////////////main

}/////////////////class
