package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스]
@Controller
public class OneClassMultiMethodController {
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/List.do")
	public String list(ModelMap map) throws Exception{
		//데이터 저장]
		map.addAttribute("message", "[목록요청입니다]");
		//디스패처 서블릿에게 뷰정보 반환]
		return "/Controller02/Controller.jsp";
	}////////////////////
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/Edit.do")
	public String edit(ModelMap map) throws Exception{
		//데이터 저장]
		map.addAttribute("message", "[수정요청입니다]");
		//디스패처 서블릿에게 뷰정보 반환]
		return "/Controller02/Controller.jsp";
	}////////////////////
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/Delete.do")
	public String delete(ModelMap map) throws Exception{
		//데이터 저장]
		map.addAttribute("message", "[삭제요청입니다]");
		//디스패처 서블릿에게 뷰정보 반환]
		return "/Controller02/Controller.jsp";
	}////////////////////
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/View.do")
	public String view(ModelMap map) throws Exception{
		//데이터 저장]
		map.addAttribute("message", "[상세보기요청입니다]");
		//디스패처 서블릿에게 뷰정보 반환]
		return "/Controller02/Controller.jsp";
	}////////////////////
}
