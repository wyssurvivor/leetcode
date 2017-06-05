package com.ssdut.wys.q021;

/**
 * Created by Ryan on 17/4/15.
 */

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) {
            return null;
        } else if(l1==null) {
            return l2;
        } else if(l2==null){
            return l1;
        }
        ListNode head = null,iter = null;
        while(l1!=null&&l2!=null) {
            ListNode target = null;
            if(l1.val<=l2.val) {
                target = l1;
                l1=l1.next;
            } else {
                target = l2;
                l2= l2.next;
            }

            if(head == null) {
                head = iter = target;
            } else {
                iter.next = target;
                iter = target;
            }

            iter.next=null;
        }

        if(l1==null&&l2!=null) {
            iter.next = l2;
        }
        if(l2==null&&l1!=null) {
            iter.next = l1;
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
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(8);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;

        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(n1,null);
        solution.printList(head);
    }
}
