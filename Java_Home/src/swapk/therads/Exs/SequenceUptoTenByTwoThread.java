package swapk.therads.Exs;

import swapk.therads.Exs.SequenceWithThreeThread.SequenceDisplayImpl;

public class SequenceUptoTenByTwoThread {
	
	public static void main(String[] args) throws InterruptedException {

		SharedPrinter sp = new SharedPrinter();
		Thread t1 = new Thread(new EvenNumProducer(sp,10));
		Thread t2 = new Thread(new OddNumProducer(sp,10));
		t1.start();
		t2.start();

		Thread.sleep(5000);
		System.exit(0);
	}
}

class SharedPrinter {

	boolean evenFlag = true;
	
	public void printEvenNum(int num) {
		synchronized (this) {
			while(evenFlag) {
				try {
					wait();
					
				} catch (InterruptedException e) {
					System.out.println("Exception in  printEven---");
					e.printStackTrace();
				}
				System.out.println(num+"\t");
				evenFlag = false;
				notify();
			}
		}
	}
	
	public void printOddNum(int num) {
		synchronized (this) {
			while(!evenFlag) {
				try {
					wait();
					
				} catch (InterruptedException e) {
					System.out.println("Exception in  printOdd---");
					e.printStackTrace();
				}
				System.out.println(num+"\t");
				evenFlag = true;
				notify();
			}
		}
	}
	
}

class EvenNumProducer implements Runnable{
	
	SharedPrinter sp;
	int max;
	
	public EvenNumProducer(SharedPrinter sp, int max) {
		this.sp = sp;
		this.max = max;
	}
	
	@Override
	public void run() {
		for(int i = 2; i <= max; i = i+2) {
			sp.printEvenNum(i);
		}
	}
	
}


class OddNumProducer implements Runnable{

	SharedPrinter sp;
	int max;
	
	public OddNumProducer(SharedPrinter sp, int max) {
		this.sp = sp;
		this.max = max;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= max; i = i+2) {
			sp.printOddNum(i);
		}
	}
	
}