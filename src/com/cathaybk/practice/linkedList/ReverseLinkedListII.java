package com.cathaybk.practice.leetCode.linkedList;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {
        if(left==right){
            return head;
        }
        ListNode p = head;
        int count = 0;
        ListNode leftBefore = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode rightAfter = null;
        while (p != null) {
            count++;
            if (count == left - 1) {
                leftBefore = p;
            }
            if (count == left) {
                leftNode = p;
            }
            if (count == right) {
                rightNode = p;
            }
            if (count == right + 1) {
                rightAfter = p;
            }
            p = p.next;
        }

        reverse(leftNode, rightNode);

        if (leftBefore == null && rightAfter == null) {
            return rightNode;
        }
        else if (leftBefore == null) {
            leftNode.next = rightAfter;
            return rightNode;
        }
        else if (rightAfter == null) {
            leftBefore.next = rightNode;
            return head;
        }
        leftNode.next = rightAfter;
        leftBefore.next = rightNode;
        return head;

    }

    void reverse(ListNode leftNode,
                 ListNode rightNode) {
        ListNode prev = null;
        while (leftNode != rightNode) {
            ListNode temp = leftNode.next;
            leftNode.next = prev;
            prev = leftNode;
            leftNode = temp;
        }

        rightNode.next = prev;
    }

}
