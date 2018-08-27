package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {
	/*현재 클래스가 Person객체 필요]
	-new하지않고 세터를 통해서 주입 받자
	 STEP1]멤버변수(속성) 선언*/
	private Person person1,person2;
	//STEP2]세터 정의
	public void setPerson1(Person person1) {
		this.person1 = person1;
	}
	public void setPerson2(Person person2) {
		this.person2 = person2;
	}
	//컨트롤러 메소드]
	@RequestMapping("/Injection/Setter.do")	
	public String execute(Map map) throws Exception{
		//데이타 저장
		map.put("personInfo", person1.toString()+person2);
		//뷰정보 반환
		return "forward:/Injection06/Injection.jsp";
	}////////////////////
	
}
