package swapk.ds.stack;

/**
 * http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 */
import java.util.EmptyStackException;
import java.util.Stack;

public class StackMinElementWithSingleVar extends Stack<Integer>{

	private Integer minElement;

	public void push(int x) {
		if( isEmpty() ) {
			super.push(x);
			minElement = x;
		}
		else {
			if( x < minElement ) {
				super.push(2*x-minElement);
				minElement = x;
			}
			else {
				super.push(x);
			}
		}
	}
	
	public Integer pop() {
		if( isEmpty() )
			throw new EmptyStackException();
		int x = super.pop();
		if( x < minElement ) {
			minElement = 2 * minElement - x;
		}
		return x;
	}
	
	public int min() {
		if( isEmpty() )
			throw new EmptyStackException();
		else 
			return minElement;
	}
	
	public static void main(String[] args) {
		StackMinElementWithSingleVar st = new StackMinElementWithSingleVar();
		st.push(10);
		st.push(19);
		System.out.println(st.min());
		st.push(3);
		st.push(15);
		System.out.println(st.min());
	}

}
