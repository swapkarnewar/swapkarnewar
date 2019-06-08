package swapk.therads.latest;

public class VolatileExample {
	
	public static int x, y;
	
	static void method1() {
		x++; y++;
	}
	
	static void method2() {
		System.out.println(x + " " + y);
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i <= 10; i++) {
					method1();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i <= 10; i++) {
					method2();
				}
			}
		});
		
		t1.start();
		t2.start();

	}

}
