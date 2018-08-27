package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class InsertSQLMore extends IConnectImpl{
	
	public InsertSQLMore(String url, String user, String password) {
		super(url,user,password);
	}
	
	public void execute() throws Exception{
//		String sql="INSERT INTO MEMBER(id,pwd,name) VALUES('JIN','1234','진길동')";
		String sql="INSERT INTO MEMBER(id,pwd,name,regidate) VALUES(?,?,?,?)";
		psmt=conn.prepareStatement(sql);
		while(true) {
			try {
				psmt.setString(1, getValue("아이디"));
				psmt.setString(2, getValue("비밀번호"));
				psmt.setString(3, getValue("이름"));
//				psmt.setString(4, "2018-06-22");
//				날짜 입력
				java.util.Date util = new java.util.Date();
				java.sql.Date date = new java.sql.Date(util.getTime());
				psmt.setDate(4, date);
				
				System.out.println(psmt.executeUpdate()+"행이 입력되었습니다");
			}
			catch (Exception e) {
				System.out.println("이미 있는 아이디입니다");
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		new InsertSQLMore(ORACLE_URL,"sample","sample").execute();
		
		
		
		
		
		
	}//main
}//class
