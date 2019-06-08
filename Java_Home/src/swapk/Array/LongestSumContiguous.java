package swapk.Array;

/**
 * This is Kendane's Algoritham
 * https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
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
			currMax = Integer.max(currMax, 0);
			sumMax = Integer.max(currMax, sumMax);
		}
		
		System.out.println("Largest sum of contiguous subarray is "+sumMax);
		
	}

}
