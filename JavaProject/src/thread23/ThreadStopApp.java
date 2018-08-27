package thread23;

class ThreadStop extends Thread{
	
	boolean isFlag;	
	/*
	@Override
	public void run() {
		int i=0;
		
		while(!isFlag) {
			i++;
			System.out.println("i = "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Sleep() Method Call");
			}
		}//while
	}//run
	*/
	int i=0;
	@Override
	public void run() {
		
	try {
		while(true) {
			System.out.println("i = "+i++);
			sleep(1000);
		}
	}
		catch (InterruptedException e) {
			System.out.println("메소드 호출");
		}
		finally {
			System.out.println("스레드 중지");

		}//while
	}//run
}//class


public class ThreadStopApp {

	public static void main(String[] args) {
		ThreadStop thread = new ThreadStop();
		thread.start();
		
		try {
			System.out.println("Running Thread : "+Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		플래그 이용
//		thread.isFlag=true; // 비추천
		
		
		
		System.out.println("isAlive() : "+thread.isAlive());
		if(thread.isAlive()) thread.interrupt();
		
		
		
		
	}//main
}//class
