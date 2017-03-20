package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/3/18.
 */
public class QuickSort {

    public void sort(List<Integer> valList,int low,int high) {
        if(low<high) {
            int index=partition(valList, low, high);
            sort(valList, low, index-1);
            sort(valList,index+1, high);
        }
    }

    public int partition(List<Integer> valList,int low,int high) {
        int val = valList.get(high);
        int i = low-1;
        for(int j = low;j<=high-1;j++) {
            if(valList.get(j)<val) {
                swap(valList, ++i, j);

            }
        }

        swap(valList, ++i,high);
        return i;
    }

    public void swap(List<Integer> valList, int index1, int index2) {
        int temp = valList.get(index1);
        valList.set(index1,valList.get(index2));
        valList.set(index2, temp);
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        QuickSort sort = new QuickSort();
        sort.printList(valList);
        sort.sort(valList, 0, valList.size()-1);
        sort.printList(valList);
    }
}
