import java.util.Scanner;


public class CustPOW {

	private static Scanner userInput;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		int b = 0;
		
		userInput = new Scanner( System.in );
		System.out.println("Enter a: ");
		a = userInput.nextInt(); 
		
		System.out.println("Enter b: ");
		b = userInput.nextInt();
		
		int itr = b/2;
		int aPOW2 = a*a;
		int result = 0;
		int endResult = 0;
		
		boolean evenIndicator = false;
		if( b%2 == 0 )
		{
			evenIndicator = true;
		}
		
		if( b == 0  )
			result = 1;
		else if( b == 1 )
		{
			result = a;
		}
		else if( itr == 0 || itr == 1 )
		{
			result = aPOW2;
		}
		else
		{
			for( int i=1; i<=itr-1; i++ )
			{
				result = aPOW2;
				result = aPOW2 * result;
			}
		}
		
		if( evenIndicator )
			endResult = result;
		else
			endResult = result * a;
		
		System.out.println("a^b = "+endResult);
		System.out.println("java function a^b = "+java.lang.Math.pow(a,b));
	}

}
