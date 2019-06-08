package swapk.therads.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer3 implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	Producer3(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		for( int i = 1; i <=10; i++ ) {
			try {
				System.out.println("prodiced : "+i);
				blockingQueue.add(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer3 implements Runnable {

	private BlockingQueue<Integer> blockingQueue;
	
	Consumer3(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		while( true ) {
			try {
				System.out.println("consumed : "+blockingQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		
		Producer3 producer = new Producer3(sharedQueue);
		Consumer3 consumer = new Consumer3(sharedQueue);
		
		Thread t1 = new Thread(producer,"producer");
		Thread t2 = new Thread(consumer,"consumer");
		
		t1.start();
		t2.start();
		
	}

}
