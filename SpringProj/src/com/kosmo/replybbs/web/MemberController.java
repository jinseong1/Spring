package com.kosmo.replybbs.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo.replybbs.service.ReplyBBSService;

//이름 미 지정시 ID값은 소문자로 시작하는 클래스 명이 됨
@SessionAttributes("id")
@Controller
public class MemberController {
	//서비스 주입
	@Resource(name="bbsService")
	private ReplyBBSService service;
	
	@RequestMapping("/replyBbs/Member/Login.bbs")
	public String login()throws Exception{
		
		return "/login/Login";
	}
	
	@RequestMapping("/replyBbs/Member/Logout.bbs")
	public String process(@RequestParam Map map, Model model)throws Exception{
		//서비스 호출
		boolean isLogin = service.login(map);
		if(isLogin) {//회원인 경우
			model.addAllAttributes(map);
		}
		else {//비회원
			model.addAttribute("loginError", "회원가입 후 이용바람....");
			//뷰 정보 반환
			//return "/login/Login";
			return "/forward:/ReplyBbs/Member/login.bbs";
		}
		
		//목록으로 이동
		return "forward:/ReplyBbs/BBS/List.bbs";//테스트용 목록 만든 후 주석처리
		
	}
	
	
	
}
