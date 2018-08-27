package etcclass12;

import java.util.Random;

public class MathClass {
	//문]Math클래스의 abs() 메소드와 같은 기능을 하는
	//   메소드를 정의해라
	private static int abs(int value) {
		
		return value < 0 ? -value : value;
	}///////////////////////////////////
	//문]Math클래스의 round() 메소드와 같은 기능을 하는
    //   메소드를 정의해라		
	private static long round(double value) {
		
		//방법1]		
		//return value > 0 ? (long)(value+0.5) :(long)(value-0.4);
		//방법2]
			//소수 첫째자리 부분]
			//예:145.258-> 145.258*10=1452.58 ->(int)1452 % 10 =2
			/*
			String str=String.valueOf(value);
			int index=str.indexOf(".")+1;
			int remain=Integer.parseInt(str.substring(index,index+1));
			int real = Integer.parseInt(str.substring(0,index-1));
			*/
			
			int remain=(int)(value*10%10);
			//정수 부분]
			int real=((int)(value*10)-remain)/10;		
			/*
			 * 양수일때 소수점 첫째 자리가 5보다 크거나 같으면 +1
			 * 음수일때 소수점 첫째 자리가 5보다 크다면 -1
			 * 
			 */
			if(value >=0){
				if(remain >=5) real++;
			}		
			else{ 
				if(Math.abs(remain) >5) real--; 
			}		
			return real;
	}/////////////////////////
	//문]Math클래스의 pow() 메소드와 같은 기능을 하는
	//   메소드를 정의해라
	private static int pow(int i, int j) {
		int gop=1;
		for(int k=0 ; k < j ;k++) gop*=i;
		return gop;
	}/////////////
	
	public static void main(String[] args) {
		////Math클래스는 인스턴스화(객체화/HEAP영역에 메모리 생성) 불가]
		//Math math = new Math();
		//Math클래스의 정적 멤버 상수:PI  
		System.out.println(Math.PI);
		//절대값:static 반환타입 abs(매개변수):
		//      반환타입은 매개변수의 타입에 따라 결정됨.
		float f= -3.14F;
		double d = -100.9;
		int num =-10;
		System.out.println("[abs()메소드]");
		System.out.println(Math.abs(f));
		System.out.println(Math.abs(d));
		System.out.println(Math.abs(num));
		System.out.println(abs(-100));
		System.out.println(abs(100));
		System.out.println(abs(-99));
		//올림값 :static double ceil(double a)
		//소수점에서 큰 수로 가장 가까운 정수를 찾는다.
		//3.4 -> 4,3.9->4 -3.4 ->-3
		System.out.println("[ceil()메소드]");
		System.out.println(Math.ceil(3.4));
		System.out.println(Math.ceil(3.9));
		System.out.println(Math.ceil(-3.4));
		//내림값 : static double floor(double a)  
		//소수점에서 작은 수로 가장 가까운 정수를 찾는다.
		//3.4->3 ,-3.4->-4 3.9->3
		System.out.println(Math.floor(3.4));
		System.out.println(Math.floor(3.9));
		System.out.println(Math.floor(-3.4));
		//반올림:무조건 소수점 첫째자리에서 반올림
		//static long round(double a) 
		//static int round(float a )
		System.out.println("[round()메소드");
		System.out.println(Math.round(3.49));
		System.out.println(Math.round(3.51));
		System.out.println(Math.round(-1.4));
		System.out.println(Math.round(-1.8));
		System.out.println(Math.round(-0.4));
		System.out.println(Math.round(-0.8));
		System.out.println(Math.round(-1.5));
		System.out.println("[내가 만든 round()메소드]");
		System.out.println(round(3.49));
		System.out.println(round(3.51));
		System.out.println(round(-1.4));
		System.out.println(round(-1.8));
		System.out.println(round(-0.4));
		System.out.println(round(-0.8));
		System.out.println(round(-1.5));
		//두 숫자 중 큰값 혹은 작은값 반환:max(),min()
		System.out.println("[max()/min()메소드]");
		System.out.println("최대값:"+Math.max(100, 10));
		System.out.println("최소값:"+Math.min(100, 10));
		//지수: static double pow(double a, double b)  
		//      a의 b승을 의미
		// pow(2,3) : 2의 3승 ->2 * 2* 2
		System.out.println("[pow()메소드]");
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(3, 2));
		System.out.println("[내가 만든 pow()메소드]");
		System.out.println(pow(2, 3));
		System.out.println(pow(3, 2));
		//Math.random() 과 같은 기능을 제공해주는 
		//Random클래스
		//5부터 10까지 랜덤하게 발생
		//(int)(Math.random()*(차이값+1))+시작값
		System.out.println((int)(Math.random()*6)+5);
		//Random클래스의 인스턴스변수.nextInt(차이값+1)+시작값
		Random rand = new Random();
		System.out.println(rand.nextInt(6)+5);
	}////////////////////main
	

	

	

}///////////////////////class
