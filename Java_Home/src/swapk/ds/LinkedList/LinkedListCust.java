package swapk.ds.LinkedList;

//this will suppress warning
//@SuppressWarnings("unchecked")
public class LinkedListCust<T> {
	
	private int length;
	public ListNode<T> head;

	/**
	 * @return the length
	 */
	public int getSize() {
		return length;
	}
	
	public void addAtBegining(ListNode<T> listNode){
		if( null == listNode ){
			throw new NullPointerException("Node can not be added as Node is null");
		}
		else if( null == head ){
			head = listNode;
			length++;
		}
		else{
			listNode.setNext(head);
			head = listNode;
			length++;
		}
	}
	
	public void addAtEnd(ListNode<T> listNode){
		if( null == listNode ){
			throw new NullPointerException("Node can not be added as Node is null");
		}
		else if( null == head ){
			head = listNode;
			length++;
		}
		else{
			ListNode<T> currNode = head;
			while( currNode.getNext() != null ){
				currNode = currNode.getNext();
			}
			currNode.setNext(listNode);
			length++;
		}
	}
	
	public void addAtGivenPosition(ListNode<T> listNode, int position){
		if( position < 0 || position > length)
		{
			System.out.println("Please Enter valid Position.");
			return;
		}
		
		if( null == listNode ){
			throw new NullPointerException("Node can not be added as Node is null");
		}
		else if( null == head || position == 0 ){
			listNode.setNext(head);
			head = listNode;
			length++;
		}
		else{
			ListNode<T> currNode = head;
			for( int iTemp = 1; iTemp < position; iTemp++ )
			{
				currNode = currNode.getNext();
			}
			listNode.setNext( currNode.getNext() );
			currNode.setNext( listNode );
			length++;
		}
	}
	
	public ListNode<T> deleteAtBegining(){
		if( null == head )
		{
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else
		{
			ListNode<T> currNode = head;
			head = head.getNext();
			currNode.setNext(null);
			length--;
			return currNode;
		}
		
	}
	
	public ListNode<T> deleteAtEnd(){
		ListNode<T> currNode = null;
		ListNode<T> removeNode = null;
		if( null == head )
		{
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else
		{
			if( null == head.getNext() ){
				removeNode = head;
				head = null;
			}
			else{
				currNode = head;
				while( currNode.getNext() != null && currNode.getNext().getNext() != null ){
					currNode = currNode.getNext();
				}
				removeNode = currNode.getNext();
				currNode.setNext(null);
			}
			
			length--;
			return removeNode;
		}
		
	}
	
	public ListNode<T> deleteAtPosition( int position ){
		if( position < 0 )
		{
			System.out.println("Please Enter valid Position.");
			throw new NullPointerException("Position less than 0.");
		}
		
		if( position > length )
		{
			System.out.println("Please Enter valid Position. Position is greater than length.");
			throw new NullPointerException("Please Enter valid Position. Position is greater than length.");
		}
		if( null == head )
		{
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else
		{
			ListNode<T> currNode = head;
			for( int iTemp = 1; iTemp < position; iTemp++ )
			{
				currNode = currNode.getNext();
			}
			ListNode<T> removeNode = currNode.getNext();
			currNode.setNext( removeNode.getNext() );
			length--;
			return removeNode;
		}
		
	}
	
	public void reverseList(){
		if( null == head ){
			System.out.println("List is empty");
			return;
		}
		
		ListNode<T> prevToPrev = null;
		ListNode<T> prev = head;
		ListNode<T> currNode = head;
		
		if( currNode != null && currNode.getNext() != null ){
			currNode = currNode.getNext();
		}
		
		while( currNode != null ){
			prevToPrev = prev;
			prev = currNode;
			currNode = currNode.getNext();
			prev.setNext( prevToPrev );
		}
		head.setNext( null );
		head = prev;

	}
	
	public T getDataAtPosition( int position )
	{
		T data = null;
		ListNode<T> temp = null;
		int count = 1;
		if( position > length || position < 1){
			System.out.println("Enter proper position.");
			return data;
		}
		else{
			temp = head;
			while( temp.getNext() != null && count < position ){
				temp = temp.getNext();
				count++;
			}
			data = temp.getData();
		}
		return data;
	}
	public void displayList(){
		if( null == head ){
			System.out.println("List is empty");
		}
		else if( head.getNext() == null )
		{
			System.out.println( head.getData() );
		}
		else{
			ListNode<T> currNode = head;
			
			String result = String.valueOf( currNode.getData() );
			
			while( currNode.getNext() != null ){
				result = result + "-->" + String.valueOf( currNode.getNext().getData() );
				currNode = currNode.getNext();
			}
			System.out.println(result);
		}
	}
	
	public int getLength(){
		ListNode<T> temp = head;
		int count = 0;
		while( temp != null ){
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	public int getLengthRec(){
		return getLengthByRec(head);
	}
	
	private int getLengthByRec( ListNode<T> listNode ){
		if( listNode == null ){
			return 0;
		}
		else{
			listNode = listNode.getNext();
			return 1 + getLengthByRec( listNode );
		}
			
	}
	
	public ListNode<T> getNodeAtPosition( int position )
	{
		ListNode<T> temp = null;
		int count = 1;
		if( position > length || position < 1){
			System.out.println("Enter proper position.");
			return null;
		}
		else{
			temp = head;
			while( temp.getNext() != null && count < position ){
				temp = temp.getNext();
				count++;
			}
		}
		return temp;
	}
	
	/**
	 * http://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
	 * @return
	 */
	public boolean isLoopExists() {
		if( null == head ) {
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else if( null == head.getNext() ) {
			return false;
		}
		else {
			ListNode<T> fastPtr = head;
			ListNode<T> slowPtr = head;
			while( slowPtr != null && fastPtr != null && fastPtr.getNext() != null ) {
				fastPtr = fastPtr.getNext().getNext();
				slowPtr = slowPtr.getNext();
				if( slowPtr == fastPtr )
					return true;
			}
		}
		return false;
	}
	
	public void removeLoopFromLinkedList() {
		if( null == head ) {
			System.out.println("List is Empty. Failed...");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else if( null == head.getNext() ) {
			System.out.println("Only one node is present. Failed...");
		}
		else {
			ListNode<T> fastPtr = head;
			ListNode<T> slowPtr = head;
			while( slowPtr != null && fastPtr != null && fastPtr.getNext() != null ) {
				fastPtr = fastPtr.getNext().getNext();
				slowPtr = slowPtr.getNext();
				if( slowPtr == fastPtr )
					break;
			}
			slowPtr = head;
			while( slowPtr.getNext() != fastPtr.getNext() ) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			fastPtr.setNext(null); //here loop removed
			System.out.println("Removed Loop...");
		}
	}
	
	public ListNode<T> deleteNthNodeFromEnd(int n) {
		ListNode<T> temp = null;
		if( null == head ) {
			System.out.println("List is Empty. Failed...");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else if( null == head.getNext() ) {
			System.out.println("Only one node is present. Failed...");
			return temp;
		}
		else {
			ListNode<T> prevPtr = null;
			ListNode<T> mainPtr = head;
			ListNode<T> refPtr = head;
			for(int i = 1; i <= n; i++ ) {
				refPtr = refPtr.getNext();
			}
			while( refPtr != null ) {
				prevPtr = mainPtr;
				mainPtr = mainPtr.getNext();
				refPtr = refPtr.getNext();
			}
			prevPtr.setNext(mainPtr.getNext());
			return mainPtr;
		}
	}

}
