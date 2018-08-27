package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl{

	public UpdateSQL(String url,String user,String password) {
		super(url,user,password);
	}
	@Override
	public void execute() throws Exception {
		//1]쿼리 전송용 Statement객체 생성
		stmt = conn.createStatement();
		//2]쿼리문 작성
		String sql="UPDATE member SET name='수정명',tel='123-456',pwd='8989' WHERE id='LEE'";
		//3]쿼리 실행
		System.out.println(stmt.executeUpdate(sql)+"행이 수정됨");
		//4]자원 반납
		close();		
	}//////////////////////////
	public static void main(String[] args) throws Exception {
		new UpdateSQL(ORACLE_URL,"SAMPLE","SAMPLE").execute();
	}/////////////main

}/////////////////class
