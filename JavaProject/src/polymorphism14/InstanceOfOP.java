package polymorphism14;

/*

 * instanceof 연산자

 * 두 클래스간의 형변환이 가능한지 판단하느 연산자

 * 해당 인스

 */

class Super{}

class Normal extends Super{}

 

public class InstanceOfOP {

 

 public static void main(String[] args) {

  //두 클래스간의 상속관계가 존재하지 않을때

  String string = new String("JAVA");

  StringBuffer buffer = new StringBuffer(" WORLD");

  //상속관계 미존재시 대입 연산도 불가

  //string = buffer;

  //buffer = string;

  System.out.println(string instanceof String?"string은 String타입이다":"string은 String타입이 아니다");

  System.out.println(string instanceof Object?"string은 Object타입이다":"string은 Object타입이 아니다");

  System.out.println(buffer instanceof StringBuffer);

  System.out.println(buffer instanceof Object);

  //상속관계가 없을때 에러

  //System.out.println(string instanceof StringBuffer);

  

  Object object = new Object();

  //

  //String stringobj = (String)object;//실행할때 에러

  System.out.println("[object = stirng;코드 실행전]");

  System.out.println(object instanceof String);//false

  if(object instanceof String) {

   String stringObj = (String)object;

   System.out.println("형변환이 일어났어요");

  }

  object = string;//상속관계 존재시

  System.out.println("[object = stirng;코드 실행후]");

  System.out.println(object instanceof String);//true

  if(object instanceof String) {

   String stringObj = (String)object;

   System.out.println("형변환이 일어났어요");

  }

  

  Super s = new Super();

  System.out.println(s instanceof Super);

  System.out.println(s instanceof Object);

  System.out.println(s instanceof Normal);


  s = new Normal();

  System.out.println(s instanceof Normal);

  System.out.println(s instanceof Object);

  System.out.println(s instanceof Super);

  

 }//////main

 

}/////////class

