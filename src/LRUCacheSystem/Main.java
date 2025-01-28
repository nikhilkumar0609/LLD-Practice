package LRUCacheSystem;

public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printCache(); // Cache: 3=C 2=B 1=A

        cache.get(2); // Access key 2
        cache.printCache(); // Cache: 2=B 3=C 1=A

        cache.put(4, "D"); // Insert key 4, evicts key 1 (LRU)
        cache.printCache(); // Cache: 4=D 2=B 3=C

        cache.get(1); // Key 1 doesn't exist
        System.out.println("Get 1: " + cache.get(1)); // Get 1: null
    }
}

