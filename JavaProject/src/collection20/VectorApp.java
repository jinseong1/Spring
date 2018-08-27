package collection20;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import console.academy.Student;



public class VectorApp {

	public static void main(String[] args) {
		List<Student> vec = new Vector<Student>();

		Student stu1 = new Student("가길동", 40, "2018학번");
		Student stu2 = new Student("나길동", 35, "2017학번");
		Student stu3 = new Student("다길동", 55, "2016학번");
		Student stu4 = new Student("라길동", 25, "2016학번");
		
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
//		꺼내오기
		System.out.println("[반복기 사용]");
		Iterator<Student> it = vec.iterator();
		while(it.hasNext())it.next().print();
		
		System.out.println("[일반for문 사용]");
		for(int i=0;i<vec.size();i++) vec.get(i).print();
		System.out.println("[확장for문 사용]");
		for(Student student:vec)student.print();
		System.out.println("[열거형 사용]");
		Enumeration<Student> em = ((Vector)vec).elements();
		while(em.hasMoreElements())
			em.nextElement().print();
		
		/*
//		인덱스로 삭제
		System.out.println("삭제된 사람 이름 : "+vec.remove(1).name);
//		주소로 삭제
		System.out.println(vec.remove(stu2)?"삭제 성공":"삭제 실패");
//		삭제 후 출력
		for(Student student:vec)student.print();
//		List 계열의 컬렉션에 있는 메소드
		System.out.println(vec.indexOf(stu2)); // out put : -1
		System.out.println(vec.indexOf(stu4)); // out put :  2
		*/
		
		/*
		vec컬력션에 저장된 Student객체들을
		나이가 높은 순으로 재 배치후
		출력하여라
		단 List계열의 get(index) 및 set(인텍스, 객체) 사용
		*/
		
		System.out.println("[재배치 후 출력]");
		
		
		for(int i=0;i<vec.size()-1;i++) {
			for(int k=i+1 ; k<vec.size() ; k++) {
				if(vec.get(i).age < vec.get(k).age) {
					Student temp = vec.get(k);
					vec.set(k, vec.get(i));
					vec.set(i, temp);
				}//if
			}//in for
		}//out for
		for(Student student:vec)student.print();
		
		

	}//main
}//class
