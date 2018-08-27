package controller.annotation;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	
	 /*[ 파라미터 받기 ]*/	
	 /*
	  *  파라미터를 받기 위해 HttpServletRequest 사용 안하고
	  *  @RequestParam어노테이션 사용
	  * 
	  * -파라미터의 자료형으로 받을 수 있다(형변환 불필요)
	  * -단,파라미터가 여러개일때는 
	  *  @ModelAttribute어노테이션이나 @RequestParam Map map이 유리
	  *  단,Map으로 받을때 체크박스류는 여러개 값중 하나만
	  *  
	  * -파라미터가 1~2개일때 유리하다
	  * -사용자가 전달한 파라미터 값이 매개변수에 저장됨
	  *  즉 매개변수명=리퀘스트객체.getParameter("파라미터명")와 같다
	  *  
	  * -required속성은 디폴트가 true이다 
	  *  만약 파라미터명이 매개변수 명과 다르다면
	  *  
	  *  방법1]
	  *  @RequestParam("파라미터명") 자료형 매개변수명 -
	  *  required가 true
	  *  해당 파라미터명으로 전달이 안되면 에러(400에러)
	  *  
	  *  방법2]
	  *   @RequestParam(value="파라미터명",required=false) 자료형 매개변수명 
	  *   해당 파라미터명으로 전달이 안되도 필수가 아니기때문에
	  *   에러안남  *  
	  *  
	  */ 
	@RequestMapping("/Annotation/RequestParamEqual.do")
	//public String equals(HttpServletRequest req,Model model) throws Exception{
	public String equals(@RequestParam String name,@RequestParam int years,Model model) throws Exception{
		/*
		//파라미터 받기]-HttpServletRequest사용시
		String name=req.getParameter("name");
		int years=Integer.parseInt(req.getParameter("years"));
		*/
		//@RequestParam으로 받을때는 위 두 줄 불필요 및
		//형변환도 불필요.	
		//데이타 저장]
		model.addAttribute("name",name);
		model.addAttribute("years",years+10);
		//뷰정보 반환]
		return "/Annotation07/Annotation.jsp";
	}////////////////////////////
	//컨트롤러 메소드]-파라미터명과 매개변수명이 불일치시
	@RequestMapping("/Annotation/RequestParamDiff.do")
	public String diff(@RequestParam(value="nick", required=false,defaultValue="한소인") String name,@RequestParam("age") Integer years,Model model) throws Exception{
		
		//데이타 저장]
		model.addAttribute("name",name);
		model.addAttribute("years",years+10);
		//뷰정보 반환]
		return "/Annotation07/Annotation.jsp";
	}//////////////////////
	//컨트롤러 메소드]-Map으로 파라미터 받기.
	//단,체크박스는 여러개 선택해도 하나만 받는다.
	@RequestMapping("/Annotation/RequestParamMap.do")
	public String map(@RequestParam String[] inters,@RequestParam Map map,ModelMap model) throws Exception{
		//기존 맵에 inters라는 키값으로 저장된 객체를 @RequestParam String[] inters값으로 변경
		map.put("inters",Arrays.toString(inters));
		model.addAllAttributes(map);
		//뷰정보 반환]
		return "/Annotation07/Annotation.jsp";
	}////////////////////////////////
	
	
}
