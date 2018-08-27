package moteltest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MemberDAO {
	
	List<String[]> list = new ArrayList<String[]>();
	
	public MemberDAO() {
		 list.removeAll(list);
		 System.out.println("모두 초기화 되었습니다");
	}
	
	
	public String[] insert(String[] dtos) {
		System.out.println("저장완료");
		return dtos;
	}
	
	public void totalAge() {
		int total=0;
		for(int i=0;i<list.size();i++) {
			String[] obj=list.get(i);
			total+= Integer.parseInt(obj[2]);
		}
		System.out.println("나이의 합은 : "+total+" 살입니다");
	}
	
	public void prints() {
		Iterator<String[]> it2 = list.iterator();
		while(it2.hasNext()) {
			String[] dto= it2.next();
			 System.out.println(String.format("%s", dto.toString()));
		}//while
	}
	
	public void removeAlls() {
		list.removeAll(list);
		System.out.println("모두 삭제 완료");
	}

}
