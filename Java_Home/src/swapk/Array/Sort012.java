package swapk.Array;

public class Sort012 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
	    int arr_size = arr.length;
	    sort012(arr, arr_size);
	    System.out.println("Array after seggregation ");
	    printArray(arr, arr_size);
	    
	    sortByOwnTech(arr, arr_size);
	    System.out.println("Array after own tech ");
	    printArray(arr, arr_size);
	}
	
	static void sort012(int a[], int arr_size)
	{
	    int low = 0;
	    int high = arr_size - 1;
	    int mid = 0,temp=0;
	    while (mid <= high)
	    {
	    	switch (a[mid])
	    	{
	        	case 0:
	        	{
	        		temp   =  a[low];
	        		a[low]  = a[mid];
	        		a[mid] = temp;
	        		low++;
	        		mid++;
	        		break;
	        	}
	        	case 1:
	        		mid++;
	        		break;
	        	case 2:
	        	{
	        		temp = a[mid];
	        		a[mid] = a[high];
	        		a[high] = temp;
	        		high--;
	        		break;
	        	}
	    	}
	    }
	}
	
	static void printArray(int arr[], int arr_size)
	{
		for (int i = 0; i < arr_size; i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
	}
	
	static void sortByOwnTech(int arr[], int arr_size){
		
		int l = 0;
		int h = arr_size-1;
		int RM1 = arr_size-1;
		boolean RM1Count = true;
		while( l < h && h < RM1 && l < RM1) {
			while( l == 0 )
				l++;
			while( h == 2 )
				h--;
			while( h == 1 ) {
				if( RM1Count ) {
					RM1 = h;
					RM1Count = false;
				}
				h--;
			}
			if( arr[h] == 0 && ( arr[l] == 1 || arr[l] == 2 ) ) {
				swap(arr, h, l);
			}
			if( arr[h] == 1 && arr[l] == 2 ) {
				swap(arr, h, l);
			}
			if( arr[h] == 2 && h < RM1 ) {
				swap(arr, h, RM1);
				RM1--;
			}
		}
	}

	private static void swap(int[] arr, int h, int l) {
		int temp = 0;
		temp = arr[h];
		arr[h] = arr[l];
		arr[l] = temp;
	}
}
