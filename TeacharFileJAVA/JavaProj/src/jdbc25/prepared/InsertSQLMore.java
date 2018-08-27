package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class InsertSQLMore extends IConnectImpl{
	//인자 생성자]
	public InsertSQLMore(String url,String user,String password) {
		super(url,user,password);
	}//////////////////////////
	@Override
	public void execute() throws Exception {
		//1]쿼리문 미리 준비		
		String sql="INSERT INTO member(id,pwd,name,regidate) VALUES(?,?,?,?)";
		//2]쿼리실행을 위한 Statement계열 객체 생성		
		psmt = conn.prepareStatement(sql);
		while(true) {
			//3]쿼리 실행
			//인파라미터 설정
			psmt.setString(1, getValue("아이디"));
			psmt.setString(2, getValue("비밀번호"));
			psmt.setString(3, getValue("이름"));
			
			java.util.Date util = new java.util.Date();
			java.sql.Date date = new java.sql.Date(util.getTime());	
			psmt.setDate(4, date);
			
			System.out.println(psmt.executeUpdate()+"행이 입력됨");
		}
		
	}///////////////////////////
	public static void main(String[] args) throws Exception {
		new InsertSQLMore(ORACLE_URL,"SAMPLE","SAMPLE").execute();
	}////////////////main

}///////////////////class
