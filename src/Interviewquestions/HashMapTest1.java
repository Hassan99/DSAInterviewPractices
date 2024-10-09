package Interviewquestions;

import java.util.LinkedList;

public class HashMapTest1 {

    private static final int DEFAULT_BUCKET_SIZE = 10;
    private static final float LOAD_THRESOLD = 0.75F;

    private int size = 0;
    private LinkedList<Entry> bucketArray[];

    public HashMapTest1() {
        bucketArray = new LinkedList[DEFAULT_BUCKET_SIZE];
        for (int i = 0; i < DEFAULT_BUCKET_SIZE; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }
    private int hash(Integer key){
        return key == null?0: Math.abs(key.hashCode())%bucketArray.length;
    }
     void put(Integer key,Integer value){
        int index = hash(key);
        LinkedList<Entry> list = bucketArray[index];
        for(Entry entry:list){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key,value));
        size++;

        if(size>=(LOAD_THRESOLD * bucketArray.length)){
            resize();
        }
    }
    private void resize(){
        LinkedList<Entry> temproryArray[] = bucketArray;
        bucketArray = new LinkedList[temproryArray.length*2];

        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = new LinkedList<>();
        }

        size = 0;
        for(LinkedList<Entry> list :temproryArray){
            for(Entry entry:list){
                put(entry.key,entry.value);
            }
        }
    }
     Integer get(Integer key){
        int index = hash(key);
        LinkedList<Entry> list = bucketArray[index];
        for(Entry entry:list){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }


     boolean remove(Integer key){
        Entry entryToRemove = null;
        int index = hash(key);
        LinkedList<Entry> list = bucketArray[index];
        for(Entry entry:list){
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
     boolean containsKey(Integer key){
        Entry containsKey = null;
        int index = hash(key);
        LinkedList<Entry> list = bucketArray[index];
        for(Entry entry:list){
            if(entry.key.equals(key)){
                containsKey = entry;
            }
        }
        if(containsKey!=null){
            return true;
        }
        return false;
    }

    private static class Entry {
        public Entry(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Integer key;
        Integer value;

    }
}
