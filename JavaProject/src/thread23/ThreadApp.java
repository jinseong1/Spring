package thread23;

class NotThread{
	String title;
//	인자생성자
	public NotThread(String title) {
		super();
		this.title = title;};
		void notThreadMehtod() {
//			로직이 시간이 오래 걸리는 시간이라고 가정
			for(int i=0 ; i<=10 ; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("%s]i=%d", title,i));
		}//for
	}//method
}//class


class YesThread extends Thread{
	
	public YesThread(String threadName) {
		super(threadName);
	}
//	run메소드 안에 시간이 오래 걸리는 작업을 넣어둔다

	void threadMehtod() throws InterruptedException {
//		로직이 시간이 오래 걸리는 시간이라고 가정
		for(int i=0 ; i<=10 ; i++) {
				sleep(900);
			System.out.println(String.format("%s]i=%d", this.getName(),i));
	}//for
}//method
	@Override
	public void run() {
		try {
			threadMehtod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DeamonThread extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println(String.format("%s 배경음악이 흘러요", getName()));
			try {sleep(2000);System.out.println(String.format("%s 2초마다 저장", getName()));}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}//out class

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread start");
		
		/*
//		Thread로 구현하지 않은 class
		NotThread nt1 = new NotThread("1st class");
		nt1.notThreadMehtod();
		NotThread nt2 = new NotThread("2st class");
		nt1.notThreadMehtod();
		*/
		
		YesThread yt1 = new YesThread("1st thread");
//		메소드로 thread명 설정
		yt1.setName("첫번째 thread"); 
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
//		yt1.join();
		YesThread yt2 = new YesThread("2nd thread");
		yt2.start();
		DeamonThread deamon = new DeamonThread();
//		deamon.setName("데몬스레드");
//		deamon.setDaemon(true);
		deamon.start();
		
		System.out.println("현재 활성화 상태(Runnable or Running) 있는 스레드 수 :"+Thread.activeCount());
		System.out.println("1번째 스레드의 우선권 : "+yt1.getPriority());
		System.out.println("2번째 스레드의 우선권 : "+yt2.getPriority());
		System.out.println("첫번째 스레드의 종속 스레드 여부 :"+(yt1.isDaemon()?"종속스레드":"독립스레드"));
		System.out.println("deamon의 종속 드레드 여부"+(deamon.isDaemon()?"종속스레드":"독립스레드"));
		System.out.println("main스레드우선권"+Thread.currentThread().getPriority());
		System.out.println("현재 실행중인 (Running) 스레드명 : "+Thread.currentThread().getName());
		System.out.println("main thread end");
		
	}//main
}//class
