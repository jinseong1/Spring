package jdbc25.callable;

import java.sql.Types;
import jdbc25.service.IConnectImpl;

public class IsMemberProc extends IConnectImpl {

	@Override
	public void execute() throws Exception {
		try {
			connect(ORACLE_URL, "SAMPLE", "SAMPLE");
			csmt = conn.prepareCall("{call SP_ISMEMBER(?,?,?)}");
			String username=getValue("아이디");
			csmt.setString(1, username);
			csmt.setString(2, getValue("비밀번호"));
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			int out = csmt.getInt(3);
			System.out.println(out==1? username+"님 즐감하세요":
								out==0?"비밀번호가 일치하지 않아요":"아이디가 불일치합니다");
		}
		finally {close();}
	}
	public static void main(String[] args) throws Exception {
		new IsMemberProc().execute();
		
		
		
		
		
		
	}//main
}//class
