package Interviewquestions;

import java.util.LinkedList;

public class HashMap<K, V> {
    // Default capacity and load factor
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;

    private int size;  // Number of key-value pairs in the map
    private LinkedList<Entry<K, V>>[] buckets;

    // Constructor
    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to calculate index for a key
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % buckets.length;
    }

    // Put method to insert a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update value if key exists
                return;
            }
        }

        // If key doesn't exist, add new entry
        bucket.add(new Entry<>(key, value));
        size++;

        // Check load factor and resize if necessary
        if (size >= LOAD_FACTOR_THRESHOLD * buckets.length) {
            resize();
        }
    }

    // Resize method to increase bucket capacity and rehash entries
    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;  // Reset size and rehash all entries
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }
    // Get method to retrieve value by key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;  // Key not found
    }

    // Remove method to delete a key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    // ContainsKey method to check if a key exists
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }



    // Entry class to represent a key-value pair
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}