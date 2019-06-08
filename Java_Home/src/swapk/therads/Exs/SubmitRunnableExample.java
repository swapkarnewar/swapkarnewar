package swapk.therads.Exs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author SKarnewar
 * Go through http://www.javamadesoeasy.com/2015/03/executor-and-executorservice-framework.html
 * for more details explanation is smooth
 */

class MyRunnable_1 implements Runnable {

	@Override
	public void run() throws ArithmeticException{
		System.out.println("in run mehtod");
		//int a = 1/0;
	}
	
}

class MyCallable implements Callable<Integer> {

	int intVal;
	
	public MyCallable(int intVal) {
		this.intVal = intVal;
	}
	
	@Override
	public Integer call() throws Exception {
		return intVal*intVal;
	}

}

public class SubmitRunnableExample {

	private static final int NTHREDS = 10;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		Future<Integer> future = executor.submit(new MyRunnable_1(), 1);//*
		System.out.println("future.get() with result-: "+future.get());
		
		Future<?> future1 = executor.submit(new MyRunnable_1());//**
		System.out.println("future.get() with no result-: "+future1.get());
		//this futureInteger.get() will wait for run() from MyRunnable_1 to complete.
		//Submits a Runnable task for execution. Method returns a Future which represents that task. 
		//Once task is completed Future's get method will return the given result* **.
		
		Future<Integer> futureInteger=executor.submit(new MyCallable(4));
		System.out.println("MyCallable has returned > "+futureInteger.get());
		//this futureInteger.get() will wait untill call() from MyCallable was complete. after completion only this get will call.
		//this get will give result from call() 
		
		//unlike submission of runnable task, there which ever result is passes that we can get in get method.

	}

}
