package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	public SelectSQL(String url,String user,String password) {
		connect(url,user,password);
	}
	public void execute() throws Exception{
		try {stmt = conn.createStatement();
//			String sql="SELECT * FROM emp ORDER BY hiredate DESC";
//			String sql="SELECT * FROM EMP WHERE EMPTO="+getValue("사원번호");
			String sql="SEELCT * AVG(SAL) FROM EMP";
			
			
//			String sql="SELECT * FROM EMP WHERE ENAME LIKE'%S%'+getValue";
//			String sql = "SELECT * FROM EMP WHERE LIKE '%" || '"+getValue("찾는 무자열")+"' || '%'";
			
//			쿼리 실행
			rs=stmt.executeQuery(sql);
			
			
			
				
				while(rs.next()) {
					int empno = rs.getInt(1);
					String ename = rs.getString(2);
					String job = rs.getString("job");
					
//					java.sql.Date hiredate = rs.getDate(5);
					String hiredate = rs.getString(5) !=null?rs.getString(5).substring(0, 10):"";
					
					System.out.println(String.format("%-5d%-10s%-10s%s", empno,ename,job,hiredate));
					
					
				}//while
			
				/*
				if(rs.next()) {
					int empno = rs.getInt(1);
					String ename = rs.getString(2);
					String job = rs.getString("job");
				
				}
				else System.out.println("해당 사원번호가 없습니다");
				*/
			
				/*
				rs.next();
				System.out.println("평균연봉 : "+rs.getDouble(1));
				*/
				
				
				
				
			}//try
		catch (SQLException e) {e.printStackTrace();}
		finally {close();}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new SelectSQL(ORACLE_URL,"scott","scott").execute();
	}
}
