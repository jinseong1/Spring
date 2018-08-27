package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

class Address implements Comparable<Address>{
	String name;
	String tel;
	String addr;
	int age;
	public Address(String name, String tel, String addr, int age) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.age = age;
	}
	String getAddress() {
		return String.format("이름 :%s, 나이 :%d, 전화번호 :%s, 주소 :%s", name,age,tel,addr);}
	public void printAddress() {
		System.out.println(getAddress());}
	@Override
	public int compareTo(Address anotherAddress) {
		return this.name.compareTo(anotherAddress.name);
//		내림차순
//		return anotherAddress.name.compareTo(name);
	}

}










public class AddressBookApp {

	public static void main(String[] args) {
//		초성을 Key값으로 Value는 list로 할 수 있음
		Map<Character, List> nameAddr = new HashMap<Character, List>();
//		이름저장용 List 계열 컬렉션 사용
		List kieyeok = new Vector();
		List nieeun = new Vector();
//		이름 저장
		kieyeok.add("고길동");
		kieyeok.add("곽길동");
		kieyeok.add("기길동");
		kieyeok.add("김길동");
		nieeun.add("노길동");
		nieeun.add("나길동");
		nieeun.add("남길동");
//		키값 저장
		nameAddr.put('ㄱ', kieyeok);
		nameAddr.put('ㄴ', nieeun);
		System.out.println("[키값을 알때]");
		List values= nameAddr.get('ㄱ');
		for(Object value :values) {
			System.out.println(value);	
		}
		System.out.println("[키값을 모를때]");
		Set<Character> keys = nameAddr.keySet();
		for(Character key :keys) {
			System.out.println(String.format("%c로 시작하는 명단  :", key));
			values=nameAddr.get(key);
			for(Object value :values) {
				System.out.println(value);	
			}
		}//for
		
//		이름 번호 주소 등 여러가지 저장하는 방법
		Map<Character,List<Map<String,Object>>> address = new HashMap<Character,List<Map<String,Object>>>();
		
		List<Map<String,Object>> kie = new Vector<Map<String,Object>>();
		List<Map<String,Object>> nie = new Vector<Map<String,Object>>();
		Map<String,Object> k=new HashMap<String,Object>();
		
		k.put("name", "고길동");
		k.put("age", 20);
		k.put("tel", "010");
		k.put("addr", "강남");
		
		kie.add(k);	
		
		k.put("name", "김길동");
		k.put("age", 20);
		k.put("tel", "010");
		k.put("addr", "강남");
		
		Map<String,Object> n=new HashMap<String,Object>();
		
		n.put("name", "노길동");
		n.put("age", 35);
		n.put("tel", "010");
		n.put("addr", "사당동");
		
		nie.add(n);

		n.put("name", "노길동");
		n.put("age", 35);
		n.put("tel", "010");
		n.put("addr", "사당동");
		
		nie.add(n);
		
//		주소록 저장하는 맵컬렉션에 리스트 저장
		address.put('ㄱ', kie);
		address.put('ㄴ', nie);
		
//		꺼내오기
		System.out.println("[키값을 알때]");
		List<Map<String,Object>> lists=address.get('ㄱ');
		System.out.println("[ㄱ으로 시작하는 명단]");
		for(Map<String,Object> map:lists) {
			System.out.println("===============================================");
			Set<String> set=map.keySet();
			for(String key:set) {
				Object value = map.get(key);
				System.out.println(String.format("%s:%s", key,value));
			}
			System.out.println("===============================================");
		}
		
		
		System.out.println("[키값을 모를때]");
		keys=address.keySet();
		for(Character key : keys) {
			System.out.println(String.format("%c으로 시작하는 명단", key));
			lists=address.get(key);
			System.out.println("[ㄴ으로 시작하는 명단]");
			for(Map<String,Object> map:lists) {
				System.out.println("===============================================");
				Set<String> set=map.keySet();
				for(String ky:set) {
					Object value = map.get(ky);
					System.out.println(String.format("%s:%s", ky,value));
				}//inin for
				System.out.println("===============================================");
			}//in for
		}//out for

//		클래스 이용하여 저장 방법 가장가장 중요
		Map<Character, List<Address>> classAddress = new HashMap<Character, List<Address>>();
		List<Address> kiec = new Vector<Address>();
		List<Address> niec = new Vector<Address>();
		
		kiec.add(new Address("고길동", "010", "가산동", 20));
		kiec.add(new Address("가길동", "011", "독산동", 25));
		niec.add(new Address("나길동", "017", "천호동", 30));
		niec.add(new Address("노길동", "012", "신길동", 10));
		
		classAddress.put('ㄱ', kiec);
		classAddress.put('ㄴ', niec);
		
		System.out.println("[클래스를 사용해서 구현하기]");
//		출력 객체 꺼내오기
		keys=classAddress.keySet();
		for(Character key:keys) {
			System.out.println(String.format("%c으로 시작하는 명단", key));
			List<Address> vals = classAddress.get(key);
			for(Address val:vals) {
				val.printAddress();
			}
		}
		
		
		
		
		
		
		
		
		
	}//main
}//class
