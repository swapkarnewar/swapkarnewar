package swapk.Array;

/**
 * This is Kendane's Algoritham
 * @author SKarnewar
 *
 */
public class LongestSumContiguous {

	public static void main(String[] args) {
		
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int sumMax = 0;
		int currMax = 0;
		
		for( int i = 0; i < arr.length - 1; i++ ) {
			currMax = currMax + arr[i];
			if( currMax < 0 ) {
				currMax = 0;
			}
			else if( sumMax < currMax ) {
				sumMax = currMax;
			}
		}
		
		System.out.println("Largest sum of contiguous subarray is "+sumMax);
		
	}

}
