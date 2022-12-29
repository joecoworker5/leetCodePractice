package com.cathaybk.practice.queue;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveStonestoMinimizetheTotal {

    public int minStoneSum(int[] piles,
                           int k) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,
                               Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : piles) {
            pq.add(num);
        }

        while (k > 0) {
            Integer max = pq.poll();
            pq.add(max - max / 2);
            k--;
        }
        int sum = 0;
        for(int num: pq){
            sum +=num;
        }

        return sum;
    }
}
