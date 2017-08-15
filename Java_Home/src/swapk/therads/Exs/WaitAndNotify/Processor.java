package swapk.therads.Exs.WaitAndNotify;

import java.util.Scanner;

public class Processor {

	//static Integer counter = 0;
	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread Running....");
			/*while( counter < 10 ) {
				System.out.println(counter);
				wait();
			}*/
			this.wait();
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
			/*while( counter < 10 ) {
				System.out.println(++counter);
				notify();
			}*/
			//this.wait();
			this.notify();
			/**
			 * notify will not pass control to wait calling thread,
			 * it will execute all the statements below it until last statment in synchronized block
			 */
			System.out.println("Harneesha");
			Thread.sleep(4000);
		}
	}
	
	public void aloneMethod() throws InterruptedException {
		Thread.sleep(200);
		synchronized (this) {
			System.out.println("I m in alone method with Harneesha");
			//this.notify();
			System.out.println("I m still here");
		}
		
	}

}
