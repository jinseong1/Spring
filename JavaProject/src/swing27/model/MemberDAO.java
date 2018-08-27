package swing27.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbc25.service.IConnect;
import swing27.service.IMemberService;

/*
DAO(Data Access Object)계열 클래스:
데이타에 접근하여 CRUD작업을 처리하는 업무처리 로직(비지니스 로직)
*/
public class MemberDAO implements IMemberService{
	//[멤버 변수]
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	//[생성자]
	public MemberDAO(String url,String user,String password) {
		//데이타베이스 연결]
		try {
			Class.forName(IConnect.ORACLE_DRIVER);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이타베이스 연결 성공");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("데이타베이스 연결 실패");
		}
	}///////////////////////////
	
	@Override
	public Vector<Vector> selectList(MemberDTO dto) throws Exception {
		String sql ="SELECT * FROM member ";
		if(dto !=null) {//검색조건 추가시
			sql+=" WHERE INSTR(id,?) !=0 OR INSTR(name,?) !=0 ";
		}
		sql+=" ORDER BY regidate DESC";
		psmt = conn.prepareStatement(sql);
		
		if(dto !=null) {//검색조건 추가시
			psmt.setString(1, dto.getId());
			psmt.setString(2,dto.getName());
		}		
		rs=psmt.executeQuery();
		Vector<Vector> records = new Vector<Vector>();
		while(rs.next()) {
			//※JTable컬럼 수 와 컬럼명 그리고 순서 에 맞게 ResultSet에서
			//  꺼내와야 된다
			Vector vector= new Vector();
			vector.add(rs.getString(1));
			vector.add(rs.getString(5));
			vector.add(rs.getString(2));
			vector.add(rs.getString(4));
			vector.add(rs.getDate(6));
			
			records.add(vector);
		}
		return records;
	}////////////////////////////////////////////////////

	@Override
	public MemberDTO selectOne(MemberDTO dto) throws Exception {
		String sql="SELECT * FROM member WHERE id=?";
		psmt= conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		rs=psmt.executeQuery();
		
		if(rs.next()) {
			return new MemberDTO();
		}		
		
		return null;
	}////////////////////////////////////

	@Override
	public int insert(MemberDTO dto) throws Exception {
		String sql="INSERT INTO member(id,pwd,name,tel,regidate) VALUES(?,?,?,?,SYSDATE)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getPwd());
		psmt.setString(3, dto.getName());
		psmt.setString(4, dto.getTel());
		
		return psmt.executeUpdate();
	}

	@Override
	public int delete(MemberDTO dto) throws Exception {
		String sql="DELETE member  WHERE id=?";
		psmt = conn.prepareStatement(sql);		
		psmt.setString(1, dto.getId());
		return psmt.executeUpdate();
	}

	@Override
	public int update(MemberDTO dto) throws Exception {
		String sql="UPDATE member SET tel=?,name=?,pwd=? WHERE id=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getTel());
		psmt.setString(2, dto.getName());
		psmt.setString(3, dto.getPwd());
		psmt.setString(4, dto.getId());
		return psmt.executeUpdate();
	}////////////////////////////////////

	@Override
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn !=null) conn.close();
		} catch (Exception  e) {e.printStackTrace();}
		
	}/////////////////////////

}
