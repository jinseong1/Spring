package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

public class UpdateProCall extends IConnectImpl
{

	@Override
	public void execute() throws Exception
	{
		try
		{
			connect(ORACLE_URL, "SAMPLE", "SAMPLE");
			csmt=conn.prepareCall("{call SP_UPDATE_MEMBER(?,?,?,?)}");
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("이름"));
			csmt.setString(3, getValue("비밀번호"));
			csmt.registerOutParameter(4, Types.CHAR);
			csmt.execute();
			System.out.println("결과값 : "+csmt.getString(4).trim());
		}//try
		finally {close();}
	}//method
	
	
	
	public static void main(String[] args) throws Exception
	{
		new UpdateProCall().execute();
	}//main
}//class
