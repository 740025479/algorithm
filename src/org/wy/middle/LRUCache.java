package org.wy.middle;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    private int size;
    private LinkedList linkedList;
    private HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        linkedList = new LinkedList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            linkedList.remove((Object) key);
            linkedList.add(key);
        }
        return map.get(key) == null ? -1 : map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            linkedList.remove((Object)key);
        }
        if (linkedList.size() == size) {
            int del = (int) linkedList.removeFirst();
            map.remove(del);
        }
        linkedList.add(key);
        map.put(key, value);
    }
}
