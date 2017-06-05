package com.ssdut.wys.q148;

/**
 * Created by wangyongshan on 17-3-20.
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = partition(head);
        ListNode head1 = head;
        ListNode head2 = node.next;
        node.next = null;
        return mergeList(sortList(head1), sortList(head2));
    }

    public ListNode partition(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        return n1;
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode pointer = null;
        while (head1 != null && head2 != null) {
            ListNode theNode = null;
            if (head1.val < head2.val) {
                theNode = head1;
                head1 = head1.next;
            } else {
                theNode = head2;
                head2 = head2.next;
            }
            if (head == null) {
                head = pointer = theNode;
            } else {
                pointer.next = theNode;
                pointer = theNode;
            }

            theNode.next = null;

        }

        if (head1 == null) {
            pointer.next = head2;
        }

        if (head2 == null) {
            pointer.next = head1;
        }

        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Solution solution = new Solution();
        ListNode head = solution.sortList(n5);
        solution.printList(head);
    }
}
