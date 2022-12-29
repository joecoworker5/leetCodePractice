package com.cathaybk.practice.leetCode.linkedList;

public class LinkedList {
   

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public LinkedList(int val) {
        head = new ListNode();
        head.val = val;
        head.next = null;
    }

    public LinkedList() {
        head = new ListNode();
        head.next = null;
    }

    public void deletefront() {
        if (head != null) {
            head = head.next;
        }
    }

    public void deleteback() {
        ListNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = null;
    }

    public void delete(int val) {
        ListNode n = head;
        //假設要刪的為front
        ListNode previous = null;
        while (n != null) {
            if (previous == null && n.val == val) {
                head = head.next;
                n = head;
            } else if (n.val == val) {
                previous.next = n.next;
                n = n.next;
            } else {
                previous = n;
                n = n.next;
            }
        }

    }

    public void pushfront(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = head;
        head = node;
    }

    public void pushback(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = null;
        ListNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode preceding = head.next;

        while (preceding != null) {
            current.next = previous;
            previous = current;
            current = preceding;
            preceding = preceding.next;
        }

        current.next = previous;
        this.head = current;
        return current;
    }

    public void print() {
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
