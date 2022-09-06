package com.cathaybk.practice.leetCode;

import java.util.Stack;

class MinStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minstack = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(val);
			minstack.push(val);
		} else if (val > minstack.peek()) {
			stack.push(val);
			minstack.push(minstack.peek());
		} else {
			stack.push(val);
			minstack.push(val);
		}

	}

	public void pop() {
		stack.pop();
		minstack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}
}
