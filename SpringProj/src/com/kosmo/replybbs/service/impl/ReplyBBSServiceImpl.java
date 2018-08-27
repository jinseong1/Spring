package com.kosmo.replybbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kosmo.replybbs.service.ReplyBBSDto;
import com.kosmo.replybbs.service.ReplyBBSService;

@Service("bbsService")
public class ReplyBBSServiceImpl implements ReplyBBSService {
	
	@Resource(name="replyBBSDao")
	private ReplyBBSDao dao;
	
	
	@Override
	public boolean login(Map map) {
		
		return dao.login(map);
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
		
		
	}

}
