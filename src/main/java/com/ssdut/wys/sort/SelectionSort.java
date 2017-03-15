package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyongshan on 17-3-15.
 */
public class SelectionSort {

    public void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(index)) {
                    index = j;
                }
            }
            swap(list, index, i);
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
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        SelectionSort sort = new SelectionSort();
        sort.printList(valList);
        sort.sort(valList);
        sort.printList(valList);
    }
}
