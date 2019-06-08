package swapk.therads.Exs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {

	int taskNumber;
	
	MyRunnable(int taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing task : "+taskNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class ExecutorServiceExample {
	
	private static int nThreads = 2;
	
	private static int nTasks = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		
		System.out.println("executor created with 2 threads.");
 
		System.out.println("2 threads in executor will be used for executing 10 tasks. "
          + "So, at a time only 2 tasks will be executed");
		
		for (int i = 1; i <= nTasks; i++) {
			Runnable task = new MyRunnable(i);
			executor.execute(task);
		}
		executor.shutdown();
		System.out.println("executor shut down has been called");
	}

}
