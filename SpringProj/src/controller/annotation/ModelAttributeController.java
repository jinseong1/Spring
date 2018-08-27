package controller.annotation;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeController {
	/*방법1]
	@RequestParam Map사용:이때는 커맨드 객체(DTO계열 클래스) 생성 불필요
        단,체크박스 처럼 하나의 파라미터명(키값이 됨)
        으로 여러값이 넘어올때는
  	Map으로 받기때문에 하나만 받을 수 있다.*/
	/*
	@RequestMapping("/Annotation/ModelAttribute.do")
	public String map(@RequestParam Map map,@RequestParam String[] inters,Model model) throws Exception{
		//데이타 저장]
		StringBuffer buffer = new StringBuffer();
		for(String inter:inters) buffer.append(inter+" ");
		//다시 map에 inters키값으로 재설정
		map.put("inters", buffer);
		model.addAllAttributes(map);
		//뷰정보 반환]
		return "/Annotation07/ModelAttribute.jsp";
	}/////////////////////////
	*/
	 /*
  	 방법2]@ModelAttribute 사용
	 * 파라미터가 많은 경우 서블릿 API(HttpServletRequest)보다는
	 * @ModelAttribute어노테이션을 사용하는게 유리
	 * -단, 커맨드 객체(DTO계열)의 속성명과 파라미터명을 일치시켜야 한다.
	 * @ModelAttribute는 생략가능
	 * 예]
	 * @ModelAttribute 커맨드객체타입 매개변수명
	 */
	
	//컨트롤러 메소드]
	@RequestMapping("/Annotation/ModelAttribute.do")
	public String map(Command command,Map map) throws Exception{
		//데이타 저장]
		map.put("command", command);
		//뷰정보 반환]
		return "/Annotation07/ModelAttribute.jsp";
	}///////////////////////////////
}
