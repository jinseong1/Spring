package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import comm.util.CommonUtility;

public class AddressSampleProject {

 public static void main(String[] args) {
  
  Map<Character,List<Address>> address = new HashMap<Character,List<Address>>();
  
  List<Address> valueList=null;
  Scanner scanner = new Scanner(System.in);
  while (true) {
   System.out.println("이름을 입력하세요");
   String name = scanner.nextLine();
   // Exit입력시 while문 빠져 나가기
   if("EXIT".equalsIgnoreCase(name)) break;
   char firstCharacter = CommonUtility.getFirstCharacter(name);
   //System.out.println("입력한 글자의 초성자음:" + firstCharacter);
   if(firstCharacter ==0) {
    System.out.println("한글명이 아닙니다");
    continue;
   }
   //초성이 한글 이름인 경우
   if(!address.containsKey(firstCharacter)) {
    valueList = new Vector<Address>();
   }
   else {
    valueList = address.get(firstCharacter);
   }
   //입력한 객체를 추가
   valueList.add(new Address(name, "010", "가산동", 20));
   
   address.put(firstCharacter, valueList);
   
  }///////while
  //출력]
  Set<Character> keys = address.keySet();
  for(Character key : keys) {
   System.out.println(String.format("[%c로 시작하는 명단]", key));
   List<Address> values = address.get(key);
   for(Address value:values) value.printAddress();
  }
  
  /*
   * 문]찾고자 하는 사람의 이름을 입력받아
   * 위 맵 컬렉션에 저장된 사람의 정보를 출력하자
   * 만약 해당하는 사람이 없으면  해당하는 사람이 없어요
   * 라고 출력하여라
   * 찾을때까지 계속 입력받도록 하여라
   */	
  	while(true) {
  		System.out.println("찾을 사람은 누구입니까?");
  		String name = scanner.nextLine();
  		keys=address.keySet();
  		boolean iskey=false;
  		boolean isExist=false;
  		for(Character key:keys) {
//  		키값이 같은 경우를 비교하자
  			char initChar = CommonUtility.getFirstCharacter(name);
  			if(key == initChar) {
  				iskey=true;
  			List<Address> values=address.get(key);
  			for(Address value:values) {
  				if(value.name.equals(name)) {
  					value.printAddress();
  					isExist=true;
  					break;
  					}
  				}
  			if(!isExist) System.out.println("해당하는 사람이 없어요");
  			else {
  				break;
  			}
  			//바깥 for문 빠져나가기
  			}
  		}	if(isExist) break;
	  		if(!iskey) System.out.println("해당하는 사람이 없어요");
  	}//while
  

  
  
 }/////////main

}////////////class