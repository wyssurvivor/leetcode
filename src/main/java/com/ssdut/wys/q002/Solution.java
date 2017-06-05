package com.ssdut.wys.q002;

/**
 * Created by Ryan on 17/3/31.
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead=null;
        ListNode resultIter=null;
        ListNode iter1=l1,iter2=l2;

        int jinwei = 0;

        while(iter1!=null||iter2!=null) {
            int sum = jinwei;
            if(iter1!=null) {
                sum+=iter1.val;
                iter1=iter1.next;
            }

            if(iter2!=null) {
                sum+=iter2.val;
                iter2=iter2.next;
            }

            ListNode node = new ListNode(sum%10);
            if(resultHead==null) {
                resultHead=resultIter=node;
            } else {
                resultIter.next=node;
                resultIter=node;
            }
            jinwei=sum/10;
        }

        if(jinwei>0) {
            ListNode node = new ListNode(jinwei);
            resultIter.next=node;
        }

        return resultHead;
    }

    public void print(ListNode head) {
        while(head!=null) {
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static void main(String [] args) {
        ListNode n11 = new ListNode(5);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);
//        n11.next=n12;
//        n12.next=n13;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
//        n21.next=n22;
//        n22.next=n23;

        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(n11, n21);
        solution.print(node);
    }
}
