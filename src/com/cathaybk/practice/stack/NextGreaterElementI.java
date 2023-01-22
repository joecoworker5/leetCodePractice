package com.cathaybk.practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                Integer pop = stack.pop();
                map.put(pop, nums2[i]);
            }

            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[0] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
