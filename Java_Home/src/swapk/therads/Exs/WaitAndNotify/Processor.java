package swapk.therads.Exs.WaitAndNotify;

import java.util.Scanner;

public class Processor {

	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread Running....");
			wait();
			/**
			 * this.wait() is fine here
			 * wait will pass control to next thread which has same lock of this object,
			 */
			System.out.println("Producer thread Resume....");
		}
	}

	public void consumer() throws InterruptedException {
		Thread.sleep(100);
		synchronized (this) {
			System.out.println("Consumer thread Running....");
			System.out.println("Waiting for Return press..");
			new Scanner(System.in).nextLine();
			System.out.println("Return key pressed..");
			notify();
			/**
			 * notify will not pass control to wait calling thread,
			 * it will execute all the statements below it until last statment in synchronized block
			 */
			
			Thread.sleep(4000);
		}
	}

}
