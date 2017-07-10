package swapk.sorting;

public class BubbleSortTech {

	public static int[] bubbleSort(int[] arr) {
		
		for( int i = 0; i <= arr.length-1; i++ ) {
			for( int j = 0; j < arr.length-1-i; j++ ) {
				if( arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;//in each iteration we will get largest @ end of array, So after each iteration we are eliminating the last element as" j < arr.length-1-i "
				}
			}
		}
		
		return arr;
	}

}
