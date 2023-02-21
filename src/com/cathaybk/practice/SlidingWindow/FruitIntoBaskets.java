package com.cathaybk.practice.SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FruitIntoBaskets {


    // 此題類似於 Sliding Window for K Elements
    public int totalFruit(int[] fruits) {
        // fruits = [1,2,3,2,2]
        Map<Integer, Integer> map = new HashMap<>();
        int i=0; int maxFruits = 0;
        for(int j=0; j<fruits.length; j++){
           map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);
           while(map.size()>2){
               map.put(fruits[i], map.get(fruits[i])-1);
               if(map.get(fruits[i])==0) map.remove(fruits[i]);
               i++;
           }
           maxFruits = Math.max(maxFruits, j-i+1);
        }
        return maxFruits;
    }
}
