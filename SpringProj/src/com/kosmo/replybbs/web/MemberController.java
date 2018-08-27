package com.kosmo.replybbs.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kosmo.replybbs.service.ReplyBBService;

/*
 * .jsp로 이동:.tiles로
 * .bbs는 :forward:사용, tiles미적용
 *  타일이 필요없는 .jsp(Message.jsp)는 
 *  prefix/suffix그대로 적용(InternalResourceViewResolver)
 */

@SessionAttributes("id")
@Controller
public class MemberController {
	//서비스 주입]
	@Resource(name="bbsService")
	private ReplyBBService service ;
	
	//로그인 폼으로 이동]
	@RequestMapping("/ReplyBBS/Member/login.bbs")
	public String login() throws Exception{
		
		return "/login/Login";
	}///////////////login()
	//로그인 처리]
	@RequestMapping("/ReplyBBS/Member/loginProcess.bbs")
	public String process(@RequestParam Map map,Model model) throws Exception{
		//서비스 호출]
		boolean isLogin=service.login(map);
		if(isLogin) {//회원인 경우
			//로그인 처리-세션영역에도(리퀘스트 영역과 함께) 저장
			model.addAllAttributes(map);
		}
		else {//비회원
			model.addAttribute("loginError", "회원가입후 이용바람...");
			//뷰(JSP)정보 반환]- 다시 로그인으로 이동
			//return "/login/Login";//혹은
			return "forward:/ReplyBBS/Member/login.bbs";
		}
		//뷰(JSP)정보 반환]-목록으로 이동
		//return "forward:/ReplyBBS/BBS/List.bbs";
		return "forward:/ReplyBBS/Member/login.bbs";//테스트용.목록 만든후 주석처리
	}//////////////////////
	//로그아웃 처리]
	@RequestMapping("/ReplyBBS/Member/logout.bbs")
	public String logout(SessionStatus status) throws Exception{
		//로그 아웃처리-세션영역에 속성 삭제]
		status.setComplete();
		//뷰(JSP)정보 반환]- 메인으로 이동
		return "forward:/";		
	}///////////////logout()
	
	
}
