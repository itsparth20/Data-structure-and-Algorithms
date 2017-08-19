package tries;

import java.util.HashMap;
import java.util.Map;

class LRU {
	public static void main(String[] args) throws java.lang.Exception {		
		LRUCache lru = new LRUCache(2);
		lru.set(0, 0);
		lru.set(1, 1);
		lru.set(2, 2);
		lru.print();
	}
}

class LRUCache {

	//Inner Node Class
	class Node {
		int key, value;
		Node prev;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	Node head = null;
	Node tail = null;
	int capacity;
	Map<Integer, Node> data = new HashMap<>();

	LRUCache(int capacity) {
		this.capacity = capacity;
	}

	// get catch
	public int get(int key) {
		// if key is there
		if (data.containsKey(key)) {
			Node node = data.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}

		// else key is not there
		return -1;
	}

	// set this not to start point
	private void setHead(Node node) {
		node.next = head;
		node.prev = null;

		// head is be null
		if (head == null) 
			tail = node;		
		
		// head is not null
		else 
			head.prev = node;		
		head = node;
	}

	// remove this node
	private void remove(Node node) {

		// if next is not null
		if (node.next != null) 
			node.next.prev = node.prev;
		
		// if next is null
		else 
			tail = node.prev;		
		
		// if prev is null
		if (node.prev != null) 
			node.prev.next = node.next;		
		
		// if prev is not null
		else 
			head = node.next;		
	}

	// set catch
	public void set(int key, int value) {
		// key may exist
		if (data.containsKey(key)) {
			Node old = data.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}
		// key may not exist
		else {
			// there is no space then make space
			if (capacity <= data.size()) {
				data.remove(tail.key);
				remove(tail);
			}
			// if there is space in map then
			Node node = new Node(key, value);
			setHead(node);
			data.put(key, node);
		}
	}

	// print LRU
	public void print() {
		Node temp = head;
		while (temp != null){
			System.out.println(temp.key);
			temp = temp.next;
		}

	}
}
