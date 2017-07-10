package swapk.Array;

public class Numbers {

	static int c=14;
	static int d=9;
	public static void main(String[] args) {
		int a = 1, b = 4;
		System.out.println(a+" "+b);
		boolean retVal = func(a,b);
		System.out.println(retVal);
	}

	private static boolean func(int a, int b) {
		if( a==c && b==d )
			return true;
		else if( a>c || b>d )
			return false;
		else
			return func(a+b, b) || func(a, a+b);
	}

}
