package com.ssdut.wys.sort;

/**
 * Created by Ryan on 17/3/19.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

public class MyList {
    private ListNode head;

    public MyList() {
        this.head = null;
    }

    public MyList(ListNode head) {
        this.head = head;
    }

    public ListNode search(int val) {
        ListNode p = this.head;
        while (p != null) {
            if (p.val == val) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    //insert value at the beginning
    public void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (this.head == null) {
            head = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    public void delete(int val) {
        ListNode theNode = search(val);
        if (null == theNode) {
            return;
        }

        if (theNode.prev != null) {
            theNode.prev.next = theNode.next;
        }

        if (theNode.next != null) {
            theNode.next.prev = theNode.prev;
        }

        if (this.head == theNode) {
            this.head = theNode.next;
        }

        theNode.next = theNode.prev = null;
    }

    public void print() {
        ListNode p = this.head;
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println();
    }

    public void printInversed() {
        ListNode p = this.head;
        while (p.next != null) {
            p = p.next;
        }

        while (p != null) {
            System.out.print(p.val + ",");
            p = p.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        MyList myList = new MyList();
        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.print();
        myList.printInversed();
        myList.delete(3);
        myList.print();
        myList.printInversed();
//        System.out.println(myList.search(2).val);
    }
}
