package swapk.Array;

import java.util.Arrays;

public class TripletForGivenSum {

	public static void main(String[] args) {
		
		int [] arr = { 1, 4, 45, 6, 10, 8, 2, 19 };
		int sum = 22;
		Arrays.sort(arr);
		
/*		for( int i = 0; i < arr.length; i++ )
			System.out.print(arr[i]+" ");*/
		
		for( int i = 0; i < arr.length; i++ ){
			int l = i + 1;
			int r = arr.length - 1;
			while( l < r ){
				if( arr[i]+arr[l]+arr[r] == sum ){
					System.out.println("triplate found : "+arr[i]+" "+arr[l]+" "+arr[r]);
					break;
				}
				else if( arr[i]+arr[l]+arr[r] < sum ){
					l++;
				}
				else{
					r--;
				}
			}
		}
	}

}
