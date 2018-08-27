package collection20;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import console.academy.Student;

public class HashMapApp {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
//		객체 저장은 map.put(String,String)으로 사용한다
		System.out.println("name이라는 키값으로 이전에 저장된 객체"+map.put("name", "홍길동")); // name에 홍길동을 넣었으나 아직 null값을 반환
		int age=20;
//		map.put("age", age);  [X] age는 Integer타입으로 String Type이 아니여서 되지않는다
		map.put("age",String.valueOf(age)); //[O]
		map.put("gender", "남자");
		map.put("address", "가산동");
//		저장된 객체 수 
		System.out.println("저장된 객체 : "+map.size());
//		중복 저장시 덮어쓰기가 됨
		System.out.println("name이라는 키값으로 이전에 저장된 객체"+map.put("name", "덮어쓰기"));
		System.out.println("키값 중복 저장 후 저장된 객체 : "+map.size());		
//		꺼내오기
		System.out.println("키값을 알때 : "+map.get("name"));
		Set<String> keys= map.keySet(); // 키값이 저장된 컬렉션을 반환해줌
		System.out.println("[확장for문 사용]");
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(String.format("키:%8s , 벨류:%8s", key, value));
		}//for
//		for(Object str : map) {} [X]   map 계열에는 확장 포문을 사용할 수 없음
		System.out.println("[반복기 사용]");
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key=it.next();
			String value=map.get(key);
			System.out.printf(key,value);
		}

		Collection<String> values = map.values();
		System.out.println("[value값들만 가져오기]");
		for(String value:values) {
			System.out.println(value);
		}
		System.out.println(map.containsKey("name")?"name키값 있다":"name키값 없다");
		System.out.println(map.containsKey("tall")?"tall키값 있다":"tall키값 없다");
		System.out.println(map.containsValue("남자")?"남자가 있다":"남자가 없다");
		System.out.println(map.containsValue("여자")?"여자가 있다":"여자가 없다");
//		삭제   삭제된 키값의 벨류값을 반환해준다
		System.out.println("삭제된 객체:"+map.remove("gender"));
//		삭제 출력
		System.out.println("[삭제 후 출력]");
		
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(String.format("키:%8s , 벨류:%8s", key, value));}
//		전체삭제
		map.clear();
		System.out.println("전체 삭제 후 객체 수"+map.size());
		
		Map table = new Hashtable();
		table.put("센터", "한국소프트웨어");
		table.put("위치", "가산동");
		table.put("과정", "자바");

		System.out.println("[keys사용]");
		
		@SuppressWarnings("rawtypes")
		Enumeration em =((Hashtable)table).keys();
		while(em.hasMoreElements()) {
//			키값얻기
			Object key = em.nextElement();
//			벨류값
			Object value = table.get(key);
			System.out.println(String.format("%s:%s", key,value));
		}
		System.out.println("[keySet()메소드 사용]");
		Set set = table.keySet();
		for(Object key:set) {
			Object value = table.get(key);
			System.out.println(String.format("%s:%s", key,value));
		}
		
		Map maps = new HashMap();
		Student stu1 = new Student("가길동", 50, "2010");
		Student stu2 = new Student("나길동", 20, "2010");
		Student stu3 = new Student("다길동", 40, "2010");
		Student stu4 = new Student("라길동", 30, "2010");
		
		maps.put("학생1", stu1);
		maps.put("학생2", stu2);
		maps.put("학생3", stu3);
		maps.put("학생4", stu4);
		
		System.out.println("[키값을 알때]");
		Object object = maps.get("학생1");
		if(object instanceof Student) {
			((Student) object).print();
		}
		System.out.println("[키값을 모를때]");
		set=maps.keySet();
		for(Object key:set) {
			Object value = maps.get(key);
			System.out.println(String.format("%s:%s", key,((Student)value).get()));
		}
		
		
	}//main
}//class
