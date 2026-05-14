package SummerCPSC3200Assignment5;
public class McGahaDoubleHashing<K, V> {
	private static final double MAX_LOAD_FACTOR = .7;
	public HashEntry<K,V>[] elementData;
	private int size;
	
	// constructor for hashtable
	public McGahaDoubleHashing() {
        elementData = (HashEntry<K, V>[]) new HashEntry[10];
        size = 0;
    }
	// constructor given initial capacity
	public McGahaDoubleHashing(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        elementData = (HashEntry<K, V>[]) new HashEntry[initialCapacity];
        size = 0;
    }
	
	// inner class of hash entry that have keys and values
	private static class HashEntry<K, V> {
        public K key;
        public V value;
        public HashEntry<K, V> next;
        
        public HashEntry(K key, V value) {
            this(key, value, null);
        }
        
        public HashEntry(K key, V value, HashEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
	
	public int hashFunction1(K key) {
		return Math.abs((int) key) % elementData.length;
	}
	
	public int hashFunction2(K key) {
		return 7 - (Math.abs((int) key) % 7);
	}
	
	public int doubleHash(K key, int attempt) {
		// use both hash functions and implement double hashing
		int hash1 = hashFunction1(key);
		int hash2 = hashFunction2(key);
        return (hash1 + attempt * hash2) % elementData.length;
	}
	
	public void add(K key, V value) {
		// method to add a key-value pair into the hash table
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		
//		if (loadFactor() >= MAX_LOAD_FACTOR) {
//			rehash();
//		}
		
		int attempt = 0;
		int index;
		
		do {
            index = doubleHash(key, attempt);
            
            // If slot is empty, insert here
            if (elementData[index] == null) {
                elementData[index] = new HashEntry<>(key, value);
                size++;
                System.out.println("value: " + value + " is at index " + index);
                break;
            }
            
            attempt++;
        } while (attempt < elementData.length);

	}
	
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int attempt = 0;
		int index;
		
		do {
			index = doubleHash(key, attempt);
			// If we hit an empty slot (not deleted), key doesn't exist
            if (elementData[index] == null) {
                return null;
            }
            
            // If we find the key (and it's not deleted), return the value
            if (elementData[index].key.equals(key)) {
                return elementData[index].value;
            }
            
            attempt++;
        } while (attempt < elementData.length);
        
        return null; // Key not found after full probe
	}
	
	public void remove(K key) {
	    if (key == null) {
	        throw new IllegalArgumentException("Key cannot be null");
	    }
	    
	    int attempt = 0;
	    int index;
	    
	    do {
	        index = doubleHash(key, attempt);
	        
	        // If we hit an empty slot, key doesn't exist
	        if (elementData[index] == null) {
	            break;
	        }
	        
	        // If we find the key, remove it
	        if (elementData[index].key.equals(key)) {
	            V removedValue = elementData[index].value;
	            elementData[index] = null;  // Mark as deleted
	            size--;
	            
	            break;
	        }
	        
	        attempt++;
	    } while (attempt < elementData.length);
	    
	}
	
	public void print() {
		System.out.println("HashTable: {");
	    boolean first = true;
	    for (int i = 0; i < elementData.length; i++) {
	        if (elementData[i] != null) {
	            if (!first) {
	                System.out.print(", ");
	            }
	            System.out.print("Key: " + elementData[i].key + " => " + elementData[i].value + " @ " + "index " + i);
	            first = false;
	        }
	    }
	    System.out.println("\n} (Size: " + size + "/" + elementData.length + ")");
	}
public static void main(String[] args) {
	McGahaDoubleHashing<Integer, String> hTable = new McGahaDoubleHashing<>();
	hTable.add(1, "hello world");
	System.out.println(hTable.get(1));
	hTable.add(73, "how will this work");
	System.out.println(hTable.get(73));
	hTable.print();
	hTable.remove(1);
	System.out.println("After removing the value at key 1, the value there is: ");
	System.out.println(hTable.get(1));
	}
}
