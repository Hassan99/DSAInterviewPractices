package Interviewquestions;

import java.util.LinkedList;

public class HashMapTest<K, V> {

    private static final int DEFAULT_BUCKET_SIZE = 10;
    private static final float LOAD_THRESOLD = 0.75F;

    private int size = 0;
    private LinkedList<Entry<K, V>> bucketArray[];

    public HashMapTest() {
        bucketArray = new LinkedList[DEFAULT_BUCKET_SIZE];
        for (int i = 0; i < DEFAULT_BUCKET_SIZE; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }
    private int hash(K key){
        return key == null?0: Math.abs(key.hashCode())%bucketArray.length;
    }
     void put(K key,V value){
        int index = hash(key);
        LinkedList<Entry<K,V>> list = bucketArray[index];
        for(Entry<K,V> entry:list){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        list.add(new Entry<>(key,value));
        size++;

        if(size>=(LOAD_THRESOLD * bucketArray.length)){
            resize();
        }
    }
    private void resize(){
        LinkedList<Entry<K,V>> temproryArray[] = bucketArray;
        bucketArray = new LinkedList[temproryArray.length*2];

        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = new LinkedList<>();
        }

        size = 0;
        for(LinkedList<Entry<K,V>> list :temproryArray){
            for(Entry<K,V> entry:list){
                put(entry.key,entry.value);
            }
        }
    }
     V get(K key){
        int index = hash(key);
        LinkedList<Entry<K,V>> list = bucketArray[index];
        for(Entry<K,V> entry:list){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }


     boolean remove(K key){
        Entry<K,V> entryToRemove = null;
        int index = hash(key);
        LinkedList<Entry<K,V>> list = bucketArray[index];
        for(Entry<K,V> entry:list){
            if(entry.key.equals(key)){
                entryToRemove = entry;
            }
        }
        if(entryToRemove!=null){
            list.remove(entryToRemove);
            size-=1;
            return true;
        }
        return false;
    }
     boolean containsKey(K key){
        Entry<K,V> containsKey = null;
        int index = hash(key);
        LinkedList<Entry<K,V>> list = bucketArray[index];
        for(Entry<K,V> entry:list){
            if(entry.key.equals(key)){
                containsKey = entry;
            }
        }
        if(containsKey!=null){
            return true;
        }
        return false;
    }

    private static class Entry<K, V> {
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;

    }
}
