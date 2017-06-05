package com.ssdut.wys.q023;

/**
 * Created by Ryan on 17/4/16.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }


    /**
     * e time limit
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length == 0) {
            return null;
        }
        ListNode head = null,iter=null;

        while(true) {
            ListNode target = null;
            int index = -1;
            for(int i=0;i<lists.length;i++) {
                if(lists[i]!=null) {
                    if(target==null||lists[i].val < target.val) {
                        index = i;
                        target = lists[i];
                    }
                }
            }

            if(target==null) {
                break;
            }

            lists[index] = lists[index].next;
            target.next = null;

            if(head == null) {
                head=iter=target;
            } else {
                iter.next = target;
                iter=target;
            }
        }

        return head;
    }

    /**
     * copied from web.use a priority queue
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){

            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }



    public void printList(ListNode head) {
        while(head!=null) {
            System.out.println(head.val+" ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(33);
        l11.next = l12;l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(9);
        l21.next = l22;l22.next = l23;

        ListNode l31 = new ListNode(10);
        ListNode l32 = new ListNode(45);
        l31.next = l32;

        ListNode[] nodes = new ListNode[] {l11, l21, l31};

        Solution solution = new Solution();
        solution.printList(solution.mergeKLists2(nodes));
    }
}
