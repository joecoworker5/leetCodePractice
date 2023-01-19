package com.cathaybk.practice.structureDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


// insert delete getRandom 都必須 O(1)
public class InsertDeleteGetRandom {

    // public RandomizedSet() {
        
    // }    
    
	
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();
    private int size = 0;

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size()-1);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        Integer index = map.get(val);
        // swap
        Integer last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size()-1);
        map.remove(val);

        size--;

        return true;
    }

    public int getRandom() {
        int i = random.nextInt(size);
        return list.get(i);
    }
}
