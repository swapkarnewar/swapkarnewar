package swapk.ds.queue;

/**
 * https://www.geeksforgeeks.org/queue-using-stacks/
 */
import java.util.Stack;

public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		
		QueueUsingTwoStacks q = new QueueUsingTwoStacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.display();
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}

	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();
	
	Integer deQueue() {
		if( st1.isEmpty() )
			throw new IllegalStateException("Queue is Empty");
		return st1.pop();
	}
	
	void enQueue(Integer x) {
		while( !st1.isEmpty() ) {
			st2.push(st1.pop());
		}
		st1.push(x);
		while( !st2.isEmpty() ) {
			st1.push(st2.pop());
		}
	}
	
	void display() {
		System.out.println(st1);
	}
}
