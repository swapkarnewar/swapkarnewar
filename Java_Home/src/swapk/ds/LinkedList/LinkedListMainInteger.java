package swapk.ds.LinkedList;

/**
 * http://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/
 * @author SKarnewar
 *
 */
public class LinkedListMainInteger extends LinkedListCust<Integer> {

	public static void main(String[] args) {
		LinkedListMainInteger linkedList = new LinkedListMainInteger();
		
		linkedList.addAtBegining( new ListNode<Integer>(1) );
		linkedList.addAtBegining( new ListNode<Integer>(45) );
		linkedList.addAtEnd( new ListNode<Integer>(34) );
		linkedList.addAtEnd( new ListNode<Integer>(98) );
		linkedList.addAtEnd( new ListNode<Integer>(37) );
		linkedList.addAtEnd( new ListNode<Integer>(57) );
		linkedList.addAtEnd( new ListNode<Integer>(544) );
		linkedList.addAtGivenPosition( new ListNode<Integer>(56), 3 );
		linkedList.addAtEnd( new ListNode<Integer>(12) );
		linkedList.addAtEnd( new ListNode<Integer>(9) );
		linkedList.displayList();
		System.out.println("size : " +linkedList.getLength());
		System.out.println("node @ 1 : " +linkedList.getNodeAtPosition(1).getData());
		System.out.println("last node : " +linkedList.getNodeAtPosition(linkedList.getLength()).getData());
		LinkedListCust<Integer> newLinkedList = linkedList.partitionLinkedListAroundNumber(40);
		newLinkedList.displayList();
		System.out.println(newLinkedList.getLength());
	}
	
	public LinkedListCust<Integer> partitionLinkedListAroundNumber(int n) {
		LinkedListCust<Integer> smallerList = new LinkedListCust<Integer>();
		LinkedListCust<Integer> greaterList = new LinkedListCust<Integer>();
		LinkedListCust<Integer> equalList = new LinkedListCust<Integer>();
		
		if( null == head ) {
			System.out.println("List is Empty. Failed...");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else if( null == head.getNext() ) {
			System.out.println("Only one node is present. Failed...");
			return null;
		}
		else {
			ListNode<Integer> curr = head;
			while( curr != null ) {
				int data = curr.getData();
				if( data < n ) {
					smallerList.addAtEnd(new ListNode<Integer>(data));
				}
				else if( data > n ) {
					greaterList.addAtEnd(new ListNode<Integer>(data));
				}
				else {
					equalList.addAtEnd(new ListNode<Integer>(data));
				}
				curr = curr.getNext();
			}
			
			if( smallerList.getLength() == 0 ) {
				if( equalList.getLength() == 0 ) {
					return greaterList;
				}
				else {
					return concatList(equalList,greaterList);
				}
			}
			
			if( equalList.getLength() == 0 ) {
				if( smallerList.getLength() == 0 ) {
					return greaterList;
				}
				else {
					return concatList(smallerList,greaterList);
				}
			}
			
			if( greaterList.getLength() == 0 ) {
				if( smallerList.getLength() == 0 ) {
					return equalList;
				}
				else {
					return concatList(smallerList,equalList);
				}
			}
		}
		return null;
	}
	

	public LinkedListCust<Integer> concatList(
			LinkedListCust<Integer> firstList, LinkedListCust<Integer> secondList ) {
		firstList.getNodeAtPosition(firstList.getLength()).setNext(secondList.getNodeAtPosition(1));
		return firstList;
	}
}
