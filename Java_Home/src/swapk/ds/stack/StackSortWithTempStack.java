package swapk.ds.stack;

import java.util.Comparator;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
 * @author SKarnewar
 *
 */

public class StackSortWithTempStack extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3591793132078746053L;

	public static void main(String[] args) {
		StackSortWithTempStack st = new StackSortWithTempStack();
		st.push(34);
		st.push(3);
		st.push(31);
		st.push(98);
		st.push(92);
		st.push(23);
		StackSortWithTempStack st1 = (StackSortWithTempStack) st.clone();
		
		System.out.println("Before : "+st);
		//java provided method to sort as below
		st.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("After : "+st);
		
		//custom method is as follows
		Stack<Integer> sortedStack = custSortFunc(st1);
		System.out.println("After custSortFunc : "+sortedStack);
	}

	private static Stack<Integer> custSortFunc(StackSortWithTempStack st) {
		Stack<Integer> tmp = new Stack<Integer>();
		while(!st.isEmpty()) {
			int a = st.pop();
			while( !tmp.isEmpty() && a < (Integer)tmp.peek() ) {
				st.push((Integer) tmp.pop());
			}
			tmp.push(a);
		}
		return tmp;
	}

}
