package CacheManagementSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheManager<K,V> {
	
	private final Map<K,V>cache;
	private final EvictionPolicy<K, V> evictionPolicy;
	
	public CacheManager(EvictionPolicy<K, V> evictionPolicy) {
		this.cache = new LinkedHashMap<>(); //LinkedHashMap keeps the keys in the order they were inserted.
		// This is useful for caching because you can easily determine which item was inserted first or last.
		this.evictionPolicy = evictionPolicy;
	}
	
	public void put(K key, V value) {
		cache.put(key, value);
		if(evictionPolicy instanceof TimeBasedEvictionPolicy) {
			((TimeBasedEvictionPolicy) evictionPolicy).addTimeStamp(key);
		}
		evictionPolicy.evict(cache);
	}

	public void get(K key) {
		cache.get(key);
	}
	
	public void remove(K key) {
		cache.remove(key);
		if(evictionPolicy instanceof TimeBasedEvictionPolicy) {
			((TimeBasedEvictionPolicy) evictionPolicy).removeTimeStamps(key);
		}
	}
	
	public void evict() {
		evictionPolicy.evict(cache);
	}
	
	public void printCache() {
        System.out.println("Cache: " + cache);
    }
	
}
