package swapk.sorting;

import java.util.Arrays;
import swapk.ds.Heaps.MinHeap;

/**
 * @author skarnewar
 * This calls swapk.ds.Heaps.MinHeap
 * add method to add the elements in heap
 * And calls the poll method to get the lowest element as its the min heap
 * 
 */
public class HeapSortApp {
	
	public static void main(String[] args) {
		int[] arr = {15,20,10,8,17};
		MinHeap minHeap = new MinHeap();
		
		System.out.println("arr need to be sort");
		for(int i = 0; i <= arr.length - 1; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		
		for(int i = 0; i <= arr.length - 1; i++ ) {
			minHeap.add(arr[i]);
		}
		System.out.println("arr after adding in minHeap");
		System.out.println(minHeap);
		
		
		for(int i = 0; i <= arr.length - 1; i++ ) {
			arr[i] = minHeap.poll();
		}
		System.out.println("Sorted arr is");
		System.out.println(Arrays.toString(arr));
		
	}

}
