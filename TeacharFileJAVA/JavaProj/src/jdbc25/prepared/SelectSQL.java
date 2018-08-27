package jdbc25.prepared;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	public SelectSQL(String url,String user,String pass) {
		super(url,user,pass);
	}//////////////
	@Override
	public void execute() throws Exception {
		//1]미리 쿼리문 준비
		//1-1]인파라미터가 없는 쿼리문
		//String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp ORDER BY hiredate DESC";
		//1-2]파라미터가 있는 쿼리문-특정 문자로 시작하는 레코드 검색
		//String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE ? || '%' ORDER BY hiredate DESC";
		//1-3]파라미터가 있는 쿼리문-특정 문자로 끝나는 레코드 검색		
		//String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE '%' || ? ORDER BY hiredate DESC";
		//1-4]파라미터가 있는 쿼리문-특정 문자가 포함된 레코드 검색
		String sql="SELECT ename,TRIM(TO_CHAR(sal,'L99,999')) sal,job,TO_CHAR(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE '%' || ? || '%' ORDER BY hiredate DESC";
		
		//2]PreparedStatement객체 생성
		psmt =conn.prepareStatement(sql);
		//3]인파라미터 설정-인파라미터 있는 경우
		psmt.setString(1, getValue("찾는 문자열"));
		//4]쿼리실행
		rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println(String.format(
					"%-10s%-7s%-10s%s", 
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)));
		}//////////////while
		
	}////////////////////////////////
	public static void main(String[] args) throws Exception {
		new SelectSQL(ORACLE_URL,"SCOTT","scott").execute();
	}//////////////

}////////////////
