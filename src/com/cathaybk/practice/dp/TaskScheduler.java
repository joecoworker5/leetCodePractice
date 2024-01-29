package com.cathaybk.practice.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char t: tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
        }

        Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry e : map.entrySet()){
            q.add(e);
        }
        Map.Entry<Character, Integer> maxEntry = q.poll();
        int maxCount = maxEntry.getValue();
        int minTasksUnitSoFar = (maxCount - 1)*n + maxCount;
        int vacancySoFar = (maxCount - 1)*n;
        while(!q.isEmpty()){
            Map.Entry<Character, Integer> poll = q.poll();
            if(vacancySoFar!=0){
                if(maxCount == poll.getValue()){
                    vacancySoFar -= poll.getValue() - 1;
                    minTasksUnitSoFar++;
                } else {
                    vacancySoFar -= poll.getValue();
                }
            } else {
                minTasksUnitSoFar += poll.getValue();
            }
        }
        if(vacancySoFar<0){
            return minTasksUnitSoFar - vacancySoFar;
        }
        return minTasksUnitSoFar;
    }

}
