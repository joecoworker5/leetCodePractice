package com.cathaybk.practice.structureDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;


public class ImplementQueueusingStacks {

    class MyQueue {

        private Stack<Integer> input;
        private Stack<Integer> output;
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.add(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.add(input.pop());
                }
            }

            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
