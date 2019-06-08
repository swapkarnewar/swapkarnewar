package swapk.therads.ProducerConsumer;

import java.util.LinkedList;
import java.util.List;
/**
 * producer will produce all and then consumer will consume
 * @author SKarnewar
 *
 */
class Consumer implements Runnable {

	Producer prod;
	
	public Consumer(Producer prod) {
		this.prod = prod;
	}
	
	@Override
	public void run() {
		synchronized (this.prod) {
			System.out.println("consumer waiting to create all by producer");
			try {
				this.prod.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("now prod is over. Consumer statrs consuming");
		int size = this.prod.sharedQueue.size();
		for( int i = 1; i<=size; i++ ) {
			System.out.println("consuming : "+this.prod.sharedQueue.remove(0));
		}
	}
	
}

class Producer implements Runnable {

	List<Integer> sharedQueue;
	
	Producer() {
		sharedQueue = new LinkedList<Integer>();
	}
	
	@Override
	public void run() {
		System.out.println("in producer");
		synchronized (this) {
			for( int i = 1; i < 10; i++ ) {
				sharedQueue.add(i);
				System.out.println("producer is still in production, produced : "+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("production is over");
			this.notify();
		}
	}
	
}

public class ProducerConsumerWithWaitNotify {

	public static void main(String[] args) {
		
		Producer prod = new Producer();
		Consumer cons = new Consumer(prod);
		
		Thread t1 = new Thread(prod, "prodThread");
		Thread t2 = new Thread(cons, "consThread");
		
		try {
			t2.start();
			Thread.sleep(100);
			t1.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
