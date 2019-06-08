package swapk.therads.latest;

import java.util.ArrayList;
import java.util.List;

/**
 *  Solving Consumer Producer problem with using wait() and notify() methods, where consumer can consume only when production is over.
 * @author SKarnewar
 *
 */

class Producer implements Runnable {

	List sharedList = null;
	
	public Producer() {
		sharedList = new ArrayList<Integer>();
	}
	
	@Override
	public void run() {
		System.out.println("In producer thread");
		synchronized (this) {
			for( int i = 1; i <= 10; i++ ) {
				sharedList.add(i);
				System.out.println("producer is still producing. produced - "+i);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){e.printStackTrace();}
			}
			System.out.println("Production is over, consumer can consume.");

			this.notify();
		}
	}
	
}

class Consumer implements Runnable {

	Producer prod;
	public Consumer(Producer prod) {
		this.prod = prod;
	}
	
	@Override
	public void run() {
		synchronized (this.prod) {
			System.out.println("Consumer has wait untill producer finishes producing");
			try {
				this.prod.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println("Producer is done. Start consumer consuming");
		int productSize=this.prod.sharedList.size();
		for( int i = 0; i < productSize; i++ ){
			System.out.println("Consumed : "+ this.prod.sharedList.get(i) +" ");
		}
		System.out.println("Consumer is done.");
	
		
	}
	
}

public class ProducerConsumerApp {

	public static void main(String[] args) throws InterruptedException {
		Producer prod = new Producer();
		Consumer cons = new Consumer(prod);
		
		Thread prodTh = new Thread(prod);
		Thread consTh = new Thread(cons);
		
		consTh.start();
		Thread.sleep(100);
		prodTh.start();

		
	}

}
