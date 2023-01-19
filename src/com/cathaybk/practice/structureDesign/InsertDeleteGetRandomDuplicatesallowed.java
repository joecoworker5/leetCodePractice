package com.cathaybk.practice.structureDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


// insert delete getRandom 都必須 O(1) 可重複
public class InsertDeleteGetRandomDuplicatesallowed {

    // 因為是 Duplicate 所以用 Set 裝 Index
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);
        list.add(val);
        map.computeIfAbsent(val, l -> new HashSet<>())
           .add(list.size() - 1);

        return result;
    }

    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if(!contains) return false;

        Integer index = map.get(val)
                          .iterator()
                          .next();
        // map remove要寫在前面, 不然會錯
        map.get(val).remove(index);
        if(index < list.size()-1){
            Integer last = list.get(list.size() - 1);
            list.set(index, last);
            map.get(last).remove(list.size()-1);
            map.get(last).add(index);
        }

        list.remove(list.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
