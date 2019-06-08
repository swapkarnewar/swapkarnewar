package swapk.therads.Exs;

import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public ThreadPool(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedBlockingQueue<>();
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {
		@Override
		public void run() {
			Runnable task;

			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("An error occurred while queue is waiting: " + e.getMessage());
						}
					}
					task = queue.poll();
				}

				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}
}

class Task implements Runnable {

	private int num;

	public Task(int n) {
		num = n;
	}

	@Override
	public void run() {
		System.out.println("Task " + num + " is running.");
	}
}

public class ThreadPoolTest {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(7);

		for (int i = 0; i < 5; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
	}
}