package com.cathaybk.practice.queue;


import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums){
            if(map.containsKey(num)){
                Integer count = map.get(num);
                map.put(num, ++count);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue() -o1.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        int[] result = new int[k];
        int index = 0;
        while(index<k){
            Map.Entry<Integer, Integer> maxEntry = pq.poll();
            result[index] = maxEntry.getKey();
            index++;
        }

        return result;
    }
}
