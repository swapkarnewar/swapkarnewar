package swapk.ds.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDupsFromLL<String> linkedList = new RemoveDupsFromLL<>();
		
		
		linkedList.addAtBegining( new ListNode<String>("Swap") );
		linkedList.addAtBegining( new ListNode<String>("Harneesha") );
		linkedList.addAtEnd( new ListNode<String>("test") );
		linkedList.addAtEnd( new ListNode<String>("Nitil") );
		linkedList.addAtEnd( new ListNode<String>("Dinya") );
		linkedList.addAtEnd( new ListNode<String>("Kunal") );
		linkedList.addAtEnd( new ListNode<String>("Sneha") );
		linkedList.addAtGivenPosition( new ListNode<String>("Ram"), 3 );
		linkedList.addAtEnd( new ListNode<String>("Harneesha") );
		linkedList.addAtEnd( new ListNode<String>("Swapnil") );
		linkedList.displayList();
		
		//String dataRemoved = linkedList.deleteAtBegining().getData();
		String dataRemoved = (String) linkedList.deleteAtEnd().getData();
		System.out.println("Node Removed ="+dataRemoved);
		linkedList.displayList();
		
		linkedList.reverseList();
		linkedList.displayList();
		
		String data = (String) linkedList.getDataAtPosition(3);
		System.out.println("Data At Position 3 ="+data);
		
		System.out.println("Length = "+linkedList.getLength());
		System.out.println("Length By Rec = "+linkedList.getLengthRec());
		
		linkedList.removeDupsFromLL();
		linkedList.displayList();
		
		/*String deleteAtPosition = linkedList.deleteAtPosition(3).getData();
		System.out.println("Node Removed ="+deleteAtPosition);
		linkedList.displayList();*/
		
		//Middle by traversing full list
		System.out.println("Data at middle : "+linkedList.getDataAtPosition(linkedList.getLength()/2));
		
		//Middle by fast pointer and slow pointer
		System.out.println("Data at middle by fpsp :"+linkedList.getDataAtMiddlePosition());
		linkedList.getNodeAtPosition(linkedList.getLength()).setNext(linkedList.getNodeAtPosition(linkedList.getLength()/2));
		
		/**
		 * Detect a loop
		 * http://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
		 * and if loop is there remove it
		 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
		 */
		boolean isLoopExists = linkedList.isLoopExists();
		if( isLoopExists ) {
			linkedList.removeLoopFromLinkedList();
		}
		linkedList.displayList();
		
		/**
		 * delete n th node form end of linked list
		 * http://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
		 */
		System.out.println("deleted 3rd from end of list : "+linkedList.deleteNthNodeFromEnd(3).getData());
		linkedList.displayList();
	}

}
