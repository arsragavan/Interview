package linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

// LinkedHashMap can maintain elements in insert/access order
class LRU<K, V> extends LinkedHashMap<K, V> {

	private int capacity;
	private static final long serialVersionUID = -1047435957394770182L;

	public LRU(int capacity) {
		// false - insert order
		// true - access order
		super(capacity + 1, 0.75f, true);
		this.capacity = capacity;
	}

	// when to remove elements - when size exceeds capacity
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return (this.size() > capacity);
	}
}

public class LRUCache {

	public static void main(String[] args) {
		Random random = new Random();
		int capacity = random.nextInt(10);
		LRU<Integer, Integer> lru = new LRU<>(capacity / 2);

		for (int i = 0; i < capacity; i++) {
			int putVal = random.nextInt(10);
			lru.put(putVal, putVal);
			int getVal = random.nextInt(10);
			System.out.println("Get val = " + getVal);
			lru.get(getVal);
			System.out.println(lru);
		}

		System.out.println("=======================================");

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10,
				1.0f, true);
		map.put(1, 1);
		System.out.println(map);
		map.put(2, 1);
		System.out.println(map);
		map.get(1);
		System.out.println(map);
		map.put(3, 1);
		System.out.println(map);
		map.put(4, 1);
		System.out.println(map);
		map.get(2);
		System.out.println(map);
		map.put(5, 1);
		System.out.println(map);
		map.put(6, 1);
		System.out.println(map);

	}
}
