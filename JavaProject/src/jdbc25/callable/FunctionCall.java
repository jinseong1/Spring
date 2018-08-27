package jdbc25.callable;

import java.lang.reflect.Executable;
import java.sql.Types;

import jdbc25.service.IConnectImpl;

/*
CREATE OR REPLACE FUNCTION ASTERISK(str VARCHAR2)
RETURN VARCHAR2
IS
BEGIN
	RETURN RPAD(SUBSTR(str, 1, 1), LENGTH(str), '*');
END;
/
*/

public class FunctionCall extends IConnectImpl {
	
	@Override
	public void execute() throws Exception {
		try {
			connect(ORACLE_URL, "scott", "scott");
			csmt=conn.prepareCall("{? =call ASTERISK(?)}");
			csmt.registerOutParameter(1, Types.VARCHAR);
			
			csmt.setString(2, getValue("문자열"));
			System.out.println(csmt.execute());
			
			System.out.println("결과값:"+csmt.getString(1));
			
			
			
			
		}
		finally {
			close();
		}
	}
	

	
	
	
	public static void main(String[] args) throws Exception {
		new FunctionCall().execute();
		
		
		
		
		
		
		
		
		
		
	}//main
}//class