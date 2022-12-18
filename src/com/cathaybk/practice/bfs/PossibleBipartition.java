package com.cathaybk.practice.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {

    public boolean possibleBipartition(int n,
                                       int[][] dislikes) {
        List[] graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            graph[i]= new ArrayList();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        int[] people = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (people[i] == 0) {
                people[i] = 1;
                q.add(i);
                while (!q.isEmpty()) {
                    Integer poll = q.poll();
                    List<Integer> connected = graph[poll];
                    for (int p : connected) {
                        if (people[p] == 0) {
                            people[p] = people[poll] == 1 ? 2 : 1;
                            q.add(p);
                        } else {
                            if(people[p]==people[poll]){
                                return false;
                            }
                        }
                    }
                }

            }
        }

        return true;

    }

}
