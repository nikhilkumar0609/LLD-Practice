package LRUCacheSystem;

import java.util.HashMap;

public class LRUCache<K, V> {
	
	// HashMap (key -> Node):
	// Stores references to nodes in the doubly linked list for O(1) access.

	// Doubly Linked List:
	// Maintains the order of usage:
	// The most recently used node is at the head.
	// The least recently used node is at the tail.
	// Adding and removing nodes can be done in O(1) time.

	// Eviction Policy (LRU):
	// When the cache exceeds its capacity, remove the least recently used (tail) node.

	
	//Node class for doubly linked list
	private class Node{
		K key;
		V value;
		Node prev, next;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}

	private final int capacity;
	private final HashMap<K, Node> cache;
	private final Node head;
	private final Node tail;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.head = new Node(null, null); //dummy node
		this.tail = new Node(null, null); //dummy node
		head.next = tail;
		tail.prev = head;
	}
	
	public V get(K key) {
		Node node = cache.get(key);
		if(node == null) {
			return null;
		}
		moveToHead(node);
		return node.value;
	}
	
	public void put(K key, V value) {
		Node node = cache.get(key);
		if(node != null) {
			node.value = value;
			moveToHead(node);
		}else {
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			addToHead(newNode);
			if(cache.size() > capacity) {
				removeLeastRecentlyUsed();
			}
		}
	}
	
	// Remove the least recently used node (tail's previous node)
	private void removeLeastRecentlyUsed() {
		Node lru = tail.prev;
		removeNode(lru);
		cache.remove(lru.key);
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addToHead(node);
	}

	// Add a node to the head of the list
	private void addToHead(Node node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	// Remove a node from the list
	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	// Print the cache contents (for testing/debugging)
    public void printCache() {
        Node current = head.next;
        System.out.print("Cache: ");
        while (current != tail) {
            System.out.print(current.key + "=" + current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
