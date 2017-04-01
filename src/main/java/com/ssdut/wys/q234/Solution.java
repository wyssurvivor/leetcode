package com.ssdut.wys.q234;

/**
 * Created by Ryan on 17/3/26.
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public boolean isPanlindrome(ListNode head) {
        if (head==null|| head.next==null) {
            return true;
        }

        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null) {
            p1=p1.next;
            p2=p2.next.next;
        }

        ListNode pre=null;
        ListNode node=p1.next;
        p1.next=null;
        while(node!=null) {
            ListNode next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }

        p1=head;p2=pre;
        while(p1!=null&&p2!=null) {
            if(p1.val!=p2.val) {
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(1);
//        ListNode n4=new ListNode(4);
//        ListNode n5=new ListNode(3);
//        ListNode n6=new ListNode(2);
//        ListNode n7=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//        n5.next=n6;
//        n6.next=n7;
        System.out.println(solution.isPanlindrome(n1));
    }
}
