package com.cathaybk.practice.stack;

import java.util.Stack;

public class DailyTemperatures {


	// 存 index 就可以連 value 一起存
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<result.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]< temperatures[i]){
                Integer pop = stack.pop();
                result[pop] = i-pop;
            }
            stack.push(i);
        }
        return result;
    }
}
