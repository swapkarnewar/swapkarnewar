import java.util.Stack;

public class StkArr extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Object monitor = new Object();
	
	static boolean one = true;
	static boolean two = true;
	static boolean three = true;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new MyTestRunnable(1));
		Thread t2 = new Thread(new MyTestRunnable(2));
		Thread t3 = new Thread(new MyTestRunnable(3));
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(5000);
		System.exit(0);
	}
	
	static class MyTestRunnable implements Runnable {

		int threadVal;
		
		public MyTestRunnable(int threadVal) {
			this.threadVal = threadVal;
		}

		@Override
		public void run() {
			try {
				print();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}

		private void print() throws InterruptedException {
			while(true) {
				Thread.sleep(500);
				synchronized (monitor) {
					if(1 == threadVal) {
						if(one) {
							System.out.print(threadVal+" ");
							one = false;
							two = true;
							three = false;
							monitor.notifyAll();
						}
						else {
							monitor.wait();
						}
					}
					else if( 2 == threadVal ) {
						if( two ) {
							System.out.print(threadVal+ " ");
							one = false;
							two = false;
							three = true;
							monitor.notifyAll();
						}
						else {
							monitor.wait();
						}
					}
					else if( 3 == threadVal ) {
						if( three ) {
							System.out.print(threadVal+ " ");
							one = true;
							two = false;
							three = false;
							monitor.notifyAll();
						}
						else {
							monitor.wait();
						}
					}
					
				}
			}
		}

	}

	
}

