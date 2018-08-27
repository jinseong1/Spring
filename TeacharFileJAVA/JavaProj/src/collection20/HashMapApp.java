package collection20;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import console.academy.Student;

/*
HashMap: Map(인터페이스)계열의 컬렉션 클래스
- key 와 value의 쌍으로 객체 저장
- 키값은 중복되면 안된다.
- 키값으로 검색하기때문에 다른 컬렉션보다 
  검색속도가 빠르다

데이타 꺼내올때: 

keySet():Set<?>타입 반환
get(키값):키값에 해당하는 value값 반환
keys()  :Enumeration<?>타입 반환(Hashtable의 메소드)
values():Collection<?>타입 반환,value값만 반환

*/
public class HashMapApp {

	public static void main(String[] args) {
		/* Key타입은 String ,Value타입은 String */
		//1]컬렉션 객체 생성
		HashMap<String,String> map = new HashMap<String,String>();
		//2]객체 저장:String put(키값,Value값);
		//반환값(Value값 타입):키값으로 저장시 이전에 저장된 value값
		//       이전에 저장된 value값이 없을시 null
		System.out.println("name이라는 키값으로 이전에 저장된 객체:"+map.put("name", "홍길동"));
		int age=20;
		//map.put("age", age);//[x]value타입이 맞지않아서
		map.put("age",String.valueOf(age));//[o]
		map.put("gender","남자");
		map.put("address",new String("가산동"));
		//3]저장된 객체 수:int size()
		System.out.println("저장된 객체 수:"+ map.size());
		//4]키값을 중복해서 저장: 
		//  저장은 되나 기존 키값에 해당 하는 밸류값이 
		//  새로운 값으로 교체됨.
		System.out.println("name이라는 키값으로 이전에 저장된 객체:"+map.put("name", "덮어쓰기"));
		System.out.println("키값 중복 저장후 객체 수:"+ map.size());
		//5]출력
		//5-1]키값을 알때:String get(키값)
		System.out.println("키값을 알때:"+map.get("name"));
		//5-2]키값을 모를때
		//STEP1]Set<?> keySet()메소드 호출:키값들을 Set계열의 컬렉션 형태로 반환
		//STEP2]STEP1에서 얻은 Set계열 컬렉션에 확장 for문 적용해서
		//      키값 얻기
		//STEP3]get(키값)으로 Value값 얻는다.
		
		//※Map계열 컬렉션에는 처음부터 확장for문 사용불가.
		//  먼저 키값들을 얻어와서(keySet()메소드로) 확장 for문 적용
		//for(Object key: map) {}
		//STEP1]키값들이 저장된 Set컬렉션 얻기
		Set<String> keys=map.keySet();
		//STEP2]확장 FOR문 적용해서 키값 가져오기
		System.out.println("[확장 for문 사용]");
		for(String key:keys) {
			//STEP3] get(키값)으로 Value값 얻기
			String value = map.get(key);
			System.out.println(String.format("%s:%s",key,value ));
		}
		System.out.println("[반복기 사용]");
		Iterator<String> it=keys.iterator();
		while(it.hasNext()) {
			//키값 얻기
			String key=it.next();
			//밸류값 얻기
			String value = map.get(key);
			System.out.println(String.format("%s:%s",key,value ));
		}
		//5-3]Value만 얻어 올때:values()
		Collection<String> values=map.values();
		System.out.println("[values값들만 가져오기]");
		for(String value:values) System.out.println(value);
		//6]검색:boolean containsKey(key)-해당 키가 존재하면 true,
	   //                               아니면 false
		System.out.println(map.containsKey("name") ?"name키값 있다":"name키값 없다");
		System.out.println(map.containsKey("tall") ?"tall키값 있다":"tall키값 없다");
		//boolean containsValue(value)-값이 존재하면 true,아니면 false
		System.out.println(map.containsValue("남자")?"남자값 있다":"남자값 없다");
		System.out.println(map.containsValue("여자")?"여자값 있다":"여자값 없다");
		//7]삭제:String remove(키값)-삭제된 키값에 해당하는 
		//                           value 반환
		System.out.println("삭제 된 객체:"+map.remove("gender"));
		System.out.println("[삭제후 출력]");
		for(String key:keys) {			
			String value = map.get(key);
			System.out.println(String.format("%s:%s",key,value ));
		}
		//전체 삭제:removeAll()는 없음.clear()로 삭제
		map.clear();
		System.out.println("전체 삭제후 객체 수:"+map.size());
		/*
		  Hashtable클래스에서는 
		  keySet()/values()/get("키값")으로 모두 
		  꺼내올 수 있다.
		  또한 keys()메소드를 통해서도 가능
		  HashMap클래스에는 keys()메소드가 없음
		 */
		Map table = new Hashtable();
		//객체 저장]
		table.put("센터", "한국 소프트웨어 인재개발원");
		table.put("위치", "가산동");
		table.put("과정", "자바");
		System.out.println("[keys() 사용]");
		Enumeration em= ((Hashtable)table).keys();
		while(em.hasMoreElements()) {
			//키값 얻기
			Object key=em.nextElement();
			//밸류값 얻기
			Object value=table.get(key);
			System.out.println(String.format("%s:%s", key,value));
		}
		System.out.println("[keySet()메소드 사용]");
		Set set=table.keySet();
		for(Object key:set) {
			Object value=table.get(key);
			System.out.println(String.format("%s:%s", key,value));
		}
		
		Map maps = new HashMap();
		//저장할 객체 생성]
		Student stu1=new Student("가길동", 50, "2010");
		Student stu2=new Student("나길동", 20, "2017");
		Student stu3=new Student("다길동", 40, "2013");
		Student stu4=new Student("라길동", 30, "2015");
		//객체 저장]
		maps.put("학생1", stu1);
		maps.put("학생2", stu2);
		maps.put("학생3", stu3);
		maps.put("학생4", stu4);
		System.out.println("[키값을 알때]");
		Object object=maps.get("학생1");
		if(object instanceof Student) {
			((Student) object).print();
		}
		System.out.println("[키값을 모를때]");
		set=maps.keySet();
		for(Object key:set) {
			Student value=(Student)maps.get(key);
			System.out.println(String.format("%s:%s", key,value.get()));
		}
	}///////////////main
}//////////////////class
