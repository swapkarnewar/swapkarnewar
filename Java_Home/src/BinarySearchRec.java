
public class BinarySearchRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5,7,9,12,34,45,67,78,89,98};
		int numToFind = 89;
		//System.out.println(arr.length);
		int returnVal = recursiveBinarySearch(arr,0,arr.length,numToFind);
		if( returnVal < 0 )
		{
			System.out.println("number not found");
		}
		else
			System.out.println("number found @loc = "+(returnVal+1));
	}

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {
        
        if (start < end) {
            int mid = start + (end - start) / 2;  
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);
                 
            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);
                 
            } else {
                return mid;   
            }
        }
        return -(start + 1);  
    }

}
