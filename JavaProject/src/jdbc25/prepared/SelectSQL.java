package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	public SelectSQL(String url, String user, String pass) {
		super(url,user,pass);
	}
	
	
	

	@Override
	public void execute() throws Exception {
//		String sql="SELECT ENAME,TRIM(TO_CHAR(SAL,'L999,9999'))SAL, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM EMP ORDER BY HIREDATE DESC";
//		String sql="SELECT ENAME,TRIM(TO_CHAR(SAL,'L999,9999'))SAL, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM EMP WHERE ENAME LIKE ? || '%' ORDER BY HIREDATE DESC";
//		String sql="SELECT ENAME,TRIM(TO_CHAR(SAL,'L999,9999'))SAL, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM EMP WHERE ENAME LIKE '%' || ? ORDER BY HIREDATE DESC";
		String sql="SELECT ENAME,TRIM(TO_CHAR(SAL,'L999,9999'))SAL, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM EMP WHERE ENAME LIKE '%' ||  ?  || '%' ORDER BY HIREDATE DESC";
		psmt=conn.prepareStatement(sql);
		psmt.setString(1, getValue("찾는 문자열"));
		rs=psmt.executeQuery();
		while(rs.next()) {
			System.out.println(String.format(
					"%-10s%-10s%-10s%s",
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
					));
		}//while
	}




	public static void main(String[] args) throws Exception {
		new SelectSQL(ORACLE_URL,"scott","scott").execute();
		
		
		
		
		
		
		
	}//main
}//class
