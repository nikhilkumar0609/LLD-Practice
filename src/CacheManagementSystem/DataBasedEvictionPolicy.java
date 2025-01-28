package CacheManagementSystem;

import java.util.Map;

public class DataBasedEvictionPolicy<K, V> implements EvictionPolicy<K, V> {
	
	private int maxSize;
	
	public DataBasedEvictionPolicy(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
    public void evict(Map<K, V> cache) {
        while (cache.size() > maxSize) {
            K firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
    }

}
