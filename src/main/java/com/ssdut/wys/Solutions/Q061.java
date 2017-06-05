package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/3.
 */

import org.junit.Test;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL
 */
public class Q061 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| k == 0) {
            return head;
        }

        int len = getLength(head);
        k = k%len;
        ListNode pre = head, post = head;
        int count = 0;
        while(count<k) {
            post = post.next;
            if(post == null) {
                post = head;
            }

            count++;
        }

        if(post == pre) {
            return head;
        }

        while(post.next!=null) {
            pre= pre.next;
            post = post.next;
        }

        ListNode tmp = pre.next;
        post.next = head;
        pre.next = null;
        return tmp;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while(head!=null) {
            head = head.next;
            len++;
        }

        return len;
    }

    public void print(ListNode head) {
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    @Test
    public void testSolution() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Q061 solution = new Q061();
        solution.print(solution.rotateRight(n1, 5));
    }
}
