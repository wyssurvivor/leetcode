package com.ssdut.wys.q143;

/**
 * Created by wangyongshan on 17-3-15.
 */

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Subscribe to see which companies asked this question.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        ListNode pre = null;
        while (pointer2 != null && pointer2.next != null) {
            pre = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        pre.next = null;

        pre = null;
        ListNode node = pointer1;

        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        pointer1 = head;
        pointer2 = pre;
        while (pointer1 != null && pointer2 != null) {
            ListNode next1 = pointer1.next;
            ListNode next2 = pointer2.next;
            pointer1.next = pointer2;
            if (next1 != null) {
                pointer2.next = next1;
            }
            pointer1 = next1;
            pointer2 = next2;
        }

    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
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
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        Solution solution = new Solution();
        solution.printList(n1);
        solution.reorderList(n1);
        solution.printList(n1);
    }
}
