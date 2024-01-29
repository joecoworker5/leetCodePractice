package com.cathaybk.practice.stack;

import java.util.Stack;

public class AsteroidCollision {


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack();
        for (int a : asteroids) {
            if (!s.isEmpty() && s.peek() > 0 && a < 0) {
                boolean isDestroyed = false;
                while (!s.isEmpty() && s.peek() > 0 && a < 0) {
                    if (s.peek() > Math.abs(a)) {
                        isDestroyed = true;
                        break;
                    }
                    else if (s.peek() < Math.abs(a)) {
                        s.pop();
                    }
                    else {
                        isDestroyed = true;
                        s.pop();
                        break;
                    }
                }
                if(!isDestroyed){
                    s.add(a);
                }
            }
            else {
                s.add(a);
            }
        }

        int size = s.size();
        int[] result = new int[size];
        while(!s.isEmpty()){
            result[--size] = s.pop();
        }
        return result;
    }
}
