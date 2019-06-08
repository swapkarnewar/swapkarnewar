/**
 * This program will display seq 1 2 3 for 5 seconds with 3 threads
 * @author SKarnewar
 *
 */
public class SeqDispEx {

	static Object monitor = new Object();
	
	static boolean one = true;
	static boolean two = false;
	static boolean three = false;
	
	public static void main(String[] args) throws InterruptedException {
			
		Thread t1 = new Thread(new SeqDispThread(1));
		Thread t2 = new Thread(new SeqDispThread(2));
		Thread t3 = new Thread(new SeqDispThread(3));
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(10000);
		System.exit(0);
	}
	
	
	static class SeqDispThread implements Runnable {

		int thread;
		
		SeqDispThread(int thread) {
			this.thread = thread;
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
					if( 1 == thread ) {
						if(!one) {
							monitor.wait();
						}
						else {
							System.out.print(thread + " ");
							one = false;
							two = true;
							three = false;
							monitor.notifyAll();
						}
					}
					if( 2 == thread ) {
						if(!two) {
							monitor.wait();
						}
						else {
							System.out.print(thread + " ");
							one = false;
							two = false;
							three = true;
							monitor.notifyAll();
						}
					}
					if( 3 == thread ) {
						if(!three) {
							monitor.wait();
						}
						else {
							System.out.print(thread + " ");
							one = true;
							two = false;
							three = false;
							monitor.notifyAll();
						}
					}
				}
			}
		}
		
	}

}
