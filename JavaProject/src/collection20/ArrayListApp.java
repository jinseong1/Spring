package collection20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;

public class ArrayListApp {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		System.out.println(list.add("가산")?"저장성공":"저장실패"); //인덱스 0번방 저장
		list.add("나산"); //인덱스 1번방 저장 
		list.add("다산"); //인덱스 2번방 저장
		list.add(3,"라산"); //인덱스 방 지정 후(3번 방) 저장
//		list.add(5,".마산"); [X] 인덱스 방이 순서대로 생기는데 5번방은 없으므로 Runtime error
		list.add(list.size(),"마산"); // 인덱스 넘버를 모르거나 평상시에 추가할때 이렇게 사용하는 것이 좋다
		list.add(list.size(),"바산");
		System.out.println("[중복저장 전 객체 수] "+list.size());
		System.out.println(list.add("다산")?"중복 저장됨":"중복저장 안됨"); // 중복저장
		System.out.println("[중복저장 후 객체 수] "+list.size());
		
//		출력
		System.out.println("[일반 for문 사용]");
		for(int i=0;i<list.size();i++) {
			Object obj=list.get(i);
			System.out.println(obj);
		}
		System.out.println("[확장 for문 사용]");
		for(Object obj :list) {
			System.out.println(obj);
		System.out.println("[반복기 사용]");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			}
		}
		
//		set(int index, Object o)  는 대체되고 기존 객체는 삭제된다
		list.set(4, "마산대체");
		System.out.println("[set으로 저장 후]");
		for(Object obj :list) {
			System.out.println(obj);
		}
		list.add(4, "마산추가");
		System.out.println("[add로 추가 저장 후]");
		for(Object obj :list) {
			System.out.println(obj);
		}
//		검색
		System.out.println(list.contains("다산")?"다산 있음":"다산 없음");
		System.out.println(list.contains("아산")?"아산 있음":"아산 없음");
		System.out.println(list.size());
//		인덱스 삭제
		Object object=list.remove(2);
		System.out.println("삭제된 객체 : "+object);
//		특정 위치 인덱스 찾기
		int index = list.indexOf("다산");
		System.out.println("index : "+index);
		
		System.out.println("삭제된 객체 : "+list.remove(index));
		System.out.println("[모든 다산 삭제 후]");
		for(Object obj :list) {
			System.out.println(obj);
		}
//		주소 삭제
		System.out.println(list.remove("마산추가")?"삭제성공":"삭제실패");
		System.out.println(list.remove("마산대체"));
		System.out.println("[마산계열 삭제 후]");
		for(Object obj :list) {
			System.out.println(obj);
		}
//		전체삭제
//		list.removeAll(list); [O]
		list.clear();
		
		System.out.println("전체삭제 후 객체 수 : "+list.size());
//		제너릭 지정 <>
		ArrayList<Student> list2 = new ArrayList<Student>();
		Student stu1 = new Student("가길동", 20, "2018학번");
		Student stu2 = new Student("나길동", 30, "2017학번");
		Student stu3 = new Student("다길동", 40, "2016학번");
		Student stu4 = new Student("라길동", 40, "2016학번");
		
//		객체저장
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		list2.add(stu4);
//		중복 저장
		list2.add(stu2);
		System.out.println("[중복 저장 후]");
		for(Student student : list2) {
			student.print();
		}
//		인스턴스로 중복 저장된 객체 삭제-순서가 빠른 것이 삭제 된다
		list2.remove(stu2);
		System.out.println("[중복저장된 객체 삭제 후]");
		for(Student student : list2) {
			student.print();
		}
//		출력
		System.out.println("[반복기 사용]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			it2.next().print();
		}
//		일반 for문 사용
		System.out.println("[for문 사용]");
		for(int i=0;i<list2.size();i++) {
			list2.get(i).print();
		}
//		확장 for문 사용
		System.out.println("[확장 for문 사용]");
		for(Student student:list2) {
			student.print();
		}
//		삭제
		System.out.println("[삭제된 객체의 이름] "+list2.remove(2).name);
		list2.remove(stu1); // 주소로 삭제
		System.out.println("[객체 삭제 후]");
		for(Student student:list2) {
			student.print();
		}
		
		/* 사용자로부터 이름을 입력받아 그 이름으로 검색해서
		 * 인덱스 위치를 알아내서 해당 인덱스로 그 객체를 삭제하고 삭제된 객체의 정보를 출력하여라
		 */
		
		
//		객체저장

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
			for(Student st:list2) {
				if(name.equals(st.name)) {
					index = list2.indexOf(st);
					System.out.println("[삭제된 사람 이름]");
					list2.remove(index).print();
					}//if
				}//for
		
			
		
		
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
