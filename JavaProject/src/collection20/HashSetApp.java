package collection20;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import console.academy.Student;

public class HashSetApp {

	public static void main(String[] args) {
//		<>제너릭 표현에 타입을 지정하지 않은 경우 어느 타입이든 저장 가능
//		1-1 컬렉션 생성
		HashSet set = new HashSet();
//		1-2 객체 생성
		String stringObject1 = "JAVA";
		String stringObject2= new String(" WORlD");
		Date dateObject = new Date(new java.util.Date().getTime());
		int integerObject = 100;
		Student studentObject = new Student("김길동", 20, "2018");
//		1-3 add 메소드로 저장
		System.out.println(set.add(stringObject1)?"저장성공":"저장실패");
		set.add(stringObject2);
		set.add(dateObject);
		set.add(integerObject);
		set.add(studentObject);
//		1-4 컬렉션에 저장된 객체 수 얻기
		System.out.println("[중복 저장 전]저장된 객체 수 : "+set.size());
//		1-5 중복저장[x] error는 나지 않지만 저장이 안됨(즉 add메소드가 false로 변환)
		System.out.println(set.add(stringObject1)?"저장성공":"저장실패");
		System.out.println("[중복 저장 후]저장된 객체 수 : "+set.size());		
//		1-6 저장된 객체 꺼내오기
		System.out.println("[반복기 사용]");
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(obj instanceof String) 
				System.out.println(obj);
			else if (obj instanceof Date)
				System.out.println("java.sql.Date타입 :"+obj);
			else if (obj instanceof Integer)
				System.out.println("Student타입 :"+obj);
			else if(obj instanceof Student)
				System.out.println("Student타입 :"+((Student)obj).get());
		}//while
//		it.next(); 더이상 꺼내올 내용이 없어 Run error 발생
		
//		확장 for문
		System.out.println("[확장 for문]");
		for(Object obj:set) {
			if(obj instanceof String) 
				System.out.println(obj);
			else if (obj instanceof Date)
				System.out.println("java.sql.Date타입 :"+obj);
			else if (obj instanceof Integer)
				System.out.println("Student타입 :"+obj);
			else if(obj instanceof Student)
				System.out.println("Student타입 :"+((Student)obj).get());
		}
		
		String[] mountains = {"비술산","덕유산","태백산","속리산"};
		System.out.println("[일반 for문 사용]");
		for(int i=0;i<mountains.length;i++) {
			System.out.println(mountains[i]);
		}
		
		System.out.println("[확장 for문 사용]");
		for(String mountain:mountains) {
			System.out.println(mountain);
		}
//		1-7 contains
		System.out.println(set.contains(stringObject1)?"stringObject1있다":"stringObject1없다");
		System.out.println(set.contains(100)?"100있다":"100없다");
		System.out.println(set.contains("WORlD")?"WORlD있다":"WORlD없다");
//		1-8 remove
		System.out.println(set.remove(studentObject)?"삭제성공":"삭제실패");
		System.out.println(set.remove(stringObject2)?"삭제성공":"삭제실패");
		System.out.println("삭제 후 저장된 객체 수 : "+set.size());
//		1-9 Boolean removeAll(Collection c)
//		set.removeAll(set);   //방법 1
		set.clear(); 		  //방법 2
		System.out.println("전체 삭제 후 저장된 객체 수 : "+set.size());
		
//		Student 타입 객체만 저장 가능
		HashSet<Student> set2 = new HashSet<Student>();
		Student stu1 = new Student("가길동", 20, "2018학번");
		Student stu2 = new Student("나길동", 30, "2017학번");
		Student stu3 = new Student("다길동", 40, "2016학번");
//		객체 저장
		set2.add(stu1);
		set2.add(stu2);
		set2.add(stu3);
//		set2.add(stringObject1); [X]   <> 제너릭에 지정한 타입만 저장 가능
//		2-3 객체 꺼내오기
		System.out.println("[반복기 사용]");
		Iterator<Student> it2= set2.iterator();
		while(it2.hasNext()) {
			
/*			
			System.out.println(
					String.format("이름 : %s, 나이 : %d, 학번 : %s",
							it2.next().name,
							it2.next().age,
							it2.next().stNumber
							));*/
			
			Student student = it2.next();
/*			
			System.out.println(
					String.format("이름 : %s, 나이 : %d, 학번 : %s",
							student.name,
							student.age,
							student.stNumber
							));
			*/
			
			student.print();
		}//while
		System.out.println("[확장 for문]");
		for(Student st:set2) {
			st.print();			
		}
		System.out.println(set2.contains(stu1)?"가길동 있다":"가길동 없다");
		System.out.println(set2.contains(new Student("라길동",50,"2000학번")));
//		삭제
		System.out.println(set2.remove(stu1)?"가길동 삭제 성공":"가길동 삭제 실패");
		System.out.println("삭제 후 저장된 객체 수 : "+set2.size());
//		set2.clear();
		System.out.println("전체 삭제 후 저장된 객체 수 : "+set2.size());
		
		/*문제 컬렉션 set2에 저장된 객체를 이름으로 검색하자 있는 이름으로 검색해보고
		 * 없는 이름으로 검색해보자 있으면 해당 학생의 정보를 출력하고 없으면 "해당 학생이 없어요"라는 메세지 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		
/*		while(true) {
		System.out.println("검색한 이름을 입력하세요");
		String searchName = sc.nextLine();
			boolean isExit = false;
			outer : for(Student st:set2) {
				if(searchName.equals(st.name)) {
					st.print();
					isExit=true;
					break outer;					
					}
				}
			if(!isExit)System.out.println(searchName+"검색한 이름이 없습니다");
			}
			*/
			
		
		while(true) {
		System.out.println("검색한 이름을 입력하세요");
		String searchName = sc.nextLine();
			boolean isExit = false;
			for(Student st:set2) {
				if(searchName.equals(st.name)) {
					st.print();
					isExit=true;
					break ;					
					}
				}
			if(isExit) break;
			else System.out.println(searchName+"검색한 이름이 없습니다");
			}//while
		
		
		
		
		
		
	}//main
}/////class

