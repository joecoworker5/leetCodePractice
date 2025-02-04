package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostStonesRemovedwithSameRoworColumn {

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        boolean[] visited = new boolean[stones.length];
        for(int i=0;  i<stones.length; i++){
            int[] stone = stones[i];
            xMap.computeIfAbsent(stone[0], l-> new ArrayList<>()).add(i);
            yMap.computeIfAbsent(stone[1], l-> new ArrayList<>()).add(i);
        }

        int count = 0;
        for(int i=0; i<stones.length; i++){
            if(!visited[i]){
                count++;
                dfs(i, xMap, yMap, visited, stones);
            }
        }

        return stones.length - count;
    }

    void dfs(int index, Map<Integer, List<Integer>> xMap , Map<Integer, List<Integer>> yMap, boolean[] visited, int[][] stones){
        if(visited[index]) return;
        visited[index] = true;
        int[] pos = stones[index];
        List<Integer> connect = Stream.of(xMap.getOrDefault(pos[0], new ArrayList<>()),
                                          yMap.getOrDefault(pos[1], new ArrayList<>()))
                                      .flatMap(List::stream)
                                      .collect(Collectors.toList());

        for(int i: connect){
            dfs(i, xMap, yMap, visited, stones);
        }
    }
}
