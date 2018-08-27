package chatting.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import chatting.service.IConnect;
import chatting.service.IMemberService;



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
	public MemberDAO() {}
	
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
		
		return null;
	}

	@Override
	public MemberDTO selectOne(MemberDTO dto) throws Exception {
		String sql="SELECT * FROM CHATTING WHERE ID=? AND PASSWORD = ?";
		psmt= conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getPwd());
		rs=psmt.executeQuery();
		if(rs.next()) {	
			return dto;
		}		
		return null;
	}////////////////////////////////////
	

	public String selectIdPwd(String dto) throws Exception {		
		String sql="SELECT * FROM chatting WHERE id=?";
		psmt= conn.prepareStatement(sql);
		psmt.setString(1, dto);
		rs=psmt.executeQuery();
		if(rs.next()) {
			String id=rs.getString(1);
			String password=rs.getString(2);
			return String.format("아이디 : %s 비밀번호 : %s", id,password);
		}		
		return null;
	}////////////////////////////////////
	
	public ResultSet selectId(String id) throws Exception {
		String sql="SELECT * FROM chatting WHERE id=?";
		psmt= conn.prepareStatement(sql);
		psmt.setString(1, id);
		
		rs=psmt.executeQuery();
		if(rs.next()) {
			return new MemberDAO().selectId(id);			
		}
		
		return null;
	}
	
	

	@Override
	public int insert(MemberDTO dto) throws Exception {
		String sql="INSERT INTO chatting VALUES(?,?,?,?,?,?,SYSDATE)";
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,dto.getId());
		psmt.setString(2,dto.getPwd());
		psmt.setString(3,dto.getName());
		psmt.setString(4,dto.getAge());
		psmt.setString(5,dto.getGender());
		psmt.setString(6,dto.getTel());
		
		return psmt.executeUpdate();
	}

	@Override
	public int delete(MemberDTO dto) throws Exception {
		String sql="DELETE chatting  WHERE id=?";
		psmt = conn.prepareStatement(sql);		
		psmt.setString(1, dto.getId());
		return psmt.executeUpdate();
	}

	@Override
	public int update(MemberDTO dto) throws Exception {
		return 0;
	}

	@Override
	public void close() {
		
	}
	
	
}
