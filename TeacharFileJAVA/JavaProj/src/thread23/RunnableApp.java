package thread23;

class Command{
	
	void longedMethod() {
		for(int i=1;i<=10;i++) {
			System.out.println(String.format("[실행중인 스레드명:%s,i=%d]",
					Thread.currentThread().getName(),i));
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}////////////
	
}//////////
//1]Runnable인터페이스 상속
class Soldier extends Command implements Runnable{
	//2]run()오버라이딩
	@Override
	public void run() {
		longedMethod();
	}//////////run
	
}////class


public class RunnableApp {

	public static void main(String[] args) {
		//1]Runnable타입을 Thread클래스의 인자 생성자를
		//  이용해서 Thread타입으로 변환
		Soldier soldier = new Soldier();
		System.out.println(soldier instanceof Soldier);
		System.out.println(soldier instanceof Command);
		System.out.println(soldier instanceof Runnable);
		//System.out.println(soldier instanceof Thread);//[x]
		Thread thread1 = new Thread(soldier);
		thread1.setName("첫번째 스레드");
		thread1.start();
		
		Thread thread2 = new Thread(soldier,"두번째 스레드");
		thread2.start();
		
		
		
	}////////////main

}///////////////class
