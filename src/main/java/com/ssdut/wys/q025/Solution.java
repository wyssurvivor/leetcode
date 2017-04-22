package com.ssdut.wys.q025;

/**
 * Created by Ryan on 17/4/22.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode newHead = null, newTail = null;
        ListNode begin = head, end = head;
        int count = 1;
        while (end != null) {
            count++;
            end = end.next;
            if (count >= k&&end!=null) {
                ListNode next = end.next;
                end.next = null;
                ListNode internalHead = doReverse(begin, end.next);
                if (newHead == null) {
                    newHead = internalHead;
                    newTail = begin;
                } else {
                    newTail.next = internalHead;
                    newTail = begin;
                }
                end = begin = next;
                count = 1;
            }
        }
        if(newHead==null) {
            newHead=head;
        } else {
            newTail.next = begin;
        }

        return newHead;
    }

    public ListNode doReverse(ListNode begin, ListNode end) {
        ListNode pre = null, iter = begin;
        while (iter != end) {
            ListNode next = iter.next;
            iter.next = pre;
            pre = iter;
            iter = next;
        }

        return pre;
    }

    public void prindList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;

        Solution solution = new Solution();
        solution.prindList(solution.reverseKGroup(l1, 3));
    }
}
