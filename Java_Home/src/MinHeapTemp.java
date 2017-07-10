import java.util.Arrays;


public class MinHeapTemp {

	private int capacity = 10;
	private int size = 0;
	int [] items = new int[capacity];

	//getter and setters for left, right and parent index
	private int getLeftChildIndex(int parentIndex) {
		return ((parentIndex*2)+1);
	}

	private int getRightChildIndex(int parentIndex) {
		return ((parentIndex*2)+2);
	}

	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}

	//getter and setter for check whether there exists left / right child / parent
	private boolean hasLeftChild( int index ) {
		return (getLeftChildIndex(index) < size);
	}

	private boolean hasRightChild( int index ) {
		return (getRightChildIndex(index) < size);
	}

	private boolean hasParent( int index ) {
		return (getParentIndex(index) >= 0);
	}

	//getters for getting left child, right child or parent for the element @ particular index
	private int getLeftChild(int index) {	return items[getLeftChildIndex(index)];	}

	private int getRightChild(int index) {	return items[getRightChildIndex(index)];	}

	private int getParent(int index) {	return items[getParentIndex(index)];	}

	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureCapacity() {
		if( size == capacity ) {
			items = Arrays.copyOf(items, 2*capacity);
			capacity = 2 * capacity;
		}
	}
	
	private void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while( hasParent(index) && getParent(index) > items[index] ) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private int poll() {
		if( size == 0 ) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() {
		int index = 0;
		while( hasLeftChild(index) ) {
			int smallerIndex = getLeftChildIndex(index);
			if( hasRightChild(index) && getRightChild(index) < getLeftChild(index) )
				smallerIndex = getRightChildIndex(index);
			
			if( items[index] < items[smallerIndex] ) {
				break;
			}
			else {
				swap(index, smallerIndex);
			}
			index = smallerIndex;
		}
	}
	
	@Override
	public String toString() {
		return "MinHeap [items=" + Arrays.toString(items) + "]";
	}

	public static void main(String[] args) {
		int[] arr = {15,20,10,8,17};
		MinHeapTemp minHeap = new MinHeapTemp();
		
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
