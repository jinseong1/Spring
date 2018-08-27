package controller.annotation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {
	/*
	//방법1]반환타입은 void,매개변수는 서블릿 API사용
	@RequestMapping("/Annotation/ResponseBody.do")
	public void execute(HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println("<h2>반환타입:void,서블릿  API사용:HttpServletResponse></h2>");
		out.close();
	}////////////////*/
	//방법2]반환타입 String ,서블릿 API 미사용 및 @ResponseBody어노테이션 사용
	/*
	중요: @ResponseBody어노테이션 사용시  String타입으로 반환 
	             한글 처리는 빈 설정파일에서 처리
	  * -컨틀로러 메소드 앞에 붙인다.
	  * -반환타입은 String(웹브라우저에 출력할 문자열 반환)
	*/
	@RequestMapping(value="/Annotation/ResponseBody.do",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String execute() throws Exception{		
		
		return "<h2>반환타입:String,서블릿  API 미사용</h2>";
	}////////////////
	
}
