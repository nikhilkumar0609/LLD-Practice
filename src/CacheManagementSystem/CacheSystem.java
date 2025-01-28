package CacheManagementSystem;

public class CacheSystem {
    public static void main(String[] args) throws InterruptedException {
        // Test Time-Based Eviction
        System.out.println("Time-Based Eviction:");
        CacheManager<String, String> timeBasedCache = new CacheManager<>(new TimeBasedEvictionPolicy<>(3000)); // 3 seconds expiry
        timeBasedCache.put("A", "Apple");
        timeBasedCache.put("B", "Banana");
        Thread.sleep(2000);
        timeBasedCache.put("C", "Cherry");
        Thread.sleep(2000);
        timeBasedCache.evict(); // Manual eviction to clear expired items
        timeBasedCache.printCache(); // Output should not include "A" and "B"

        // Test Data-Based Eviction
        System.out.println("\nData-Based Eviction:");
        CacheManager<String, String> dataBasedCache = new CacheManager<>(new DataBasedEvictionPolicy<>(2)); // Max size 2
        dataBasedCache.put("X", "Xylophone");
        dataBasedCache.put("Y", "Yellow");
        dataBasedCache.put("Z", "Zebra");
        dataBasedCache.printCache(); // Output should include only "Y" and "Z"
    }
}
