//package 基本数据结构实现;
//import java.util.*;
//
///**
// * https://docs.google.com/document/d/1EptdJZZr2AGK5nFrlrB88MKcVqXm3W3ki9pa81AEuCs/edit
// *
// *
// * **/
// */
//
///**define buckets : using Entry**/
//class Entry<K, V> {
//    final K key;
//    V value;
//    Entry<K, V> next;  //seperate chaining : linkedlist use here
//    Entry<K key, V value> {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//
//    public void setValue(V value) {
//        this.value = value;
//    }
//}
//public class HashMap<K, V> {
//    private static final int DEFAULT_SIZE = 11;
//    private static final float LOAD_FACTOR = 0.75;
//    private Entry<K, V>[] array;   //manage all Entry
//    private int size;
//
//    public HashMap() {
//        this.array = (Entry<K, V>) new Entry[DEFAULT_SIZE];
//        this.size = 0;
//    }
//
//    public V get(K key) {
//        int bucketIndex = index(key);
//        Entry<K, V> head = array[bucketIndex];  //get head of linkedlist
//        //start to iterate linkedlist
//        while (head != null) {
//            if (equalKey(head.getKey(), key)) {
//
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
