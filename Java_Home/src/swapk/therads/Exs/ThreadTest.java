package swapk.therads.Exs;

class ThreadTest1 extends Thread {

	public void run() {
		System.out.println("in thread");
	}
	
}

public class ThreadTest {

	public static void main(String[] args) {
		ThreadTest1 t = new ThreadTest1();
		t.start();
	}
	
}
