package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/3/18.
 */
public class HeapSort {
    public void sort(List<Integer> valList) {
        MaxHeap heap = new MaxHeap(valList);
        heap.makeHeap();
        for(int i=valList.size()-1;i>0;i--) {
            heap.swap(0,i);
            heap.decreLength();
            heap.maxHeapify(0);
        }
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        HeapSort sort = new HeapSort();
        sort.printList(valList);
        sort.sort(valList);
        sort.printList(valList);
    }


}
