package com.cathaybk.practice.twoPointer.slowAndFast;

class  LinkedListCycle {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        slow = nums[0];
        while(true){
            if(slow==fast){
                break;
            }
            slow = nums[slow];
            fast = nums[fast];

        }

        return slow;
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
