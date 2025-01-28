package CacheManagementSystem;

import java.util.Map;

public interface EvictionPolicy<K, V> {
	
	void evict(Map<K, V> cache);

}
