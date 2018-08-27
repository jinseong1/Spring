package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import comm.util.CommonUtility;

/* 1차 개인 프로젝트시 참고 코드 */
public class AddressSampleProject {

	public static void main(String[] args) {
		
		Map<Character,List<Address>> address
		= new HashMap<Character,List<Address>>();
		//1]밸류 타입을 null로 초기화
		List<Address> valueList=null;
		//사용자 입력용 스캐너]
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("이름을 입력하세요?");
			String name = scanner.nextLine();
			//EXIT입력시 while문 빠져 나가기(종료)
			if("EXIT".equalsIgnoreCase(name)) break;
			
			//2]초성 (ㄱ,ㄴ,ㄷ,.....ㅎ)얻기
			char firstCharacter = CommonUtility.getFirstCharacter(name);
			//System.out.println("입력한 글자의 초성자음:"+firstCharacter);
			//한글이름이 아닌경우
			if(firstCharacter =='0') {
				System.out.println("한글명이 아닙니다");
				continue;
			}
			//3]초성이 한글 이름인 경우
			//맵컬렉션(address)에 firstChar 키값이 존재하는지 판단
			if(!address.containsKey(firstCharacter)) {//키값이 없는 경우.즉 맵컬렉션에 
                									//해당 키값이 저장이 안되어 있는 경우				
				//value타입인 List<Address>객체 생성
				valueList = new Vector<Address>();				
			}
			else {//키값이 존재한다면
				  //해당 키값으로 기존에 저장된 객체를 얻어온다
				valueList = address.get(firstCharacter);				
			}
			//입력한 객체를 추가
			valueList.add(new Address(name, "010","가산동",20));
			//4]맵 컬렉션에 firstChar키값으로 저장
			address.put(firstCharacter, valueList);			
		}////while
		//출력]
		
		Set<Character> keys=address.keySet();
		for(Character key : keys) {
			System.out.println(String.format("[%c로 시작하는 명단]",key));
			List<Address> values=address.get(key);
			for(Address value:values) value.printAddress();
		}////for
		/*문]찾고자 하는 사람의 이름을 입력받아
		     위 맵 컬렉션에 저장된 사람의 정보를 출력하자.
		     만약 해당하는 사람이 없으면 "해당하는 사람이 없어요"
		     라고 출력하여라.
		     찾을때까지 계속 입력받도록 하여라.
		 */
		while(true) {
			System.out.println("찾은 사람은 누구입니까?");
			String name=scanner.nextLine();		  
			char initChar = CommonUtility.getFirstCharacter(name);		      
			keys=address.keySet();
			boolean isKey=false;
			boolean isExist=false;
			for(Character key:keys) {			
				//키값이 같은 경우 비교하자
				if(key == initChar) {
					isKey=true;
					List<Address> values=address.get(key);					
					for(Address value:values) {
						if(value.name.equals(name)) {//이름이 같은 경우
							value.printAddress();
							isExist=true;
							break;
						}					
					}					
					if(!isExist) System.out.println("해당하는 사람이 없어요");
					else {						
						break;//찾은 경우:바깥 for문 빠져 나가기
					}
				}			
			}/////////////for
			if(isExist) break;
			if(!isKey) System.out.println("해당하는 사람이 없어요");			
		}///////////while
		
		
		
		
	}//////////main

}/////////////class
