package collection20;

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
			for(Address value:values) value.printAddress();
		}
		
	}/////////////main

}////////////////class
