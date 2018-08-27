package collection20;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/*
 * 
 * TreeMap:Map계열 컬렉션
 *         키값이 정렬된 상태로 저장되어 있음 (디폴트는 오름차순 정렬)
 *         HashMap보다는 성능이 떨어지나
 *         정렬된 키값으로 출력하고자 할때 유리..
 */
public class TreeMapApp {

	public static void main(String[] args) {
		/*
		※배열이나 컬렉션(List계열) 정렬하기
		배열 : Arrays.sort(배열)
		컬렉션:Collections.sort(List계열 컬렉션)
		단,배열의 타입 혹은 List계열 컬렉션에 저장된 객체의 타입은
		반드시 Comparable인터페이스를 상속받고 compareTo()를 오버라이딩 해야한다		
		 */
		
		String[] stringArray= {"홍길동","가길동","도길동","나길동"};
		//배열 정렬하기]
		Arrays.sort(stringArray);
		System.out.println("[배열 정렬후 출력]");
		System.out.println(Arrays.toString(stringArray));
		
		List  list = new Vector();
		list.add(200);
		list.add(150);
		list.add(35);
		list.add(1004);
		//컬렉션 정렬하기]
		Collections.sort(list);
	    //컬렉션을 배열로 변환하기	
	    Object[] objectArray=list.toArray();
		System.out.println("[컬렉션 정렬후 배열로 변환한 후 출력하기]");
		System.out.println(Arrays.toString(objectArray));
		
		Map<Character,List<Address>> address
		= new TreeMap<Character,List<Address>>();
		
		List<Address> kiyeok = new Vector<Address>();
		kiyeok.add(new Address("곽길동", "010", "가산동", 20));
		kiyeok.add(new Address("가길동", "010", "가산동", 20));
		kiyeok.add(new Address("김길동", "010", "가산동", 20));
		
		List<Address> nieeoun = new Vector<Address>();
		nieeoun.add(new Address("노길동", "010", "가산동", 20));
		nieeoun.add(new Address("나길동", "010", "가산동", 20));
		nieeoun.add(new Address("너길동", "010", "가산동", 20));
		
		List<Address> digeut = new Vector<Address>();
		digeut.add(new Address("다길동", "010", "가산동", 20));
		digeut.add(new Address("도길동", "010", "가산동", 20));
		digeut.add(new Address("더길동", "010", "가산동", 20));
		
		//맵켈렉션에 아래 순서대로 저장]
		address.put('ㄷ', digeut);		
		address.put('ㄱ', kiyeok);
		address.put('ㄴ', nieeoun);
		
		//출력-디폴트로 오름차순으로 정렬되서 출력됨.
		//Set<Character> keys=address.keySet();
		Set<Character> keys=((TreeMap)address).descendingKeySet();
		for(Character key:keys) {
			System.out.println(String.format("[%c로 시작하는 명단]",key));
			List<Address> values=address.get(key);
			//정렬후 출력]
			/* 아래가 선행되어야 한다
			 * 1. Address클레스에서 Comparable인터페이스를 구현
			 * 2. compareTo()메소드를 오버라이딩
			 */
			Collections.sort(values);
			for(Address value:values) value.printAddress();
		}
		
	}/////////////main

}////////////////class
