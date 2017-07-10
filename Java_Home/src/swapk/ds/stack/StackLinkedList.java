package swapk.ds.stack;

import swapk.ds.LinkedList.ListNode;

public class StackLinkedList {
	
	private ListNode top;
	
	public void push( ListNode listNode ){
		if( null == listNode ){
			throw new NullPointerException("Node can not be added as Node is null");
		}
		else if( null == top ){
			top = listNode;
		}
		else{
			listNode.setNext(top);
			top = listNode;
		}
	}
	
	public static void main(String[] args) {

	}

}
