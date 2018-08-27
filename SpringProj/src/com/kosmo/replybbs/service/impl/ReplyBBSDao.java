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
import com.kosmo.replybbs.service.ReplyBBSService;


@Repository
public class ReplyBBSDao implements ReplyBBSService {
	
	//JAVA JDBC API사용
	@Resource(name="dataSourceByJDBC")
	private DataSource source;
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public boolean login(Map map) {
		try {
			conn = source.getConnection();
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID=? AND PWD=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, map.get("id").toString());
			psmt.setString(2, map.get("pwd").toString());
			rs=psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0)return false;
			
		} catch (SQLException e) {e.printStackTrace();return false;}
		return true;
	}
	@Override
	public List<ReplyBBSDto> selectList(Map map) {
		
		return null;
	}
	@Override
	public ReplyBBSDto selectOne(Map map) {
		
		return null;
	}
	@Override
	public int insert(ReplyBBSDto dto) {
		
		return 0;
	}
	@Override
	public int delete(ReplyBBSDto dto) {
		
		return 0;
	}
	@Override
	public int update(ReplyBBSDto dto) {
		
		return 0;
	}
	@Override
	public int getTotalRecord(Map map) {
		
		return 0;
	}
	@Override
	public void reply(Map map) {
		
		
	}
	@Override
	public void close() {
		try {
		if(conn!=null) conn.close();
		if(rs!=null)rs.close();
		if(psmt!=null)psmt.close();
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
	
	
	
	
	
	
	
}
