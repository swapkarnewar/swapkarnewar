//TODO
class Parent {
	//Child display( int i ) {
	Parent display( int i ) {
		System.out.println("Parent");
		return null;
	}
}
//TODO
class Child extends Parent {
	Parent display( int i ) {
		System.out.println("Child");
		return null;
	}
}

class TestQ implements Runnable {
	int x,y;
	public void run(){
		for( int i = 0; i < 1000; i ++ ) {
			synchronized (this) {
				x = 12;
				y = 12;
			}
			System.out.println(x + " " + y + " ");
		}
	}
}
public class DBConn {


	public static void main(String [] args) {
		TestQ r = new TestQ();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}
