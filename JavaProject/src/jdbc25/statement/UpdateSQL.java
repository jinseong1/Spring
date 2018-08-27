package jdbc25.statement;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {
	public UpdateSQL(String url, String user,String password) {
		super(url,user,password);
		
	}
	
	@Override
	public void execute() throws Exception {
		stmt =conn.createStatement();
		String sql="UPDATE member Set name='수정명',tel='999',pwd='8989' WHERE ID='LEE1'";
//		퀴리실행
		System.out.println(stmt.executeUpdate(sql)+"행이 수정 됨");
//		자원반납
		close();
		
		
	}
	
	
	


	public static void main(String[] args) throws Exception {
		new UpdateSQL(ORACLE_URL,"sample","sample").execute();
		
		
		
		
		
		
	}//main
}//class
