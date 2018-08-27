package thread23;

//여러 스레드가 공유하는 데이타를 갖고 있는 클래스
class DataSynClass{
//	여러 스레드가 공유하는 메모리
	int shareDate;

	public DataSynClass(int shareDate) {
		this.shareDate = shareDate;
	}
	
}

class DataSyncTread extends Thread{
	DataSynClass dsc;
//	일정하게 증가시킬 숫자를 저장할 멤버
	int inc;
//	스레드명을 저장할 멤버
	String threadName;
//	인자 생성자 만듬
	public DataSyncTread(DataSynClass dsc, int inc, String threadName) {
		super(threadName);
		this.dsc = dsc;
		this.inc = inc;
		this.threadName = threadName;
	}
	
	void increase(){
		for(int i=0;i<=10;i++) {
			dsc.shareDate+=inc;
			System.out.println(String.format("[스레드명 : %s, 공유데이타 : %d]",getName(),dsc.shareDate));
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
//		데이타 동기화 전
		increase();
//		데이타 동기화 후
		/*
		synchronized (dsc) {
			increase();
		}*/
		
		
		
		
		
	}
}


public class DataSynchronized {

	public static void main(String[] args) {
		DataSynClass dsc = new DataSynClass(10);
//		두개의 스레드 생성
		DataSyncTread dat1 = new DataSyncTread(dsc, 2, "1st 스레드 ");
		dat1.start();
		try {
			dat1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DataSyncTread dat2 = new DataSyncTread(dsc, 5, "2st 스레드 ");
		dat2.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
