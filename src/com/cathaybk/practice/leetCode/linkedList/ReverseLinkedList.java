package com.cathaybk.practice.leetCode.linkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);
        linkedList.pushfront(5);
        linkedList.pushfront(4);
        linkedList.pushfront(3);
        linkedList.pushfront(2);
        linkedList.pushfront(1);
        linkedList.pushfront(0);
        linkedList.pushback(20);
        linkedList.print();
        System.out.println("=========================");
        linkedList.delete(20);
        linkedList.delete(3);
        linkedList.print();
        System.out.println("=========================");
        linkedList.reverseList(linkedList.getHead());
        linkedList.print();
        
    }

}
