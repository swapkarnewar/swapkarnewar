package swapk.therads.Exs.ReentrantLocks;

public class App {

	
	public static void main(String[] args) throws InterruptedException {
		
		final ReentrantLocks processor = new ReentrantLocks();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		processor.finished();
		
		Thread.sleep(30000);
        System.exit(0);
	}

}
