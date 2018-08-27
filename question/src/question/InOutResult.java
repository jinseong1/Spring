package question;

import moteltest.MemberDAO;
import moteltest.MemberDTO;

public class InOutResult {

	public static void main(String[] args) {
		//MemberDTO dto1 = new MemberDTO("박진성", "010-3097-9501", "25");
		//MemberDTO dto2 = new MemberDTO("김지선", "010-5557-5435", "27");
		//MemberDTO dto3 = new MemberDTO("조현아", "010-7777-7777", "21");
		
		MemberDAO dao = new MemberDAO();
		
		String[] info1 = {"박진성", "010-3097-9501", "25"};
		String[] info2 = {"김지선", "010-5557-5435", "27"};
		String[] info3 = {"조현아", "010-7777-7777", "21"};
		
		
		dao.insert(info1);
		dao.insert(info2);
		dao.insert(info3);
		
		
		
		//dao.insert(dto1);
		//dao.insert(dto2);
		//dao.insert(dto3);
		
		dao.prints();
		
		dao.totalAge();
		
		dao.removeAlls();
		
		dao.prints();
		
		
		
	}

}
