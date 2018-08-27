package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {
	
	@Override
	public void execute() throws Exception {
		psmt=conn.prepareStatement("UPDATE member SET name=?,pwd=? where id=?");
		while(true) {
			try {
			psmt.setString(3, getValue("수정할 ID"));
			psmt.setString(1, getValue("이름"));
			psmt.setString(2, getValue("비밀번호"));
			System.out.println(psmt.executeUpdate()+"행이 수정되었어요");
			}
			catch (Exception e){}
		}
	}

	
	public UpdateSQL(String url,String user, String password) {
		super(url,user,password);
	}
	
	public static void main(String[] args) throws Exception {
			new UpdateSQL(ORACLE_URL,"sample","sample").execute();

		
	}//main
}//class
