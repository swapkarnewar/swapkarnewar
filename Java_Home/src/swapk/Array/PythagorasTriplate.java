package swapk.Array;
import java.util.Arrays;


public class PythagorasTriplate extends Zaffran
{

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		int arr[] = {1,3,7,5,4};
		int n = arr.length;
		System.out.println(n);
		for( int i = 0; i < n ; i++){
			arr[i] = arr[i]*arr[i];
		}
		Arrays.sort(arr);
		for( int i = 0; i < n ; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
		for( int i=n-1; i>=2; i-- ){
			int l = 0;
			int r = i-1;
			while( l<r ){
				
				if( arr[l]+arr[r] == arr[i] ){
					System.out.println(arr[i]+" "+arr[l]+" "+arr[r]);
					System.out.println("true: triplate found..");
					break;
				}
				if( arr[l]+arr[r] < arr[i] ){
					l++;
				}
				else{
					r--;
				}
			}
		}
		
	}

	@Override
	public void displayName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int returnInteger() {
		// TODO Auto-generated method stub
		return 0;
	}

}

abstract class Zaffran implements ZaffranInterface
{ 

	public String returnString() 
	{
		return "swapnil";
	}
	
	public abstract int returnInteger();
	
}
