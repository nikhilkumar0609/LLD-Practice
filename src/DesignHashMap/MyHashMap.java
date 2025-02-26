package DesignHashMap;

import HashMap.MyHashMap;
import HashMap.MyHashMap.Entry;

public class MyHashMap<K, V> {
	
	private static final int INITIAL_SIZE = 1 << 4;
	private static final int MAX_CAPACITY = 1 << 30;
	
	Entry[] hashTable;
	
	public MyHashMap() {
		hashTable = new Entry[INITIAL_SIZE];
	}
	
	public MyHashMap(int capacity) {
		int tableSize = tableSizeFor(capacity);
		hashTable = new Entry[tableSize];
	}

	private int tableSizeFor(int capacity) {
		int n = capacity-1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
	}
	
	class Entry<K, V>{
		K key;
		V value;
		Entry next;
		
		Entry(K k, V v){
			key = k;
			value = v;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setKey(K k) {
			this.key = k;
		}
		
		public void setValue(V v) {
			this.value = v;
		}
	}
	
	
	public void put(K key, V value) {
		int hashCode = key.hashCode() % hashTable.length;
		Entry node = hashTable[hashCode];
		
		if(node == null) {
			Entry newNode = new Entry(key, value);
			hashTable[hashCode] = newNode;
		}else {
			Entry previousNode = node;
			while(node != null) {
				if(node.key == key) {
					node.value = value;
					return;
				}
				previousNode = node;
				node = node.next;
			}
			Entry newNode = new Entry(key, value);
			previousNode.next = newNode;
		}
	}
	
	public V get(K key) {
		int hashCode = key.hashCode() % hashTable.length;
		Entry node = hashTable[hashCode];
		
		while(node != null) {
			if(node.key.equals(key)) {
				return (V)node.value;
			}
			node = node.next;
		}
		return null;
	}
		
	
	public static void main(String args[]) {

        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Nikhil");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        String value = map.get(8);
        System.out.println(value);


    }

}

