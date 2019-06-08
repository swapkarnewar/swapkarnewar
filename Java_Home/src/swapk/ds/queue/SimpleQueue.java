package swapk.ds.queue;

public class SimpleQueue {

	public static void main(String[] args) {
		QueueArray queue = new QueueArray(5);
		queue.enQueue(22);
		queue.enQueue(23);
		queue.enQueue(24);
		queue.display();
		System.out.println("-----");
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
	}

}

class QueueArray {
	
	private int capacity;
	private int size;
	private int front;
	private int rear;
	private int[] queue;
	
	public QueueArray(int capacity) {
		size = 0;
		front = rear = -1;
		this.capacity = capacity;
		queue = new int[capacity];
	}
	
	boolean isFull() {
		if( size == capacity )
			return true;
		return false;
	}
	
	boolean isEmpty() {
		if( size == 0 && front == rear )
			return true;
		return false;
	}
	
	void enQueue(int x) {
		if( isFull() )
			throw new IllegalStateException("Queue is Full");
		rear = rear + 1;
		queue[rear] = x;
		size++;
	}
	
	int deQueue() {
		if( isEmpty() )
			throw new IllegalStateException("Queue is Empty");
		front = front + 1;
		int x = queue[front];
		size--;
		return x;
	}
	
	int front() {
		if ( isEmpty() )
			throw new IllegalStateException("Queue is Empty");
		return queue[front];
	}
	
	int rear() {
		if ( isEmpty() )
			throw new IllegalStateException("Queue is Empty");
		return queue[rear];
	}
	
	void display() {
		for( int i = 0; i < capacity; i++ ) {
			System.out.print(queue[i]+" ");
		}
	}
}