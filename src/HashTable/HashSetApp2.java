package HashTable;

import java.util.Hashtable;
import java.util.LinkedList;

public class HashSetApp2<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private LinkedList<T>[] buckets;

    HashSetApp2(int capacity) {
        size = 0;
        buckets = new LinkedList[capacity];
    }

    HashSetApp2() {
        this(DEFAULT_CAPACITY);
    }

    public int getBucketsIndex(T key) {
        int index = key.hashCode();
        return Math.abs(index % (buckets.length - 1));
    }

    public void add(T key) {
        int index = getBucketsIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        if (buckets[index] != null) {
            for (T item : buckets[index]) {
                if ((key == null && item == null) || (key != null && key.equals(item))) {
                    return;
                }
            }
        }

        size++;
        buckets[index].add(key);
    }

    public boolean contains(T key) {
        int index = getBucketsIndex(key);

        if (buckets[index] != null) {
            for (T item : buckets[index]) {
                if ((key == null && item == null) || (key != null && key.equals(item))) {
                    return true;
                }
            }
        }

        return false;
    }

    public void remove(T key) {
        int index = getBucketsIndex(key);

        if (buckets[index] != null) {
            for (T item : buckets[index]) {
                if ((key == null && item == null) || (key != null && key.equals(item))) {
                    buckets[index].remove(key);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
//        HashSetApp2<Integer> hashSetApp2 = new HashSetApp2<>();
//
//        hashSetApp2.add(1);
//        hashSetApp2.add(1);
//        hashSetApp2.add(2);
//        hashSetApp2.add(3);
//
//        System.out.println("Size: " + hashSetApp2.size());
//
//        hashSetApp2.remove(2);
//        System.out.println("Size: " + hashSetApp2.size());

        HashSetApp2<Person> hashSetApp2 = new HashSetApp2<>();

        hashSetApp2.add(new Person("Loc", 25));
        hashSetApp2.add(new Person("Loc", 25));
        hashSetApp2.add(new Person("Loc", 25));
        hashSetApp2.add(new Person("Loc", 25));

        System.out.println("Size: " + hashSetApp2.size());

        hashSetApp2.remove(new Person("Loc", 25));
        System.out.println("Size: " + hashSetApp2.size());


        Hashtable<Integer, String> hashtable = new Hashtable();
    }
}
