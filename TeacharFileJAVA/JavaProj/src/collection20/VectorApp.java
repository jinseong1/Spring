package collection20;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import console.academy.Student;

//List계열 컬렉션
public class VectorApp {

	public static void main(String[] args) {
		//Vector컬렉션-List계열 컬렉션
		//컬렉션 객체 생성]
		List<Student> vec = new Vector<Student>();
		//저장할 객체 생성]
		Student stu1 = new Student("가길동", 40, "2018학번");
		Student stu2 = new Student("나길동", 35, "2017학번");		
		Student stu3 = new Student("다길동", 55, "2016학번");
		Student stu4 = new Student("라길동", 25, "2015학번");
		//객체 저장]
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		//꺼내오기]
		System.out.println("[반복기 사용]");
		Iterator<Student> it= vec.iterator();
		while(it.hasNext()) it.next().print();
		System.out.println("[일반 for문 사용]");
		for(int i=0;i< vec.size();i++) vec.get(i).print();
		System.out.println("[확장 for문 사용]");
		for(Student student:vec) student.print();
		/*
		 * 열거형으로 꺼내오기:elements()메소드로 Enumeration  타입얻기
		 * Enumeration타입의 주요 메소드]
		 * hasMoreElements():저장된 객체가 있으면  true,없으면 false반환
		 * nextElement();저장된 객체 얻을때
		 */
		System.out.println("[열거형 사용]");
		Enumeration<Student> em=((Vector)vec).elements();
		while(em.hasMoreElements()) {
			em.nextElement().print();
		}
		//삭제]
		/*
		//인덱스로 삭제]
		System.out.println("삭제된 객체의 이름:"+vec.remove(1).name);
		//인스턴스(주소)로 삭제]
		System.out.println(vec.remove(stu2)?"삭제 성공":"삭제 실패");
		System.out.println("[삭제 후 출력]");
		for(Student student:vec) student.print();
		//List계열의 컬렉션에 있는 메소드]
		//객체의 인덱스 위치 반환:int indexOf(Object obj)
		//                     해당 객체가 없는 경우 -1반환
		System.out.println(vec.indexOf(stu2));//-1
		System.out.println(vec.indexOf(stu4));//2
		*/
		//문]vec컬렉션에 저장된 Student객체들을
		//   나이가 높은 순으로 재 배치후
		//   출력하여라.
		//단,List계열의 get(인덱스) 및 set(인덱스,객체) 사용
		for(int i=0; i < vec.size()-1;i++)
			for(int k=i+1;k < vec.size();k++)
				if(vec.get(i).age < vec.get(k).age) {
					Student temp = vec.get(k);
					vec.set(k,vec.get(i));
					vec.set(i, temp);					
				}
		
		System.out.println("[재배치후 출력]");
		for(Student student:vec) student.print();
		
	}////////////main

}///////////////class
