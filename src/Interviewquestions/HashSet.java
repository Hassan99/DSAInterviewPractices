package Interviewquestions;

import java.util.LinkedList;

class HashSet {
    private int capacity;
    private LinkedList[] buckets;


    public HashSet(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}