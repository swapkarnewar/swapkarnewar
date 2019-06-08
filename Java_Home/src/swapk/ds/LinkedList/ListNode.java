package swapk.ds.LinkedList;

public class ListNode<T> {
	
	private T data;
	private ListNode next;
	
	public ListNode(T data){
		this.data = data;
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public ListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
		
}
