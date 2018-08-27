package thread23;

class MethodSyncClass{
	synchronized void increase (int seed, int inc) {
		for(int i=0;i<=10;i++) {
			seed+=inc;
			System.out.println(String.format("[Thread Name : %s Data :%d]",
											   Thread.currentThread().getName(),seed));
			try {Thread.sleep(900);}
			catch (InterruptedException e) {e.printStackTrace();}
		}//for
	}//method
}//class

class MethodSyncThread extends Thread{
	MethodSyncClass msc;
	int seed,inc;
	public MethodSyncThread(String threadName, MethodSyncClass msc, int seed, int inc) {
		super(threadName);
		this.msc = msc;
		this.seed = seed;
		this.inc = inc;
	}
	@Override
	public void run() {
		msc.increase(seed, inc);
	}//method
}//class



public class MethodSynchronized {

	public static void main(String[] args) {
		MethodSyncClass msc = new MethodSyncClass();
		MethodSyncThread mst1 = new MethodSyncThread("1st thread", msc, 10, 2);
		mst1.start();
		
		MethodSyncThread mst2 = new MethodSyncThread("2st thread", msc, 10, 5);
		mst2.start();
		
		
		
		
		
		
		
		
	}//main
}//class
