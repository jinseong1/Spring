package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class UpdateSQLMore extends IConnectImpl {

	
	@Override
	public void execute() throws Exception {
//		0번 데이타 베이스 연결
		connect(ORACLE_URL,"sample","sample");
		
//		쿼리 전송용 객체 생성
		stmt =conn.createStatement();
		while(true) {
		String id = getValue("수정할 아이디");
		String name = getValue("이름");
		String tel = getValue("전화번호");
		String pwd = getValue("비밀번호");
		
		String sql="UPDATE member Set name='"+name+"',tel='"+tel+"',pwd='"+pwd+"' WHERE ID='"+id+"'";
//		퀴리실행
		System.out.println(stmt.executeUpdate(sql)+"행이 수정 됨");
		}
	}


	public static void main(String[] args) throws Exception {
		new UpdateSQLMore().execute();
		
		
		
		
		
		
	}//main
}//class
