package swapk.ds.LinkedList;
import javax.swing.text.Position;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDupsFromLL linkedList = new RemoveDupsFromLL();
		
		
		linkedList.addAtBegining( new ListNode("Swap") );
		linkedList.addAtBegining( new ListNode("Harneesha") );
		linkedList.addAtEnd( new ListNode("test") );
		linkedList.addAtEnd( new ListNode("Nitil") );
		linkedList.addAtEnd( new ListNode("Dinya") );
		linkedList.addAtEnd( new ListNode("Kunal") );
		linkedList.addAtEnd( new ListNode("Sneha") );
		linkedList.addAtGivenPosition( new ListNode("Ram"), 3 );
		linkedList.addAtEnd( new ListNode("Harneesha") );
		linkedList.addAtEnd( new ListNode("Swapnil") );
		linkedList.displayList();
		
		//String dataRemoved = linkedList.deleteAtBegining().getData();
		String dataRemoved = linkedList.deleteAtEnd().getData();
		System.out.println("Node Removed ="+dataRemoved);
		linkedList.displayList();
		
		linkedList.reverseList();
		linkedList.displayList();
		
		String data = linkedList.getDataAtPosition(3);
		System.out.println("Data At Position 3 ="+data);
		
		System.out.println("Length = "+linkedList.getLength());
		System.out.println("Length By Rec = "+linkedList.getLengthRec());
		
		linkedList.removeDupsFromLL();
		linkedList.displayList();
		
		/*String deleteAtPosition = linkedList.deleteAtPosition(3).getData();
		System.out.println("Node Removed ="+deleteAtPosition);
		linkedList.displayList();*/
	}

}
