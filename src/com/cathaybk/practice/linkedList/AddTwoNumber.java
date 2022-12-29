package com.cathaybk.practice.leetCode.linkedList;

public class AddTwoNumber {

    public static void main(String[] args) {
        LinkedList listOne = new LinkedList(9);
        listOne.pushfront(9);
        listOne.pushfront(9);
        listOne.pushfront(9);
        listOne.pushfront(9);
        listOne.pushfront(9);
        listOne.pushfront(9);
        LinkedList listTwo = new LinkedList(9);
        listTwo.pushfront(9);
        listTwo.pushfront(9);
        listTwo.pushfront(9);
        ListNode newhead = new AddTwoNumber().addTwoNumbers(listOne.getHead(), listTwo.getHead());
        System.out.println(newhead);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newhead1 = l1;
        ListNode newhead2 = l2;
        int quotient = 0;
        ListNode previous = null;
        ListNode newNode = null;
        ListNode first = null;
        while (newhead1 != null || newhead2 != null) {
            int sum = 0;
            if (newhead1 != null && newhead2 != null) {
                sum = newhead1.val + newhead2.val;
            } else if (newhead1 != null) {
                sum = newhead1.val;
            } else {
                sum = newhead2.val;
            }
            int remainder = (sum + quotient) % 10;
            newNode = new ListNode(remainder);
            newNode.next = previous;
            previous = newNode;
            quotient = (sum + quotient) / 10;
            newhead1 = newhead1 != null ? newhead1.next : newhead1;
            newhead2 = newhead2 != null ? newhead2.next : newhead2;
        }

        if (quotient != 0) {
            ListNode front = new ListNode(quotient);
            front.next = newNode;
            first = front;
        } else {
            first = newNode;
        }

        return reverseList(first);
    }

    //數字太大會爆掉
    public ListNode addTwoNumbersWrong(ListNode l1, ListNode l2) {
        ListNode newhead1 = reverseList(l1);
        String number1 = "";
        while (newhead1 != null) {
            number1 += newhead1.val;
            newhead1 = newhead1.next;
        }
        String number2 = "";
        ListNode newhead2 = reverseList(l2);
        while (newhead2 != null) {
            number2 += newhead2.val;
            newhead2 = newhead2.next;
        }
        Long total = Long.valueOf(number1) + Long.valueOf(number2);
        ListNode previous = null;
        for (int i = 0; i <= total.toString().length() - 1; i++) {
            ListNode listNode = new ListNode();
            listNode.next = previous;
            listNode.val = Integer.valueOf(total.toString().substring(i, i + 1));
            previous = listNode;
        }

        return previous;

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
        return current;
    }

}
