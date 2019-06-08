package swapk.numbers;

public class FibTest {

	public static void main(String[] args) {
		int n = 8;
		fib(n);
	}

	private static void fib(int n) {
		int fib0 = 0;
		int fib1 = 1;
		int fibn = 0;
		
		System.out.println(fib0);
		System.out.println(fib1);
		
		for( int i = 2; i < n; i++ ) {
			fibn = fib0 + fib1;
			System.out.println(fibn);
			fib0 = fib1;
			fib1 = fibn;
		}
	}
	
	
	//private static void fibMem(n)

}
