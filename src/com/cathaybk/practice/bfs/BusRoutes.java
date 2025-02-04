package com.cathaybk.practice.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                map.computeIfAbsent(routes[i][j], l-> new ArrayList<>()).add(i);
            }
        }
        Set<Integer> set = new HashSet();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int result = 0;
        while(!q.isEmpty()){
            int len = q.size();
            result++;
            for(int i=0; i<len; i++) {
                Integer poll = q.poll();
                List<Integer> buses = map.get(poll);
                for (int bus : buses) {
                    if (set.contains(bus)) continue;
                    set.add(bus);
                    int[] stop = routes[bus];
                    for (int s : stop) {
                        if (s == target) return result;
                        if (s != poll) {
                            q.add(s);
                        }
                    }
                }
            }
        }

        return -1;
    }

}
