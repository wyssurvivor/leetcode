package com.ssdut.wys.q019;

/**
 * Created by Ryan on 17/4/15.
 */

import java.util.List;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode pre=null, beg = head, end = head;
        while(end!=null) {
            end = end.next;
            count++;
            if(count>n) {
                pre = beg;
                beg = beg.next;
            }
        }

        if(pre==null) {
            head = beg.next;
            beg.next=null;
        } else {
            pre.next = beg.next;
            beg.next = null;
        }

        return head;
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
        n4.next = n5;

        Solution solution = new Solution();
        ListNode head = solution.removeNthFromEnd(n1, 1);
        solution.printList(head);

    }
}
