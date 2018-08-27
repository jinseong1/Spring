package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.sql.DataSource;

//DAO(Data Access Object):데이터에 접근해서  crud작업을 수행하는 업무처리 로직

public class BbsDAO {
	//멤버변수]
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	//생성자]
	public BbsDAO(ServletContext context) {

		//커넥션 풀 사용하기
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(context.getInitParameter("JNDI_ROOT")+"/jdbc/jsp");
			conn=ds.getConnection();
		}
		catch (NamingException | SQLException e) {e.printStackTrace();}
		
		/*try {
			//드라이버 로딩
			Class.forName(context.getInitParameter("ORACLE_DRIVER"));
			//데이타베이스 연결]
			conn = DriverManager.getConnection(
					context.getInitParameter("ORACLE_URL"),
												"SAMPLE", 
												"SAMPLE");
			System.out.println("데이터베이스 연결 성공");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}*/
	}//////////
	//자원반납용]
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(psmt!=null) psmt.close();
			if(conn!= null) conn.close();
		} catch (Exception e) {e.printStackTrace();}
	}/////
	//회원여부 판단용]
	public boolean isMember(String user, String pass) {
		String sql="SELECT pwd FROM member WHERE id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user);
			rs=psmt.executeQuery();
			if(rs.next()) {
				String goodHash = rs.getString(1);
				boolean flag =false;
				try {
					flag=PBKDF2.validatePassword(pass, goodHash);
				}
				catch (Exception e) {e.printStackTrace();}
				if(flag) {
					return true;
				}
				return false;
			
		
			}//if
			return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}////isMember
	//전체 목록 가져오기]
	//페이징 로직 추가하기
	//DAO 에서 할일 
	//1. 전체 목록 퀴리를 구간 쿼리로 변경
	//2.총 레코드 수 구하는 메소드 추가
	
	public List<BbsDTO> selectList(Map<String, Object> map) {
		List<BbsDTO> list = new Vector<BbsDTO>();
		// 페이징
		String sql = "SELECT * FROM (SELECT T.*, ROWNUM R FROM (SELECT b.*, name FROM member m JOIN bbs b ON m.id = b.id ";
		// 검색 시 아래 쿼리문 연결
		if (map.get("column") != null) {
			sql += " WHERE " + map.get("column") + " LIKE '%" + map.get("word") + "%' ";
		}
		sql += " ORDER BY no DESC) T) WHERE R BETWEEN ? AND ? ";
		try {
			psmt = conn.prepareStatement(sql);
			// 페이징을 위한 시작 및 종료 ROWNUM 설정]
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setContent(rs.getString(4));
				dto.setId(rs.getString(2));
				dto.setNo(rs.getString(1));
				dto.setPostDate(rs.getDate(6));
				dto.setTitle(rs.getString(3));
				dto.setVisitCount(rs.getString(5));
				dto.setName(rs.getString(7));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}/////////////
	//전체 레코드 수 얻기 용]
	public int getTotalRecordCount(Map<String,Object>map) {
		int totalRecordCount=0;
		
		String sql ="SELECT COUNT(*) FROM member m JOIN bbs b ON m.id = b.id";
		
		   // 검색 시 아래 쿼리문 연결
	      if(map.get("column") != null)   
	         sql += " WHERE "+ map.get("column") +" LIKE '%"+map.get("word")+"%' ";
	      
	      try {
	    	  psmt= conn.prepareStatement(sql);
	    	  rs=psmt.executeQuery();
	    	  rs.next();
	    	  totalRecordCount=rs.getInt(1);
	      }
	      catch(Exception e) {e.printStackTrace();}
	      return totalRecordCount;
	}////////////
	
	//입력
	public int insert(BbsDTO dto) {
		int affected=0;
		String sql = "INSERT INTO bbs(no,id,title,content) VALUES(SEQ_BBS.NEXTVAL,?,?,?)";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			affected=psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return affected;
	}////insert
	//수정
	public int update(BbsDTO dto) {
		int affected=0;
		String sql ="UPDATE bbs SET title=?, content=? WHERE no=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(3, dto.getNo());
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			affected =psmt.executeUpdate();
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return affected;
	}
	
	//삭제
	public int delete(String no) {
		int affected=0;
		String sql ="DELETE bbs WHERE no=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1,no);
			affected =psmt.executeUpdate();
		}
		catch(SQLException e) {e.printStackTrace();}
		return affected;
	}
	//조회수 업데이트
	public void updateVisitCount(String no) {
		String sql = "UPDATE bbs SET visitcount = visitcount+1 WHERE no=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, no);
			psmt.executeUpdate();
		}
		catch (Exception e) {e.printStackTrace();}
	}//////////updateVisitCount
	//상세보기
	public BbsDTO selectOne(String no) {
		String sql="SELECT b.* , name FROM member m JOIN bbs b ON m.id = b.id WHERE no=?";
		BbsDTO dto =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs= psmt.executeQuery();
			if(rs.next()) {
				dto = new BbsDTO();
				dto.setContent(rs.getString(4));
				dto.setId(rs.getString(2));
				dto.setNo(rs.getString(1));
				dto.setPostDate(rs.getDate(6));
				dto.setTitle(rs.getString(3));
				dto.setVisitCount(rs.getString(5));
				dto.setName(rs.getString(7));
			}//if
		} 
		catch (Exception e) {e.printStackTrace();}
		return dto;
	}/////////selectOne
	//이전글/다음글/
	public Map<String,BbsDTO> prevNext(String no){
		String sql="SELECT no,title FROM bbs WHERE no = (SELECT MIN(no) FROM bbs WHERE no > ?)";
		Map<String,BbsDTO> map = new HashMap<String,BbsDTO>();
		try {
			//이전글 얻기
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs=psmt.executeQuery();
			if(rs.next()) {//이전글이 있는 경우
				map.put("PREV", new BbsDTO(rs.getString(1), null, rs.getString(2), null,null,null));
			}
			//다음글 얻기
			sql="SELECT no,title FROM bbs WHERE no = (SELECT MAX(no) FROM bbs WHERE no <?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs=psmt.executeQuery();
			if(rs.next()) {//다음글이 있는 경우
				map.put("NEXT", new BbsDTO(rs.getString(1), null, rs.getString(2), null,null,null));
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		return map;
	}////////prevNext
	
	
}
