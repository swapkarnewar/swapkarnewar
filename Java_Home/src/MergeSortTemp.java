
public class MergeSortTemp {

	public static void main(String[] args) {
		int [] arr = { 38,27,43,3,9,82,10 };
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("\n after sort:-");
		for( int i = 0; i <= arr.length -1; i++ )
			System.out.print(arr[i]+" ");
		
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		
		int middle = (left+right)/2;
		
		mergeSort(arr, left, middle);//have to give +1 below, see this in quick sort also - IMP otherwise gives error
		mergeSort(arr, middle+1, right);
		
		merge(arr, left, right, middle);
	}

	private static void merge(int[] arr, int left, int right, int middle) {
		int size1 = middle - left + 1;
		int size2 = right - middle;
		
		int [] L = new int[size1];
		int [] R = new int[size2];
		
		for(int i=0; i<size1; i++) {
			L[i] = arr[left+i];
		}
		
		for(int j=0; j<size2; j++) {
			R[j] = arr[middle+1+j];
		}
		
		int i = 0,j = 0;
		int k = left;
		
		while(i<size1 && j<size2) {
			if(L[i] < R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < size1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < size2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
