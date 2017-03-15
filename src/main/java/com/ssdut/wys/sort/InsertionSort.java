package com.ssdut.wys.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyongshan on 17-3-15.
 */
public class InsertionSort {

    public void sort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            int j = i - 1;
            for (; j >= 0; j--) {
                if (list.get(j) > val) {
                    list.set(j + 1, list.get(j));
                } else {
                    break;
                }
            }
            list.set(j + 1, val);
        }
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        sort.printList(valList);
        sort.sort(valList);
        sort.printList(valList);
    }
}
