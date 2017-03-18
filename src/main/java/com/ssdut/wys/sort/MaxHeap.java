package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/3/18.
 */
public class MaxHeap {
    private List<Integer> datas;
    private int length;

    public MaxHeap(List<Integer> valList) {
        this.datas = valList;
        this.length = this.datas.size();
    }

    public void maxHeapify(int index) {
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;
        int largestIndex = index;
        if (leftIndex<this.length&&datas.get(leftIndex)>datas.get(largestIndex)) {
            largestIndex = leftIndex;
        }
        if(rightIndex<this.length&&datas.get(rightIndex)>datas.get(largestIndex)) {
            largestIndex = rightIndex;
        }

        if(largestIndex != index) {
            swap(largestIndex,index);
            maxHeapify(largestIndex);
        }
    }

    public void makeHeap() {
        for(int i= this.length/2-1;i>=0;i--) {
            maxHeapify(i);
        }
    }

    public void swap(int index1,int index2) {
        int temp = datas.get(index1);
        datas.set(index1,datas.get(index2));
        datas.set(index2, temp);
    }

    public void printList() {
        for (int i = 0; i < datas.size(); i++) {
            System.out.print(datas.get(i) + ",");

        }

        System.out.println();

    }

    public int decreLength() {
        return --this.length;
    }

    public int increLength() {
        return ++this.length;
    }

    public List<Integer> getDatas() {
        return this.datas;
    }

    public static void main(String [] args) {
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        MaxHeap heap = new MaxHeap(valList);
        heap.printList();
        heap.makeHeap();
        heap.printList();
    }

}
