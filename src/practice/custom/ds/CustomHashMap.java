package practice.custom.ds;

public class CustomHashMap<K, V> implements CustomMap<K, V> {

	private static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private static int capacity = 16;
	private double loadFactor = 0.75;
	Entry<K, V>[] buckets;
	private int size = 0;

	public CustomHashMap() {
		this(capacity);
	}

	public CustomHashMap(int capacity) {
		buckets = new Entry[capacity];
	}

	@Override
	public boolean put(K key, V value) {
		int hashVal = key.hashCode() % buckets.length;
		Entry<K, V> entry = buckets[hashVal];
		if (entry != null) {
			while (entry.next != null) {
				if (entry.key.equals(key))
					break;
				entry = entry.next;
			}
			if (entry.key.equals(key)) {
				entry.value = value;
				return false;
			} else {
				entry.next = new Entry<K, V>(key, value, null);
			}

		} else {
			entry = new Entry<K, V>(key, value, null);
			buckets[hashVal] = entry;
			size++;
		}
		return true;
	}

	@Override
	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		return entry == null ? null : entry.value;
	}

	private Entry<K, V> getEntry(K key) {
		int hashVal = key.hashCode() % buckets.length;
		Entry<K, V> entry = buckets[hashVal];
		while (entry != null) {
			if (entry.key.equals(key))
				break;
			entry = entry.next;
		}
		return entry;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void remove(K key) {
		int hashVal = key.hashCode() % buckets.length;
		Entry<K, V> entry = buckets[hashVal];
		if (entry == null)
			return;

		if (entry.key.equals(key)) {
			buckets[hashVal] = entry.next;			
			return;
		}
		while (entry.next != null && !entry.next.key.equals(key)) {
			entry = entry.next;
		}
		if (entry.next != null) {
			entry.next = entry.next.next;
			return;
		}
	}

}
