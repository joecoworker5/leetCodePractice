package com.cathaybk.practice.leetCode.linkedList;

import java.util.Stack;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		boolean result = new PalindromeLinkedList().isPalindrome(root);
		System.out.println(result);
	}


	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			stack.add(slow.val);
			slow = slow.next;
			if (fast.next == null) {
				stack.pop();
				return checkIsisPalindrome(stack, slow);
			} else if (fast.next.next == null) {
				return checkIsisPalindrome(stack, slow);
			}
			fast = fast.next.next;
		}
	}

	boolean checkIsisPalindrome(Stack<Integer> stack, ListNode slow) {
		while (slow != null && slow.val == stack.peek()) {
			stack.pop();
			slow = slow.next;
		}
		return stack.isEmpty() ? true : false;
	}
}
