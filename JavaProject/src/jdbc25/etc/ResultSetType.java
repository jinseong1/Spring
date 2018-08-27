package jdbc25.etc;

import java.sql.ResultSet;
import jdbc25.service.IConnectImpl;

public class ResultSetType extends IConnectImpl{
	
	public ResultSetType(String url,String user,String pass) {
		super(url,user,pass);
	}
	@Override
	public void execute() throws Exception {
		try {
			//1]쿼리문 미리 준비
			String sql="SELECT * FROM member ORDER BY regidate DESC";
			//2]쿼리 실행용 객체(Statement계열-PreparedStatement) 생성
			//2-1]아래는 커서를 레코드 하나씩 전진(forward)만 가능
			//    즉 next()만 호출가능
			//psmt = conn.prepareStatement(sql);
			//2-2]커서를 전/후진이 가능하도록 설정
			psmt= conn.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			
			//3]쿼리 실행
			rs=psmt.executeQuery();
			System.out.println("커서를 마지막 레코드로 이동:"+rs.last());
			System.out.println("총 레코드 수 : "+rs.getRow());
			//커서를 다시 첫번째 레코드 바로 전으로 이동]
			rs.beforeFirst();
			System.out.println("[가입일이 가장 빠른 순]");
			while(rs.next()) {
				System.out.println(String.format("%-10s%-10s%-10s%s",
						rs.getString(1),
						rs.getString(5),
						rs.getString(2),
						rs.getDate(6)!=null ? rs.getDate(6) : ""
						
						));
			}/////while
			System.out.println("[가입일이 가장 늦은 순부터]");
			while(rs.previous()) {
				System.out.println(String.format("%-10s%-10s%-10s%s",
						rs.getString(1),
						rs.getString(5),
						rs.getString(2),
						rs.getDate(6)!=null ? rs.getDate(6) : ""
						
						));
			}/////while
			
		}
		finally {close();}
	}///////////////
	public static void main(String[] args) throws Exception {
		new ResultSetType(ORACLE_URL,"SAMPLE","SAMPLE").execute();;
	}///////////main
}//////////////class
