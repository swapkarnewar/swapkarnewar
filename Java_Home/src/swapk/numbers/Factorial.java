package swapk.numbers;

public class Factorial {

	public static void main(String[] args) {
		
		int n = 5;
		int facorial = findFacorialRec(n);
		int facorial1 = findFact(n);
		System.out.println(facorial1);

	}

	//O(N)
	private static int findFacorialRec(int n) {
		if( n == 0 )
			return 1;
		else if( n == 1)
			return 1;
		else
			return n * findFacorialRec( n-1 );
	}
	
	//O(N)
	public static int findFact( int n ){
		int fact = 1;
		for( int i = 1; i <= n; i++ )
			fact = fact*i;
		return fact;
	}

}
