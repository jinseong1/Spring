package com.kosmo.replybbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosmo.replybbs.service.ReplyBBSDto;
import com.kosmo.replybbs.service.ReplyBBService;

/*
 * 이름 미 지정시 ID값은 소문자로 시작하는 클래스명이됨
 * 예]ReplyBBServiceImpl클래인 경우 
 * ID값은 replyBBServiceImpl
 * 지정도 가능 @Service("임의의ID값")
 */
@Service("bbsService")
public class ReplyBBServiceImpl implements ReplyBBService{

	//DAO계열 클래스 주입받기]
	@Resource(name="replyBBSDao")
	private ReplyBBSDao dao;
	
	@Override
	public boolean login(Map map) {			
		return dao.login(map);
	}/////////////////

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
		
		
	}

}
