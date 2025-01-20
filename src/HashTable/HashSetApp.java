package HashTable;

import java.util.LinkedList;

public class HashSetApp<K> {
    private static final int DEFAULT_BUCKET_CAPACITY = 16;
    private LinkedList<K>[] buckets;
    private int size;

    public HashSetApp(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public HashSetApp() {
        this(DEFAULT_BUCKET_CAPACITY);
    }

    private int getBucketIndex(K key) {
        int hashCode = (key == null ? 0 : key.hashCode());
        return Math.abs(hashCode % buckets.length);
    }

    public boolean add(K key) {
        int index = getBucketIndex(key);
        // buckets[index] == null
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // buckets[index] != null
        for (K item : buckets[index]) {
            if ((key == null && item == null) || (key != null && key.equals(item))) {
                return false;
            }
        }

        // buckets add key
        buckets[index].add(key);
        size++;
        return true;
    }

    public boolean contains(K key) {
        // get index from key
        int index = getBucketIndex(key);
        // check buckets[index] have key
        if (buckets[index] != null) {
            for (K item : buckets[index]) {
                if ((key == null && item == null) || (key != null && key.equals(item))) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean remove(K key) {
        // get index from key
        int index = getBucketIndex(key);
        // if buckets[index]
        if (buckets[index] != null) {
            for (K item : buckets[index]) {
                if ((key == null && item == null) || (key != null && key.equals(item))) {
                    buckets[index].remove(item);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashSetApp<String> set = new HashSetApp<>();
        System.out.println("Add 'hello': " + set.add("hello")); // Output: true
        System.out.println("Add 'world': " + set.add("world")); // Output: true
        System.out.println("Add 'hello' again: " + set.add("hello")); // Output: false

        System.out.println("Contains 'hello': " + set.contains("hello")); // Output: true
        System.out.println("Contains 'java': " + set.contains("java")); // Output: false

        System.out.println("Remove 'hello': " + set.remove("hello")); // Output: true
        System.out.println("Contains 'hello' after removal: " + set.contains("hello")); // Output: false

        System.out.println("Size: " + set.size());
        System.out.println("Is empty: " + set.isEmpty());
    }
}
