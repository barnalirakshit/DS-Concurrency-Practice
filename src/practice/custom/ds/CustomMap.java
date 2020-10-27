package practice.custom.ds;
//Design a HashMap without using any built-in hash table libraries.
public interface CustomMap<K, V> {

	public boolean put(K key, V value);

	public V get(K key);

	public int size();
	
	 public void remove(K key);

}
