package com.cathaybk.practice.leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<ListNode>();
		while (headA != null || headB != null) {
			if (headA != null && !set.add(headA)) {
				return headA;
			}
			if (headB != null && !set.add(headB)) {
				return headB;
			}
			headA = headA != null ? headA.next : headA;
			headB = headB != null ? headB.next : headB;
		}

		return null;
	}
}
