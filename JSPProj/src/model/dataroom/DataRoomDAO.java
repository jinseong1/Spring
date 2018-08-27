package model.dataroom;
/*
 * 데이타 베이스와 관련된 CRUD작업을 하는 
 * 로직을 갖고있는 클래스 -DAO계열(Data Access Object) 
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import model.PBKDF2;

public class DataRoomDAO {
	//멤버변수
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	//톰캣이 만들어 놓은 커넷션을 커넥션 풀에서 가져다 쓰기]
	public DataRoomDAO(ServletContext context ) {
		//데이타 베이스 연결하기-커넥션 풀 이용]
		try {
			Context ctx = new InitialContext();
			DataSource source=(DataSource)ctx.lookup(context.getInitParameter("JNDI_ROOT")+"/jdbc/jsp");
			conn = source.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
	}//////////////
	//자원 반납용]-사용한 커넥션 개체를 다시 풀에 반납
	public void close() {
		try {
			//메모리 해제
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			//커넥션 풀에 커넥션 객체 반납 - 메모리 해제 아님
			if(conn!= null) conn.close();
		} catch (SQLException e) {e.printStackTrace();}
	}////////close()
	public List<DataRoomDTO> selectList(Map map) {
		List<DataRoomDTO> list = new Vector<DataRoomDTO>();
		//페이징 적용 전 쿼리
		//String sql= "SELECT * FROM dataroom ORDER BY postdate DESC";
		//페이징 적용 쿼리
		String sql= "SELECT * FROM (SELECT T.*, ROWNUM R FROM (SELECT * FROM dataroom ORDER BY postdate DESC) T) WHERE R BETWEEN ? AND ?";
		try {
			psmt=conn.prepareStatement(sql);
			//시작 및 끝 행번호 설정]
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
			rs= psmt.executeQuery();
			while(rs.next()) {
				DataRoomDTO dto = new DataRoomDTO();
				String no = rs.getString(1);
				dto.setNo(no);
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setPass(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setDowncount(rs.getString(6));
				dto.setAttachedfile(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
				
				list.add(dto);
			}///while
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}////////selectList()
	//전체 레코드 수 얻기용- 페이징
	public int getTotalRecordCount() {
		int totalCount=0;
		String sql = "SELECT COUNT(*) FROM DATAROOM";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {e.printStackTrace();}
		return totalCount;
	}///////
	//입력용
	public int insert(DataRoomDTO dto) {
		int affected=0;		
		String sql="INSERT INTO dataroom(NO,NAME,TITLE,PASS,CONTENT,ATTACHEDFILE) VALUES(seq_dataroom.nextval,?,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getPass());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getAttachedfile());
			
			affected = psmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		return affected;
	}//////insert
	//상세보기용
	public DataRoomDTO selectOne(String no) {
		DataRoomDTO dto = null;
		String sql = "SELECT * FROM dataroom WHERE no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs= psmt.executeQuery();
			if(rs.next()) {
				dto = new DataRoomDTO();				
				dto.setNo(no);
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setPass(rs.getString(4));
				dto.setContent(rs.getString(5));
				dto.setDowncount(rs.getString(6));
				dto.setAttachedfile(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
			}
		}
		catch (Exception e) {e.printStackTrace();}
		return dto;
	}
	//비밀번호 체크용
	public boolean isCorrectPassword(String no, String pass) {
		String sql="SELECT pass FROM DATAROOM WHERE no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				String goodHash = rs.getString(1);
				if(!PBKDF2.validatePassword(pass, goodHash)) {
					return false;
				}
				return true;
			}
			return false;
		}
		catch (Exception e) {e.printStackTrace(); return false;}
	}//////////isCorrectPassword
	//삭제용
	public int delete(String no) {
		int affected=0;		
		String sql="DELETE dataroom WHERE no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			affected = psmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		return affected;
	}////////////delete
	public int update(DataRoomDTO dto) {
		int affected=0;
		String sql="UPDATE dataroom SET name=?, title=?,attachedfile=?, pass=?, content=? WHERE no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAttachedfile());
			psmt.setString(4, dto.getPass());
			psmt.setString(5, dto.getContent());
			psmt.setString(6, dto.getNo());
			affected= psmt.executeUpdate();
		}
		catch (Exception e) {e.printStackTrace();}
		return affected;
	}
	//다운로드 수 증가용
	public void updateDownloadCount(String no) {
		String sql="UPDATE dataroom SET downcount = downcount+1 WHERE no=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, no);
			psmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}////////////////class
