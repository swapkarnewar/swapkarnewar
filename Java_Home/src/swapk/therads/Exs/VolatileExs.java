package swapk.therads.Exs;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;
	
	public void run() {
		
		while(running) {
			System.out.println("hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdownThread() {
		running = false;
	}
}

public class VolatileExs {

	public static void main(String[] args) {
		
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop thread...");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		proc1.shutdownThread();
		
	}

}
