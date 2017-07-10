package swapk.ds.LinkedList;

import java.util.HashSet;

public class RemoveDupsFromLL extends LinkedListCust {

	public void removeDupsFromLL(){
		ListNode curr = head;
		ListNode prev = null;
		HashSet<String> set = new HashSet<>();
		
		while( curr != null ){
			if( set.contains(curr.getData()) ){
				prev.setNext(curr.getNext());
			}
			else{
				set.add(curr.getData());
				prev = curr;
			}
			curr = curr.getNext();
		}
	}
	
}
