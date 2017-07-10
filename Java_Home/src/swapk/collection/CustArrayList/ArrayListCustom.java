package swapk.collection.CustArrayList;

import java.util.Arrays;

public class ArrayListCustom<E> {

	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object elementData[] = {};
	
	public ArrayListCustom(){
		elementData = new Object[INITIAL_CAPACITY];
	}
	
	public boolean add(E data){
		if( size == elementData.length )
			ensureCapacity();
		elementData[size] = data;
		size++;
		return true;
		
	}
	
	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		for( int i = 0; i < elementData.length; i++ ){
			if( elementData[i] != null )
				strBuilder.append(elementData[i]+" ");
		}
		return strBuilder.toString();
	}
	
	private void ensureCapacity() {
		int newIncreasedCapacity = INITIAL_CAPACITY*2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	}
	
	public Object remove(int index){
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		Object removedElement = elementData[index];
		for( int i = index; i < elementData.length - 1; i++ )
			elementData[i] = elementData[i+1];
		return removedElement;
	}
	
	public E get(int index){
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		return (E) elementData[index];
	}

}
