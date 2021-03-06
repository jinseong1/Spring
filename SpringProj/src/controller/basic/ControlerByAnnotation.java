package controller.basic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*[일반 자바클래스 형태 즉 POJO(Plain Old Java Object)]

컴파일러에게 "아래 클래스는 사용자 요청을 처리하는 클래스야" 라고
려주는 역할]-컨트롤러 클래스
*/
//컨트롤러 클래스]
@Controller
public class ControlerByAnnotation {

	//컨트롤러 케소드]
	//어노테이션으로 사용자 요청 매핑	
	@RequestMapping("/Basic/Annotation.do")
	public String execute(HttpServletRequest req) throws Exception {
		//1]요청분석-파라미터 받기
		String message=req.getParameter("message");
		//2]모델(로직) 호출 및 결과값 받기
		//3]결과값 리퀘스트 영역에 저장
		req.setAttribute("message", message);
		//4]뷰정보를 문자열로 디스패처 서블릿에게 반환
		return "/Index.jsp";
	}
}
