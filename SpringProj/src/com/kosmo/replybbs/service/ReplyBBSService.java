package com.kosmo.replybbs.service;

import java.util.List;
import java.util.Map;

public interface ReplyBBSService {
	//로그인 처리
	boolean login(Map map);
	//답변형 게시판 관련 크루드 작업용
	//목록
	List<ReplyBBSDto> selectList(Map map);
	//상세보기
	ReplyBBSDto selectOne(Map map);
	//입력수정 삭제
	int insert(ReplyBBSDto dto);
	int delete(ReplyBBSDto dto);
	int update(ReplyBBSDto dto);
	//전체 레코드 수
	int getTotalRecord(Map map);
	//답변
	void reply(Map map);
	//자원반납및 커넷션 풀 반납용
	void close();
	
	
	
	
}
