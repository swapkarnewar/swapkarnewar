package swapk.therads.Exs;

public class ThreadJoinExs {

	public synchronized void print1() {
		System.out.println("in print 1");
	}
	
	public synchronized void print2() {
		System.out.println("in print 2");
	}
	
	public static void main(String[] args) {
		
		ThreadJoinExs obj = new ThreadJoinExs();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread started: "+Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
					obj.print1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread Ended: "+Thread.currentThread().getName());
			}
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("Thread started: "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
				obj.print2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread Ended: "+Thread.currentThread().getName());
		});
		
		/*Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread started: "+Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread Ended: "+Thread.currentThread().getName());
			}
		});*/
		
		try {
			t1.start();
			t1.join();
			
			t2.start();
			t2.join();
			
			/*t3.start();
			t3.join();*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		
	}

}
