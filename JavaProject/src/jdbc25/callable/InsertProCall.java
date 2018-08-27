package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

public class InsertProCall extends IConnectImpl
{

	@Override
	public void execute() throws Exception
	{
		try
		{
			connect(ORACLE_URL, "sample", "sample");
			csmt=conn.prepareCall("{call SP_INSERT_MEMBER(?,?,?,?)}");
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("이름"));
			csmt.setString(3, getValue("비밀번호"));
			csmt.registerOutParameter(4, Types.NVARCHAR);
			csmt.execute();
			System.out.println("결과값"+csmt.getString(4));
			
		}//try
		finally {close();}
	}//method
	
	
	
	public static void main(String[] args) throws Exception
	{
		new InsertProCall().execute();

	}//main
}//class
