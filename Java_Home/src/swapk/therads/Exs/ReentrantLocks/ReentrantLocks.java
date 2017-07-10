package swapk.therads.Exs.ReentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ....");
		cond.await();
		System.out.println("thread 1 resume....");
		try {
			increment();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(100);
		lock.lock();
		new Scanner(System.in).nextLine();
        System.out.println("Got return key!");
        cond.signal();
        System.out.println("Still in thread 2");
        try {
			increment();
		}
		finally {
			lock.unlock();
		}
        //signal is same as notify, it completes whole block abd then release control
	}
	
	public void finished() {
		System.out.println("Final Count = "+count);
	}

}
