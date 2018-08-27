package controller.validation;

import java.util.StringTokenizer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> command) {
		//return FormCommand.class.isAssignableFrom(command);
		return FormCommand.class.equals(command);
	}

	@Override//                에러객체                     
	public void validate(Object cmd, Errors error) {
		FormCommand command = (FormCommand)cmd;
		if(command.getName().trim().equals("")) {
			error.rejectValue("name", "nameError");
		}
		if(command.getYears().trim().equals("")) {
			error.rejectValue("years", "yearsError");
		}
		else {
			try {
				Integer.parseInt(command.getYears());
			}
			catch (Exception e) {
				error.rejectValue("years", "yearsNotNumber");
			}
		}
		if(command.getGender()==null) {
			error.rejectValue("gender", "genderError");
		}		
		//.jsp에서 체크한 관심사항 유지용
		
		
		if(command.getInters()==null) {
			error.rejectValue("inters", "intersError");
		}
		else {
			StringTokenizer tokenizer = new StringTokenizer(command.getInters(), ",");
			if(tokenizer.countTokens() < 2) {
				error.rejectValue("inters", "intersLackError");
			}

		}
		if(command.getGrade().equals("")) {
			error.rejectValue("grade", "gradeError");
		}			
		if(command.getSelf().trim().equals("")) {
			error.rejectValue("self", "selfError");
		}
		else {
			command.setSelf(command.getSelf().toString().replace("\r\n", "<br/>"));
		}		
		
		
	}
	
}
