package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

public class DeleteProCall extends IConnectImpl
{

	@Override
	public void execute() throws Exception
	{
		try
		{
			connect(ORACLE_URL, "sample", "sample");
			csmt=conn.prepareCall("{call SP_DELETE_MEMBER(?)}");
			csmt.setString(1, getValue("아이디"));
			csmt.registerOutParameter(4, Types.NUMERIC);
			csmt.execute();
			int affected = csmt.getInt(2);
			switch (csmt.getInt(2)) {
			case 1:System.out.println("1행이 삭제됨");	break;
			case -1:System.out.println("존재하지 않은 아이디입니다");	break;
			case -2:System.out.println("자식이 참조하고 있습니다");	break;
			}
			System.out.println("결과값 : "+csmt.getString(4).trim());
		}//try
		finally {close();}
	}//method
	
	
	
	public static void main(String[] args) throws Exception
	{
		new DeleteProCall().execute();
	}//main
}//class
