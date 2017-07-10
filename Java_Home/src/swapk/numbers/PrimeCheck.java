package swapk.numbers;

public class PrimeCheck {

	public static void main(String[] args) {
		
		int n = 23;
		boolean isPrime = isNumberPrimeSqrtChk(n);
		
		if( isPrime )
			System.out.println("prime");
		else
			System.out.println("not prime");
		
		
		//Display the prime number till 100
		for( int i = 2; i < 100; i++ )
		{
			if( isNumberPrimeSqrtChk(i) )
				System.out.println(i);
		}
		
	}
	
	//O(N)
	public static boolean isNumberPrime( int n ){
		boolean isPrime = true;
		for ( int i = 2; i <= n/2; i++ ){
			if( n%i == 0 ){
				return false;
			}
		}
		return isPrime;
	}
	
	//O(sqrt(n))
	public static boolean isNumberPrimeSqrtChk( int n ){
		//loop is up to square root of n, SO O(sqrt(n))
		for( int i = 2; i * i <= n; i++ ){
			if( n%i == 0 )
				return false;
		}
		return true;
	}

}
