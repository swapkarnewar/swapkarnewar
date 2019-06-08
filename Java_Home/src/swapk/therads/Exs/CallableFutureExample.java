package swapk.therads.Exs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author SKarnewar
 * Go through http://www.javamadesoeasy.com/2015/03/executor-and-executorservice-framework.html
 * for more details explanation is smooth
 */

class SumIntegerCallable implements Callable<Integer> {

	Integer n;
	
	public SumIntegerCallable(Integer n) {
		this.n = n;
	}
	
	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		Integer sum = 0;
		for(int i = 0; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
}

public class CallableFutureExample {

	private static final int nThreads = 10;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		
		Future<Integer> futureInteger = executor.submit(new SumIntegerCallable(4));
		
		/*
		 * waits for 1 sec and gives result but or result in SumIntegerCallable.call method will be calculated in 0.5 sec, so we will get result
		 */
		System.out.println(" SumIntegerCallable has returned -> " + futureInteger.get(500, TimeUnit.MILLISECONDS));
		
		executor.shutdown();
		System.out.println(" Shutdown called");
	}

}
