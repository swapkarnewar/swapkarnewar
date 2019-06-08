package swapk.ds.stack;

/**
 * http://www.geeksforgeeks.org/implement-stack-using-queue/
 */
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	public static void main(String []args) {
		StackUsingQueues st = new StackUsingQueues();
		st.push(10);
		st.push(35);
		st.push(79);
		st.push(46);
		st.push(21);
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st);
	}

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	private void push(int x) {
		q1.add(x);
	}
	
	private int pop() {
		int size1 = q1.size();
		for( int i = 0; i <= size1-2; i++ ) {
			q2.add(q1.poll());
		}
		int x = q1.poll();
		swapQueues();
		return x;
	}

	private void swapQueues() {
		Queue<Integer> tempQ = new LinkedList<Integer>();
		tempQ = q1;
		q1 = q2;
		q2 = tempQ;
	}

	@Override
	public String toString() {
		return "StackUsingQueues " + q1;
	}
}
