package swapk.ds.Heaps;

import java.util.Arrays;

public class MinHeap {

	private int capacity = 10;
	private int size = 0;
	
	private int[] items = new int[capacity];
	
	//getters for left child index, right child index and parent node index
	private int getLeftChildIndex(int parentIndex) {	return parentIndex*2 + 1;	}
	
	private int getRightChildIndex(int parentIndex) {	return parentIndex*2 + 2;	}
	
	private int getParentIndex(int childIndex) {	return (childIndex - 1) / 2;	}
	
	//check if the left, right or parent is there for the element @ particular index
	private boolean hasLeftChild(int index) {	return getLeftChildIndex(index) < size;	}
	
	private boolean hasRightChild(int index) {	return getRightChildIndex(index) < size;	}
	
	private boolean hasParent(int index) {	return getParentIndex(index) >= 0;	}
	
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
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if( size == 0 ) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if( size == 0 ) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while( hasParent(index) && getParent(index) > items[index] ) {
			swap( getParentIndex(index), index );
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while( hasLeftChild(index) ) {
			int smallerChildIndex = getLeftChildIndex(index);
			if( hasRightChild(index) && getRightChild(index) < getLeftChild(index) ) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if( items[index] < items[smallerChildIndex] ) {
				break;
			}
			else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}

	@Override
	public String toString() {
		return "MinHeap [items=" + Arrays.toString(items) + "]";
	}
	
}
