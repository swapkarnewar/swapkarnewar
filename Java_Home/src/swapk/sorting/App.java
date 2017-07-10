package swapk.sorting;

public class App {

	public static void main(String[] args) {
		
		int [] arr = { 38,27,43,3,9,82,10 };
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
		
		//arr = BubbleSortTech.bubbleSort(arr);
		
		//arr = QuickSortTech.quickSort(arr, 0, arr.length-1);
		
		arr = MergeSortTech.mergeSort(arr, 0, arr.length-1);
				
		System.out.println();
		System.out.println("After Sorting :");
		
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
		
	}
	
	

}
