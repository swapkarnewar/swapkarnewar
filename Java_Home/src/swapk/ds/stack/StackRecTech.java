package swapk.ds.stack;

import java.util.Stack;

/**
 * Recursive stack operations
 * only push(), pop(), peek() should be used
 * 
 * http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * 
 * @author SKarnewar
 *
 */
public class StackRecTech extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		StackRecTech st = new StackRecTech();
		st.push(10);
		st.push(6);
		st.push(7);
		st.push(8);
		System.out.println(st);
		/**
		 * remove and add all the elements in stack with using recursion.
		 */
		removeAndAdd(st);
		System.out.println("after removeAndAdd : "+st);
		
		/**
		 * remove and add all the elements in stack with reverse order using recursion.
		 * reverse() with recursion
		 */
		reverse(st);
		System.out.println("after reverse : "+st);
		
		/**
		 * remove and add all the elements in stack with sorted order using recursion.
		 * reverse() with recursion
		 */
		sort(st);
		System.out.println("after reverse : "+st);
	}

	private static void sort(StackRecTech st) {
		if( !st.isEmpty() ){
			int a = st.peek();
			//removing all the elements with pop
			st.pop();
			sort(st);
			//after all the elements are removed push them again with in stack with proper order i.e in sorted order
			sortedInsert(st,a);
		}
	}

	private static void sortedInsert(StackRecTech st, int a) {
		if( st.isEmpty() || a > st.peek() ) {
			st.push(a);
		}
		else {
			int x = st.peek();
			st.pop();
			sortedInsert(st,a);
			st.push(x);
		}
	}

	private static void reverse(StackRecTech st) {
		if( !st.isEmpty() ){
			int a = st.peek();
			//removing all the elements with pop
			st.pop();
			reverse(st);
			//after all the elements are removed push them again with reverse order i.e insert them @ bottom
			insertAtBottom(st,a);
		}
	}

	private static void insertAtBottom(StackRecTech st, int a) {
		if( st.isEmpty() ) {
			st.push(a);
		}
		else {
			int x = st.peek();
			st.pop();
			insertAtBottom(st, a);
			st.push(x);
		}
	}

	private static void removeAndAdd(StackRecTech st) {
		if( !st.isEmpty() ){
			int a = st.peek();
			//removing all the elements with pop
			st.pop();
			removeAndAdd(st);
			//after all the elements are removed push them again
			st.push(a);
		}
	}

}
