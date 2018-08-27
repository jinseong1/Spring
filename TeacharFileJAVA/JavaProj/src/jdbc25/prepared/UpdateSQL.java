package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {
	public UpdateSQL(String url,String user,String password) {
		super(url,user,password);
	}///////////////////
	@Override
	public void execute() throws Exception {
		//PreparedStatement객체 생성]
		psmt = conn.prepareStatement("UPDATE member SET name=?,pwd=? WHERE id=?");
		//인파라미터 설정]
		psmt.setString(3, getValue("수정할 아이디"));
		psmt.setString(1, getValue("이름"));
		psmt.setString(2, getValue("비밀번호"));
		//쿼리 실행]
		System.out.println(psmt.executeUpdate()+"행이 수정됨");
		//자원반납]
		close();
	}////////////////////////
	public static void main(String[] args) throws Exception{
		new UpdateSQL(ORACLE_URL,"SAMPLE","SAMPLE").execute();;			
	}/////////////////

}///////////////////
