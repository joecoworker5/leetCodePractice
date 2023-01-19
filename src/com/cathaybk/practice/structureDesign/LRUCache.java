package com.cathaybk.practice.structureDesign;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {

    //LinkedHashMap is laziest solution
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;

        // accessOrder為true代表 iterate時, 最後 access 的元素會最後顯示
        // false 代表 iterate 時, 最後 insert元素會最後顯示
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}
