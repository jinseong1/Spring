package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//컨트롤러 클래스]
@Controller
public class ConstructorController {
	/*[현재 클래스에서 Person객체에 의존 즉 필요로 함]
	※new연산자로 Person객체를 직접 생성하지 않고
	  설정파일을 통해서 생성자로 주입을 받는다.
	생성자 인젝션을 받기위한 단계]
	STEP1]주입받는 타입의 갯수에 맞게 맴버변수 선언*/
	private Person person1,person2,person3;
	//STEP2]인자 생성자 정의
	public ConstructorController(Person person1,Person person2,Person person3) {
		this.person1=person1;
		this.person2=person2;
		this.person3=person3;
	}
	@RequestMapping("/Injection/Constructor.do")
	//컨트롤러 메소드]
	public String execute(Map map) throws Exception{
		//데이타 저장
		map.put("personInfo", person1.toString()+person2+person3);
		//뷰정보 반환
		return "forward:/Injection06/Injection.jsp";
	}////////////////////
}
