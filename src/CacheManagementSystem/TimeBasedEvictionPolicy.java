package CacheManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedEvictionPolicy<K, V> implements EvictionPolicy<K, V>{
	
	private final long expiryTime;
	private final Map<K, Long> timeStamps;
	
	public TimeBasedEvictionPolicy(long expiryTime) {
		this.expiryTime = expiryTime;
		this.timeStamps = new HashMap<>();
	}
	
	public void addTimeStamp(K key) {
		timeStamps.put(key, System.currentTimeMillis());
	}
	
	public void removeTimeStamps(K key) {
		timeStamps.remove(key);
	}
	
	@Override
	public void evict(Map<K, V> cache) {		
		long currentTime = System.currentTimeMillis();
		List<K> keyToEvict = new ArrayList<>();
		
		for(Map.Entry<K, Long> entry : timeStamps.entrySet()) {
			if(currentTime - entry.getValue() > expiryTime) {
				keyToEvict.add(entry.getKey());
			}
		}
		
		for(K key : keyToEvict) {
			cache.remove(key);
			timeStamps.remove(key);
		}
	}
	
	

}
