package thread23;

class ThreadStop extends Thread{
	boolean isFlag;
	
	@Override
	public void run() {
		
		//interrupt()메소드 호출(추천)		
		int i=0;
		try {
			//while밖으로 catch절을 뺀다
			while(true) {			
				System.out.println("i="+i++);
				sleep(1000);
				
			}
		}
		catch(InterruptedException e) {
			System.out.println("interrt()메소드호출");
		}
		finally {
			System.out.println("스레드 중지");
		}
		/*
		//플래그 변수 사용(비추천)	
		int i=0;
		while(!isFlag) {			
			System.out.println("i="+i++);
			try {
				sleep(1000);
			} 
			catch (InterruptedException e) {
				System.out.println("sleep()메소드 호출됨.");
			}
			
		}//////////////////////////////
		*/
		
	}////////////////
}///////////////////
public class ThreadStopApp {

	public static void main(String[] args) {
		
		ThreadStop thread= new ThreadStop();
		thread.start();
		
		//아래는 메인 스레드 중지시키는 코드.즉 확인하기 위해
		//5초후에 interrupt()를 호출하거나 플래그를 true로 만들기위해
		//메인스레드를 대기상태로 만든다.
		try {
			System.out.println("실행중인 스레드:"+Thread.currentThread().getName());
			Thread.sleep(5000);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		//플래그 이용] boolean형 플래그 변수 사용
		//thread.isFlag=true;
		
		//interrupt()메소드 호출-(대기상태 일 때 호출 해야 InterruptedException발생 )
		System.out.println("isAlive() : "+thread.isAlive());
		if(thread.isAlive()) thread.interrupt();

	}//////////////main
}////////////////////class
