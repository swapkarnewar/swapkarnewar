import java.util.HashMap;

// simple - https://www.careercup.com/question?id=17230678

/*You are required to complete below class */
class LRUCache {

	int cacheSize = 0;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node end = null;

	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	/* Initialize an LRU cache with size N */
	public LRUCache(int N) {
		this.cacheSize = N;
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {
		if (map.containsKey(x)) {
			Node node = map.get(x);
			remove(node);
			setHead(node);
			return node.value;
		} else
			return -1;
		// Your code here
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		if (map.containsKey(x)) {
			Node oldNode = map.get(x);
			oldNode.value = y;
			remove(oldNode);
			setHead(oldNode);
		} else {
			Node newNode = new Node(x, y);
			if (map.size() >= cacheSize) {
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			map.put(x, newNode);
		}

	}

	public void remove(Node node) {
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			node.next.pre = null;
			head = node.next;
		}

		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			node.pre.next = null;
			end = node.pre;
		}

	}

	public void setHead(Node node) {
		node.next = head;
		node.pre = null;

		if (head != null) {
			head.pre = node;
		}

		head = node;

		if (end == null) {
			end = head;
		}
	}

	public static void main(String[] args) {
		LRUCache lr = new LRUCache(5);
		lr.set(1, 1);
		lr.set(2, 2);
		lr.set(3, 3);
		lr.set(4, 4);
		lr.set(5, 5);
		lr.set(1, 1);
		int val = lr.get(1);
		System.out.println("" + val);
		lr.set(6, 6);
		int val2 = lr.get(2);
		System.out.println("" + val2);
	}

}