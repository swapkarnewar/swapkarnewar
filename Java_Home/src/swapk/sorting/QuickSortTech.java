package swapk.sorting;

public class QuickSortTech {

	public static int[] quickSort(int[] arr, int left, int right) {
		
		if( left >= right ) {
			return arr;
		}
		int pivot = arr[(left+right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index-1);//have to give -1, see this in merge sort also - IMP otherwise gives error
		quickSort(arr, index, right);
		return arr;
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		
		while( left <= right ) {
			while( arr[left] < pivot ) {
				left++;
			}
			
			while( arr[right] > pivot ) {
				right--;
			}
			
			if( left <= right ) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		
		int temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;
		
	}

}
