package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {

    Long minFuelCost = 0L;
    public long minimumFuelCost(int[][] roads, int seats) {
        int cityNum = roads.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<cityNum; i++){
            graph.add(i, new ArrayList<Integer>());
        }

        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        dfs(0, 0, graph, seats);
        return minFuelCost;

    }

    int dfs(int city, int prevCity, List<List<Integer>> graph, int seats){
        int people = 1;
        for(int c : graph.get(city)){
            if (c== prevCity) continue;
            people += dfs(c, city, graph, seats);
        }

        if(city!=0) minFuelCost += people/seats + ((people%seats!=0)?1:0);

        return people;
    }
}
