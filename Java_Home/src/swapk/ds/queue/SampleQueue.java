package swapk.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class SampleQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(10);
		q.add(12);
		q.add(20);
		q.add(1);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

}
