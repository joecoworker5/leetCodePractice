package com.cathaybk.practice.leetCode;

import com.cathaybk.practice.leetCode.linkedList.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 != null && l2 == null) {
			return l1;
		} else if (l1 == null && l2 != null) {
			return l2;
		}

		boolean firstTime = true;
		ListNode root =null;
		ListNode current = null;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				if (firstTime) {
					root = l1;
					current = l1;
					firstTime = false;
					l1 = l1.next;
					continue;
				}
				current.next = l1;
				current = l1;
				l1 = l1.next;
			} else {
				if (firstTime) {
					root = l2;
					current = l2;
					firstTime = false;
					l2 = l2.next;
					continue;
				}
				current.next = l2;
				current = l2;
				l2 = l2.next;
			}
			;
		}

		if (l1 == null) {
			current.next = l2;
		} else if (l2 == null) {
			current.next = l1;
		}
		
		return root;
	}

}
