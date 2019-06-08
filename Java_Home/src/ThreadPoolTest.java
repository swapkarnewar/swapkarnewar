import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {

	private LinkedBlockingQueue<Runnable> queue;
	
	public ThreadPool(int nThreads) {
		queue = new LinkedBlockingQueue<Runnable>(nThreads);
		for( int i = 0; i <= nThreads; i++ ) {
			ThreadPoolsThread tpt = new ThreadPoolsThread(queue, this);
			System.out.println("Thread-"+i +" created in ThreadPool.");
			tpt.start();
		}
	}

	public void execute(Runnable task) throws InterruptedException {
		this.queue.put(task);
	}
	
}

class ThreadPoolsThread extends Thread {
	private LinkedBlockingQueue<Runnable> taskQueue;
	private ThreadPool threadPool;
	
	public ThreadPoolsThread(LinkedBlockingQueue<Runnable> queuePassed, ThreadPool threadPool2) {
		taskQueue = queuePassed;
		threadPool = threadPool2;
	}
	
	@Override
	public void run() {
			try{
				while(true) {
					Runnable runnable = taskQueue.take();
					runnable.run();
					
					if( this.taskQueue.size()==0 ) {
						this.interrupt();
					}
				}
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
}

class Task implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" is executing task.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool 
		Runnable task=new Task();
		threadPool.execute(task);
		threadPool.execute(task);
	}

}
