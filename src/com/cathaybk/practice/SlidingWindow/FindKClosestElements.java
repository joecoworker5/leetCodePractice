package com.cathaybk.practice.SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindKClosestElements {


    // 此題類似於 Sliding Window for K Elements, FriutIntoBasket, LongestSubStrWithoutRepeatingCaracter
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        for(int ele : arr){
            if(q.size()==k){
                Integer front = q.peek();
                if(Math.abs(front - x)>Math.abs(ele-x) || front == ele){
                    q.poll();
                } else {
                    return new ArrayList<>(q);
                }
            }
            q.add(ele);
        }

        return new ArrayList<>(q);
    }
}
