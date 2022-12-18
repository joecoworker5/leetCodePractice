package com.cathaybk.practice.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] group = new int[size];
        for (int i = 0; i < size; i++) {
            if (group[i] == 0) {
                group[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    Integer cur = q.poll();
                    for (int num : graph[cur]) {
                        if (group[num] == 0) {
                            group[num] = group[cur] == 1 ? 2 : 1;
                            q.add(num);
                        } else {
                            if (group[num] == group[cur])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
