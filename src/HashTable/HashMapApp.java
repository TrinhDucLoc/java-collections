package HashTable;

import java.util.LinkedList;

public class HashMapApp<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    public HashMapApp(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public HashMapApp() {
        this(DEFAULT_CAPACITY);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return Math.abs(hashCode % DEFAULT_CAPACITY);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if ((key == null && entry.key == null)
                        || (key != null && key.equals(entry.key))) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean remove(K key) {
        // get index
        int index = getBucketIndex(key);
        // loop entry
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if ((key == null && entry.key == null)
                        || (key != null && key.equals(entry.key))) {
                    buckets[index].remove();
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMapApp<String, Integer> hashMapApp = new HashMapApp<>();
        hashMapApp.put("one", 1);
        hashMapApp.put("two", 2);
        hashMapApp.put("three", 3);

        System.out.println("Value for two: " + hashMapApp.get("two"));
        System.out.println("Size of hashMapApp: " + hashMapApp.size());
        System.out.println("Contains three: " + hashMapApp.containsKey("three"));

        hashMapApp.remove("three");
        System.out.println("Size of hashMapApp: " + hashMapApp.size());
        System.out.println("Contains three: " + hashMapApp.containsKey("three"));
    }
}
