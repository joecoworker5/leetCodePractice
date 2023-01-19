package com.cathaybk.practice.prioirtyQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> poll = pq.poll();
            Integer count = poll.getValue();
            Character key = poll.getKey();
            while(count-- >0){
                sb.append(key);
            }
        }

        return sb.toString();
    }
}
