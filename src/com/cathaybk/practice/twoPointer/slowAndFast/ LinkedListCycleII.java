package com.cathaybk.practice.twoPointer.slowAndFast;

class  LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast.next==null || fast.next.next==null){
            return null;
        }
        

        // tricky
        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
