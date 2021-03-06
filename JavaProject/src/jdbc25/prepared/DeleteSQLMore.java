package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class DeleteSQLMore extends IConnectImpl {

	@Override
	public void execute() throws Exception {
		connect(ORACLE_URL,"sample","sample");
		String sql="DELETE FROM MEMBER THERE ID=?";
		while(true) {
		psmt=conn.prepareStatement(sql);
		psmt.setString(1, getValue("삭제할 아이디"));
		System.out.println(psmt.executeUpdate()+"행이 삭제되었어요");
		}
	}

	public static void main(String[] args) throws Exception {
		new DeleteSQLMore().execute(); 

	}//main

}//class
