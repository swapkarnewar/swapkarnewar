package swapk.Array;

public class ArrayReversal {
	
	public static void main(String a[]){
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		//Simple way O(N)
		/*for(int i=arr.length -1; i>=0; i--)
		{
			System.out.print(arr[i] + " ");
		}*/
		
		//O(log N)
		for( int i = 0, j = arr.length-1; i <= (arr.length-1)/2; i++,j-- ) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}//10 9 8 7 6 5 4 3 2 1 
		
		for( int j=0; j<=arr.length-1; j++ )
			System.out.print(arr[j]+" ");
		
	}

}