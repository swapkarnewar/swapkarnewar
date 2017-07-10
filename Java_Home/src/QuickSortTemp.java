
public class QuickSortTemp {

	public static void main(String[] args) {
		int [] arr = { 38,27,43,3,9,82,10 };
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
		
		quicksort(arr, 0, arr.length-1);
		
		System.out.println("\nafter sort :- ");
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
	}

	public static void quicksort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		int pivote = arr[(left+right)/2];
		int index = partition(arr, left, right, pivote);
		quicksort(arr, left, index-1);//have to give -1, see this in merge sort also - IMP otherwise gives error
		quicksort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right, int pivote) {
		while(left <= right) {
			while(arr[left] < pivote)
				left++;
			while(arr[right] > pivote)
				right--;
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
