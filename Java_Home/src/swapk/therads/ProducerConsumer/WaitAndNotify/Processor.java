package swapk.therads.ProducerConsumer.WaitAndNotify;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private final Object lock = new Object();
	
	public void producer() throws InterruptedException {
		Random random = new Random();
		int value = 0;
		while(true) {
			synchronized (lock) {
				while( list.size() == LIMIT )
					lock.wait();
				list.add(value);
				System.out.println("Producer Added Value: "+value+"; size: "+list.size());
				value++;
				lock.notify();
			}
		}
		
	}

	public void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			synchronized (lock) {
				
				while( list.size() == 0 ) {
					lock.wait();
				}
				
				int value = list.removeFirst();
				System.out.print("Removed value by consumer is: " + value);
                System.out.println(" Now list size is: " + list.size());
                lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}
	}

}
