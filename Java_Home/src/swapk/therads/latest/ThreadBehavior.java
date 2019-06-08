package swapk.therads.latest;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
		}
	}
	
}

public class ThreadBehavior {

	public static void main(String[] args) throws InterruptedException {
		MyRunnable tClass = new MyRunnable();
		
		Thread t1 = new Thread(tClass);
		
		Thread t2 = new Thread(tClass);
		
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();

	}

}
