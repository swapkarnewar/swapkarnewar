package swapk.sorting;

public class MergeSortTech {

	public static int[] mergeSort(int[] arr, int left, int right) {
		if( left >= right ) {
			return arr;
		}
		// Find the middle point
		int middle = (left + right) / 2;
		
		// Sort first and second halves -> 
		mergeSort(arr, left, middle);//have to give +1 below, see this in quick sort also - IMP otherwise gives error
		mergeSort(arr, middle+1, right);
		
		//merge the sorted halfs
		merge(arr, left, middle, right);
		
		return arr;
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		
		//find the size of two sub arrays
		int size1 = middle - left + 1;
		int size2 = right - middle;
		
		//create two temp arr
		int L[] = new int [size1];
        int R[] = new int [size2];
        
        /*Copy data to temp arrays*/
        for(int i=0; i<size1; ++i)
            L[i] = arr[left + i];
        for(int j=0; j<size2; ++j)
            R[j] = arr[middle + 1 + j];
		
        //initial indices for these 2, i and j
        int i = 0;
        int j = 0;
        
        //initial index of merged subarr
        int k = left;
        
        //actual merge happens here
        while( i < size1 && j < size2 ) {
        	if( L[i] < R[j] ) {
        		arr[k] = L[i];
        		i++;
        	}
        	else {
        		arr[k] = R[j];
        		j++;
        	}
        	k++;
        }
        
        //copy the remaining items in arr
        while( i < size1 ) {
        	arr[k] = L[i];
        	i++;
        	k++;
        }
        while( j < size2 ) {
        	arr[k] = R[j];
        	j++;
        	k++;
        }
	}

}
