package wrapperclass10;

import java.util.Scanner;

public class WrapperClass03 {

 public static boolean isNumber(String value) {
	 /*
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
	  * 
  //문]인자로 전달받은 vlaue가 숫자형식이면 true 반환 아니면 false를 반환하는 메소드를 정의하라
  //예]"20" => true,"20A1" => false
  for(int i=0; i<value.length();i++) {//문자 한자리마다 숫자인지 문자인지 따져야 한다
  
   if(!Character.isDigit(Character.codePointAt(value, i)))
    return false;
 
   if(!(Character.codePointAt(value, i)>='0'&&Character.codePointAt(value, i)<='9'))
    return false;
  }
     */
	 for(int i=0;i<value.length();i++) {
		if(!(value.codePointAt(i)>='0'&&value.length()<='9'))
			return false;
	 }
	 
  return true;
 }
 public static void main(String[] args) {
  char ch ='A';
  Character chObj = new Character(ch);
  char chResult=(char)(chObj.charValue()+1);
  System.out.println("chResult="+chResult);
  
  chObj = 'C';//오토 박싱 char -> Character형으로
  chResult = chObj;
  System.out.println("chResult="+chResult);
  
  System.out.println(Character.codePointAt("ABCD", 2));
  
  System.out.println(Character.isDigit('A')?"숫자다":"숫자가 아니다");
  System.out.println(Character.isDigit('2')?"숫자다":"숫자가 아니다");
  System.out.println(Character.isDigit(67)?"숫자다":"숫자가 아니다");
  System.out.println(Character.isDigit('가')?"숫자다":"숫자가 아니다");
  
  //System.out.println("123456abcd".length());
  
  /*
  Scanner sc = new Scanner(System.in);
  System.out.println("나이를 입력하세요");
  String value = sc.nextLine();
  if(isNumber(value))
  System.out.println("당신의 10년후 나이는 "+(Integer.parseInt(value)+10));
  else 
   System.out.println("나이는 숫자만 입력하세요.....");
   */
  System.out.println("[isLetter메소드]");
  System.out.println(Character.isLetter('가'));
  System.out.println(Character.isLetter('A'));
  System.out.println(Character.isLetter('a'));
  System.out.println(Character.isLetter('家'));
  System.out.println(Character.isLetter('9'));
  System.out.println(Character.isLetter('@'));
  
  System.out.println("[isWhitespace메소드]");
  System.out.println(Character.isWhitespace('가'));
  System.out.println(Character.isWhitespace(32));
  System.out.println(Character.isWhitespace(' '));
  String whiteString = "   H     E    L    L  O";
  int whiteCount = 0;
  
  System.out.println("총 공백수:"+whiteCount);
  for(int i=0;i<whiteString.length();i++)
   if(Character.isWhitespace(Character.codePointAt(whiteString, i)))
    whiteCount++;
  System.out.println("총 공백수:"+whiteCount);
  
  System.out.println("[isUpperCase메소드]");
  System.out.println(Character.isUpperCase('A'));
  System.out.println(Character.isUpperCase('a'));
  System.out.println(Character.isLowerCase('A'));
  System.out.println(Character.isLowerCase('a'));
  System.out.println(Character.isUpperCase('가'));
  System.out.println(Character.isLowerCase('9'));
  
  //아이디를 입력 받는데 영문자 소문자와 숫자로만 입력받아야 한다
  //대문자가 포함되면 "잘못입력했어요"라고 출력하고 제대로된 아이디를 입력받을때까지 계속 입력 받도록 하여라
  //단 숫자로 시작해서도 안된다 즉 숫자로 시작한 아이디를 입력했을때도 "잘못입력했어요"라고 출력하세요
  //hint]아이디 입력받을때 Scanner의 nextLine사용
  //String 클래스의 toCharArray()사용
  /*
  Scanner sc = new Scanner(System.in);
  
  while(true) {
   boolean isCorrect = true;
   System.out.println("아이디를 입력하세요");
   String nickname = sc.nextLine();
   char [] charr =  nickname.toCharArray();
   for(int i=0; i< charr.length;i++) {
   
   if(Character.isDigit(charr[0]) || !Character.isLowerCase(charr[i]) && !Character.isDigit(charr[i])) {
    System.out.println("잘못 입력했어요");
    isCorrect=false;
    break;
    }
   }//////for
   if(isCorrect) {
   System.out.println("당신의 아이디는"+nickname);
   break;
   }
  }///while 
  */
  /*
  System.out.println("[String 클래스의 toCharArray메소드]");
  String value = "KOSMO";
  char[] valueArray = value.toCharArray();
  System.out.println(valueArray[0]);
  System.out.println(valueArray[2]);
  */
  
  System.out.println(Character.toUpperCase('A'));
  System.out.println(Character.toUpperCase('a'));
  System.out.println(Character.toLowerCase('a'));
  System.out.println(Character.toLowerCase('A'));
  System.out.println(Character.toLowerCase('가'));
  System.out.println((char)Character.toUpperCase(97));
  
  //사용자로부터 문자열(영문자)을 입력받아서
  //대문자는 소문자로, 소문자는 대문자로 변경하여 출력하여라
  //예]Hello입력 => hELLO출력
  
  Scanner sc = new Scanner(System.in);
  System.out.println("영문자를 입력하세요");
  String alphabet = sc.nextLine();
  char[]charr = alphabet.toCharArray();
  //3번째 방법으 위한 변수 선언
  String alphabetString=" ";
  for(int i=0; i< charr.length;i++) {
   
   if(Character.isLowerCase(charr[i]))
    //1번째 방법-직접 출력
    //System.out.print(Character.toUpperCase(charr[i]));
    //2-대문자로 변경
    //charr[i]=Character.toUpperCase(charr[i]);
    alphabetString+=Character.toUpperCase(charr[i]);
   else
    //1번째 방법
    //System.out.print(Character.toLowerCase(charr[i]));
    //2번째 방법
    //charr[i]=Character.toLowerCase(charr[i]);
    alphabetString+=Character.toLowerCase(charr[i]);
   //System.out.print(charr[i]);//2번째 방법
  }
  System.out.println(alphabetString);
 
  //위의 최종 변환된 문자열을 거꾸로 출력
  //Hello -> hEllO -> OLLeh
  charr=alphabetString.toCharArray();
  System.out.println("거꾸로 출력");
  for(int i=charr.length-1;i>=0;i--) {
   System.out.print(charr[i]);
  }
  
  int num = 100;
  //정적 메소드
  System.out.println(Integer.toString(num));
  System.out.println("변환된 타입:"+Integer.toString(num).getClass().getName());
  
  //인스턴스 메소드]
  Integer intOb=num;
  System.out.println("변환된 타입:"+intOb.toString().getClass().getTypeName());
  
  short s=200;
  System.out.println(Short.toString(s));
  short shtObj = Short.valueOf(s);
  //System.out.println(shtObj.toString().);
  
  ch = '가';
  System.out.println("정적메소드:"+Character.toString(ch));
  System.out.println("인스턴스형 메소드:"+Character.valueOf(ch).toString());
  
  boolean b=true;
  System.out.println("정적메소드:"+Boolean.toString(b));
  System.out.println("인스턴스형 메소드:"+Boolean.valueOf(b).toString());
  
  String stringNumber="100";
  
  byte by = Byte.parseByte(stringNumber);//"100"->100(1byte)
  System.out.println(by);
  System.out.println(Short.parseShort(stringNumber));//-->(2byte)
  System.out.println(Integer.parseInt(stringNumber));
  System.out.println(Integer.valueOf(stringNumber).getClass().getName());
  
  String boolString="TrUe";
  System.out.println(Boolean.parseBoolean(boolString));//"TrUe"-->true(블린값)
  System.out.println(Boolean.valueOf(boolString));
  System.out.println(Boolean.valueOf(boolString).getClass().getName());
  
 
 }///////////main



}