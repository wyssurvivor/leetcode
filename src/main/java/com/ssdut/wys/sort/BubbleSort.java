package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/3/15.
 */
public class BubbleSort {

    public void sort(List<Integer> list) {
        for(int i=0;i<list.size()-1;i++) {
            for(int j=list.size()-1;j>i;j--) {
                if(list.get(j)<list.get(j-1)) {
                    swap(list, j, j-1);
                }
            }
        }
    }

    public void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        sort.printList(valList);
        sort.sort(valList);
        sort.printList(valList);
    }
}
