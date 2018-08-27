package com.kosmo.replybbs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.kosmo.replybbs.service.ReplyBBSDto;
import com.kosmo.replybbs.service.ReplyBBService;

@Repository
public class ReplyBBSDao implements ReplyBBService {

	//--------------------------------------------
	// JAVA JDBC API사용
	// --------------------------------------------	
	/*
	※@Resource어노테이션을 통해 주입받는 과정보다 생성자가 먼저다.
	Connection객체를 생성자안에서 초기화시
	NullPointerException발생
	예]conn=dataSource.getConnection()
	  dataSource는 null이다
	 */
	
	@Resource(name="dataSourceByJNDI")
	private DataSource source;
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public boolean login(Map map) {
		try {
			conn=source.getConnection();
			String sql="SELECT COUNT(*) FROM member WHERE id=? AND pwd=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, map.get("id").toString());
			psmt.setString(2, map.get("pwd").toString());
			rs= psmt.executeQuery();
			rs.next();
			
			if(rs.getInt(1)==0) return false;
			
		} 
		catch (SQLException e) {e.printStackTrace();return false;}
		finally {close();}	
		
		return true;
	}//////////////////////////login
	@Override
	public List<ReplyBBSDto> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ReplyBBSDto selectOne(Map map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(ReplyBBSDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(ReplyBBSDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ReplyBBSDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTotalRecord(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void reply(Map map) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn !=null) conn.close();
		}
		catch(Exception e) {e.printStackTrace();}		
	}////////////////////close()
	
	
	
	
	
	
}
