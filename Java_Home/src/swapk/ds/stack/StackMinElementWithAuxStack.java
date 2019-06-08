package swapk.ds.stack;

/**
 * http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 * min() of this stack will return current minimum element of the stack
 * time complexity : O(1)
 * space complexity : O(n) - since we have created one auxiliary stack
 */
import java.util.Stack;

public class StackMinElementWithAuxStack extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5659180835734299227L;

	Stack<Integer> min = new Stack<Integer>();
	
	public void push(int x) {
		
		if( isEmpty() == true) {
			super.push(x);
			min.push(x);
		}
		else {
			super.push(x);
			//int y = min.pop();
			//min.push(y);
			int y = min.peek();
			if( x < y ) 
				min.push(x);
			else 
				min.push(y);
		}
	}

	public Integer pop() {
		min.pop();
		return super.pop();
	}
	
	private int min() {
		//int x = min.pop();
		//min.push(x);
		int x = min.peek();
		return x;
	}
	
	public static void main(String[] args) {
		StackMinElementWithAuxStack st = new StackMinElementWithAuxStack();
		st.push(10);
		st.push(19);
		System.out.println(st);
		System.out.println(st.min());
		st.push(3);
		st.push(15);
		System.out.println(st);
		System.out.println(st.min());
	}

}
