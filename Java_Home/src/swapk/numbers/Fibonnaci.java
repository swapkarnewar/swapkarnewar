package swapk.numbers;

public class Fibonnaci {
	
	public static void main(String a[]){
		int n = 7;
		
		int[] memo = new int[n+1];
		/*for( int i = 0; i < 7; i++ )
			System.out.println(i+": "+fibRec(i));*/

		/*for( int i = 1; i <= n; i++ )
			System.out.println(i+": "+fibRecCache(i, memo));*/
	
		fib(7);
	}
	
	//O(N), we need to optimise So use memory tech, cache
	private static int fibRecCache(int n, int [] memo) {
		if( n <= 0 )
			return 0;
		else if( n == 1 )
			return 1;
		else if( memo[n] > 0 )
			return memo[n];
		
		memo[n] = fibRecCache(n-1, memo) + fibRecCache(n-2, memo);
		return memo[n];
	}
	
	//O(2^n)
	private static int fibRec(int n) {
		if( n <= 0 )
			return 0;
		else if( n == 1 )
			return 1;
		else
			return fibRec(n-1) + fibRec(n-2);
	}
	
	private static void fib(int n){
		int fib1 = 1;
		int fib2 = 1;
		
		System.out.println(fib1);
		System.out.println(fib2);
		
		for( int i = 2; i < n; i++){
			int fibn = fib1 + fib2;
			System.out.println(fibn);
			fib1 = fib2;
			fib2 = fibn;
		}
	}

}
