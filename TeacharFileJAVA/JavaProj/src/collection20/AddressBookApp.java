package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

//이름/나이/주소/전번을 저장하는 클래스]
class Address implements Comparable<Address>{
	//[멤버변수]
	String name;
	String tel;
	String addr;
	int age;
	//[인자 생성자]
	public Address(String name, String tel, String addr, int age) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.age = age;
	}////////////////////////
	//[멤버 메소드]
	String getAddress() {
		return String.format("이름:%s,나이:%d,전번:%s,주소:%s",name,age,tel,addr);
	}////////////////////////
	void printAddress() {
		System.out.println(getAddress());
	}//////////////////////
	@Override
	public int compareTo(Address anotherAddress) {
		//오름차순]		
		//return this.name.compareTo(anotherAddress.name);
		//내림차순]
		return anotherAddress.name.compareTo(name);
	}
	
}


public class AddressBookApp {

	public static void main(String[] args) {
		/*
		1]초성을 Key값-String 혹은 Character		  
		  List계열 컬렉션을 Value값-List<String>
		  Map계열 컬렉션		  
		  Value에는 초성에 해당하는 이름들 저장
		*/
		Map<Character,List> nameAddr= new HashMap<Character,List>();
		//1-1]이름 저장용 List계열 컬렉션 객체 생성]
		List kieyeok = new Vector();
		List nieeoun = new Vector();
		//1-2]이름 저장
		kieyeok.add("고길동");
		kieyeok.add("곽길동");
		kieyeok.add("기길동");
		kieyeok.add("김길동");
		
		nieeoun.add("노길동");
		nieeoun.add("나길동");
		nieeoun.add("남길동");
		
		//1-3]Map컬렉션(nameAddr)에 이름이 저장된 List계열 컬렉션 저장
		nameAddr.put('ㄱ', kieyeok);
		nameAddr.put('ㄴ', nieeoun);
		//1-4-1]키값을 알때		
		System.out.println("[키값을 알때]");
		List values=nameAddr.get('ㄱ');
		for(Object value:values) System.out.println(value);
		//1-4-1]키값을 모를때
		System.out.println("[키값을 모를때]");
		//1]keySet()으로 Set컬렉션 얻기
		Set<Character> keys=nameAddr.keySet();
		//2]Set컬렉션에 확장 for문 적용
		for(Character key:keys) {
			System.out.println(String.format("[%c로 시작하는 명단]",key));
			//3]get(키값)으로 value얻기
			values=nameAddr.get(key);
			for(Object value:values) 
				System.out.println(value);
		}/////////////////////
		/*
		2]초성을 Key값-String 혹은 Character		 
		  List계열 컬렉션을 Value값-List<Map<String,Object>>
		  Map계열 컬렉션		  
		  Value에는 초성에 해당하는 이름,주소,전화번호들 저장
		*/
		Map<Character,List<Map<String,Object>>> address
			=new HashMap<Character,List<Map<String,Object>>>();
		//2-1]이름/전번/주소/나이가 저장된 맵 컬렉션을 저장할
		//    리스트계열 컬렉션 객체 생성
		List<Map<String,Object>> kie = new Vector<Map<String,Object>>();
		List<Map<String,Object>> nie = new Vector<Map<String,Object>>();
		//2-2]이름/전번/주소/나이를 저장할 맵 컬렉션 객체 생성
		Map<String,Object> k=new HashMap<String,Object>();
		k.put("name", "고길동");
		k.put("age",20);
		k.put("addr", "가산동");
		k.put("tel", "010");
		//리스트 계열 컬렉션에 저장
		kie.add(k);
		k=new HashMap<String,Object>();
		k.put("name", "가길동");
		k.put("age",30);
		k.put("addr", "독산동");
		k.put("tel", "011");
		//리스트 계열 컬렉션에 저장
		kie.add(k);
		
		Map<String,Object> n=new HashMap<String,Object>();
		n.put("name", "나길동");
		n.put("age",25);
		n.put("addr", "방배동");
		n.put("tel", "019");
		//리스트 계열 컬렉션에 저장
		nie.add(n);
		n=new HashMap<String,Object>();
		n.put("name", "노길동");
		n.put("age",35);
		n.put("addr", "사당동");
		n.put("tel", "017");
		//리스트 계열 컬렉션에 저장
		nie.add(n);
		//주소록 저장하는 맵컬렉션에 리스트 저장]
		address.put('ㄱ',kie);
		address.put('ㄴ',nie);
		/*
		 * 객체 꺼내올때]
		 * Set/List계열 무조건 확장 for문 사용
		 * Map계열은 keySet()으로 키값들이 저장된
		 * Set계열 반환 받은 후 확장 for문 사용	
		 */
		//출력]
		System.out.println("[키값을 알때]");
		List<Map<String,Object>> lists=address.get('ㄱ');
		System.out.println("[ㄱ으로 시작하는 명단]");
		for(Map<String,Object> map:lists) {
			System.out.println("-------------------------------------");
			Set<String> set=map.keySet();
			for(String key:set) {
				Object value = map.get(key);
				System.out.println(String.format("%s:%s",key,value));
			}///inner for			
		}///outer for
		
		System.out.println("[키값을 모를때]");
		keys= address.keySet();
		
		for(Character key:keys) {
			System.out.println(String.format("[%c으로 시작하는 명단]",key));
			lists=address.get(key);			
			for(Map<String,Object> map:lists) {
				System.out.println("-------------------------------------");
				Set<String> set=map.keySet();
				for(String ky:set) {
					Object value = map.get(ky);
					System.out.println(String.format("%s:%s",ky,value));
				}///inner for			
			}///outer for			
		}////////////////for
		
		//3]Address클래스를 사용해서 2]번 처럼 구현
		Map<Character,List<Address>> classAddress
			= new HashMap<Character,List<Address>>();
		//3-1]주소를 저장할 리스트 계열 컬렉션 생성
		List<Address> kiec = new Vector<Address>();
		List<Address> niec = new Vector<Address>();
		//3-2]주소 저장
		kiec.add(new Address("고길동", "010", "가산동", 20));
		kiec.add(new Address("가길동", "011", "독산동", 25));
		niec.add(new Address("나길동", "017", "천호동", 30));
		niec.add(new Address("노길동", "019", "신천동", 10));
		//3-3]키값으로 리스트 컬렉션객체를 맵(classAddress)에 저장
		classAddress.put('ㄱ',kiec);
		classAddress.put('ㄴ',niec);
		
		System.out.println("[클래스를 사용해서 구현하기]");
		//출력-객체 꺼내오기]
		keys=classAddress.keySet();
		for(Character key:keys) {
			System.out.println(String.format("[%c으로 시작하는 명단]",key));			
			List<Address> vals=classAddress.get(key);
			for(Address val:vals) {
				val.printAddress();			
			}/////////for			
		}////for
		
		
		
	}////////////main

}///////////////class
