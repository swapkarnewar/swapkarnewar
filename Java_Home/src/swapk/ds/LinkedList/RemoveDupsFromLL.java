package swapk.ds.LinkedList;

import java.util.HashSet;
import java.util.Set;
/*
 * CTCI Q2_01
 */
public class RemoveDupsFromLL extends LinkedListCust {

	public void removeDupsFromLL(){
		
		/*ListNode current = head;
		ListNode previous = null;
		Set<String> nodeSet = new HashSet<String>();
		
		while( current != null ) {
			if( !nodeSet.contains(current.getData()) ) {
				nodeSet.add(current.getData());
				previous = current;
			}
			else {
				previous.setNext(current.getNext());
			}
			current = current.getNext();
		}*/
		
		ListNode current = head;
		while( current != null ) {
			ListNode runner = current;
			while( runner.getNext() != null ) {
				if( current.getData() == runner.getNext().getData() ) {
					runner.setNext(runner.getNext().getNext());
				}
				else {
					runner = runner.getNext();
				}
			}
			current = current.getNext();
		}
		
	}

	public String getDataAtMiddlePosition() {
		if( null == head ) {
			System.out.println("List is Empty.");
			throw new NullPointerException("Node can not be deleted as List is null");
		}
		else if( null == head.getNext() ) {
			return head.getData();
		}
		else {
			ListNode fastPtr = head;
			ListNode slowPtr = head;
			while( fastPtr != null && fastPtr.getNext() != null ) {
				fastPtr = fastPtr.getNext().getNext();
				slowPtr = slowPtr.getNext();
			}
			return slowPtr.getData();
		}
	}
	
}
