package swapk.ds.LinkedList;

import java.awt.List;

import javax.swing.text.DefaultEditorKit.CutAction;


public class LinkedListCust {
	
	private int length;
	protected ListNode head;

	/**
	 * @return the length
	 */
	public int getSize() {
		return length;
	}
	
	public void addAtBegining(ListNode listNode){
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
	
	public void addAtEnd(ListNode listNode){
		if( null == listNode ){
			throw new NullPointerException("Node can not be added as Node is null");
		}
		else if( null == head ){
			head = listNode;
			length++;
		}
		else{
			ListNode currNode = head;
			while( currNode.getNext() != null ){
				currNode = currNode.getNext();
			}
			currNode.setNext(listNode);
			length++;
		}
	}
	
	public void addAtGivenPosition(ListNode listNode, int position){
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
			ListNode currNode = head;
			for( int iTemp = 1; iTemp < position; iTemp++ )
			{
				currNode = currNode.getNext();
			}
			listNode.setNext( currNode.getNext() );
			currNode.setNext( listNode );
			length++;
		}
	}
	
	public ListNode deleteAtBegining(){
		if( null == head )
		{
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else
		{
			ListNode currNode = head;
			head = head.getNext();
			currNode.setNext(null);
			length--;
			return currNode;
		}
		
	}
	
	public ListNode deleteAtEnd(){
		ListNode currNode = null;
		ListNode removeNode = null;
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
	
	public ListNode deleteAtPosition( int position ){
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
			ListNode currNode = head;
			for( int iTemp = 1; iTemp < position; iTemp++ )
			{
				currNode = currNode.getNext();
			}
			ListNode temp = currNode.getNext();
			currNode.setNext( temp.getNext() );
			length--;
			return temp;
		}
		
	}
	
	public void reverseList(){
		if( null == head ){
			System.out.println("List is empty");
			return;
		}
		
		ListNode prevToPrev = null;
		ListNode prev = head;
		ListNode currNode = head;
		
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
	
	public String getDataAtPosition( int position )
	{
		String data = "";
		ListNode temp = null;
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
			ListNode currNode = head;
			
			String result = String.valueOf( currNode.getData() );
			
			while( currNode.getNext() != null ){
				result = result + "-->" + String.valueOf( currNode.getNext().getData() );
				currNode = currNode.getNext();
			}
			System.out.println(result);
		}
	}
	
	public int getLength(){
		ListNode temp = head;
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
	
	public int getLengthByRec( ListNode listNode ){
		if( listNode == null ){
			return 0;
		}
		else{
			listNode = listNode.getNext();
			return 1 + getLengthByRec( listNode );
		}
			
	}
}
