package controller.validation;

import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {
		
	/*
	//방법 1 스프링 API를 사용하지 않고 유효성 검증하기
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand command, Model model)throws Exception{
		
		if(!validate(command,model)) {//유효성 검증 실패
			return "forward:/Validation10/Validation.jsp";
		}
		
		model.addAttribute("command",command);
		
		return "forward:/Validation10/ValidationComplete.jsp";
	}///////////////////////////////////////
	
	
	private boolean validate(FormCommand command,Model model) {//유효성 검사 메소드
		if(command.getName().trim().equals("")) {
			model.addAttribute("nameError","이름을 입력하여주세요");
			return false;
		}
		if(command.getYears().trim().equals("")) {
			model.addAttribute("yearsError","나이를 입력하여주세요");
			return false;
		}
		else {
			try {
				Integer.parseInt(command.getYears());
			}
			catch (Exception e) {
				model.addAttribute("yearsError","나이는 숫자만 입력하여주세요");
				return false;
			}
		}
		if(command.getGender()==null) {
			model.addAttribute("genderError","성별을 선택하여주세요");
			return false;
		}		
		//.jsp에서 체크한 관심사항 유지용
		model.addAttribute("inters", command.getInters());
		
		
		if(command.getInters()==null) {
			model.addAttribute("intersError","관심사항을 선택하여주세요");
			return false;
		}
		else {
			StringTokenizer tokenizer = new StringTokenizer(command.getInters(), ",");
			if(tokenizer.countTokens() < 2) {
				model.addAttribute("intersError","관심사항은 두개 이상 선택하세요");
				return false;
			}

		}
		if(command.getGrade().equals("")) {
			model.addAttribute("gradeError","학력을 선택하여주세요");
			return false;
		}			
		if(command.getSelf().trim().equals("")) {
			model.addAttribute("selfError","내용을 입력하세요");
			return false;
		}
		else {
			command.setSelf(command.getSelf().toString().replace("\r\n", "<br/>"));
		}
		
		return true;
	}
	*/
	
	//방법 2
	@Resource(name="validator")
	private FormValidator validator;
	
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand command, BindingResult errors, Model model)throws Exception{
		
		validator.validate(command, errors);
		
		return "forward:/Validation10/Validation.jsp";
		
		
	}
	
	
	
	
}
