package com.ssdut.wys.q024;

/**
 * Created by Ryan on 17/4/17.
 */

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }

        ListNode n1 = head, n2 = head.next;
        ListNode newHead = null, tail = null;
        while(n1!=null&&n2!=null) {
            ListNode next = n2.next;
            n2.next=n1;
            n1.next=null;
            if(n1==head) {
                newHead=n2;
                tail=n1;
            } else {
                tail.next = n2;
                tail = n1;
            }

            n1=next;
            if(n1!=null) {
                n2=n1.next;
            }
        }

        if(n1!=null) {
            tail.next = n1;
        }

        return newHead;
    }

    public void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;

        Solution solution = new Solution();
        solution.printList(solution.swapPairs(n1));
    }
}
