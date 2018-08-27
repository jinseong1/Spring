package thread23;



class Command{
	
	void longMethod() {
		for(int i=0;i<=10;i++) {
			System.out.println(String.format("[실행중인 스레드명:%s,i=%d]",Thread.currentThread().getName(),i));
			try {Thread.sleep(3000);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

class Soldier extends Command implements Runnable{

	@Override
	public void run() {
		longMethod();
	}
	
}//class

public class RunnableApp {

	public static void main(String[] args) {
		Soldier soldier = new Soldier();
		System.out.println(soldier instanceof Soldier);
		System.out.println(soldier instanceof Command);
		System.out.println(soldier instanceof Runnable);
//		System.out.println(soldier instanceof Thread); [X]
		Thread thread1 = new Thread(soldier);
		thread1.setName("첫번째 스레드");
		thread1.start();
		Thread thread2 = new Thread(soldier);
		thread1.setName("두번째 스레드");
		thread2.start();
		
		
		
		
	}//main
}//class
