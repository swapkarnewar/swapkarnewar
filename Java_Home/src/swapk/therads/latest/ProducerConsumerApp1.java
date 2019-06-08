package swapk.therads.latest;

/**
 * solve consumer producer problem using wait() and notify() method, producer produces at max 2 elements and will wait for consumer to consume it, after comsuming again it will produce
 * @author SKarnewar
 *
 */

class ProducerDoes2 implements Runnable {

	
	@Override
	public void run() {
		synchronized (String.class) {
			System.out.println("Thread 1 aquired lock on String");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Object.class) {
				System.out.println("Thread 1 aquired lock on Object");
			}
		}
		System.out.println("Thread 1 ends");
	}
	
}


class ProducerDoes1 implements Runnable {

	
	@Override
	public void run() {
		synchronized (Object.class) {
			System.out.println("Thread 2 aquired lock on Object");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (String.class) {
				System.out.println("Thread 2 aquired lock on String");
			}
		}
		System.out.println("Thread 2 ends");
	}
	
}

public class ProducerConsumerApp1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ProducerDoes1());
		Thread t2 = new Thread(new ProducerDoes2());
		t1.start();
		t1.join();
		t1.yield();
		t2.start();
	}

}
