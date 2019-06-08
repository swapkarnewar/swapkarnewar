package swapk.therads.latest;

public class ThreadBasicExample implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("in t1");
			}
		});
		
		t1.start();

		t1.start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("in t2");
			}
		}).start();
		
		/**
		 * Simple run method will be called, just like any instance method
		 * 
		 */
		/*ThreadBasicExample t3 = new ThreadBasicExample();
		t3.run();*/
		
		
		/**
		 * 3rd thread will start if we execute below
		 */
		/*ThreadBasicExample tbe = new ThreadBasicExample();
		Thread t3 = new Thread(tbe);
		t3.start();*/
	}

	@Override
	public void run() {
		System.out.println("in t3");
	}



}
