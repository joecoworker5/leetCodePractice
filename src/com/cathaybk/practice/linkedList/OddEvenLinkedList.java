package com.cathaybk.practice.linkedList;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode prevOdd = head;
        ListNode prevEven = head.next;
        while (evenNode != null && evenNode.next != null) {
            evenNode = evenNode.next.next;
            oddNode = oddNode.next.next;

            prevEven.next = evenNode;
            prevOdd.next = oddNode;

            prevEven = prevEven.next;
            prevOdd = prevOdd.next;
        }

        oddNode.next = newHead;
        return head;
    }
}
