package com.cathaybk.practice.leetCode.linkedList;

public class RotateList {

	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
//		root.next.next.next = new ListNode(4);
//		root.next.next.next.next = new ListNode(5);
		ListNode rotateRight = new RotateList().rotateRight(root, 4);
		while (rotateRight != null) {
			System.out.println(rotateRight.val);
			rotateRight = rotateRight.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		int size = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			size++;
		}
		k = k % size;
		if (size == k) {
			return head;
		}
		int count = 0;
		ListNode cur = head;
		ListNode newHead = null;
		while (cur != null) {
			if (++count == size - k) {
				newHead = cur.next;
				cur.next = null;
				break;
			}
			cur = cur.next;
		}
		tail.next = head;

		return newHead;
	}

}
