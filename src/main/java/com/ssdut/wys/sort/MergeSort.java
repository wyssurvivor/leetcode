package com.ssdut.wys.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyongshan on 17-3-15.
 */
public class MergeSort {

    public void sort(List<Integer> list, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(list, start, mid);
            sort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    public void merge(List<Integer> list, int start, int mid, int end) {
        List<Integer> lList = new ArrayList<Integer>();
        List<Integer> rList = new ArrayList<Integer>();
        for (int i = start; i <= mid; i++) {
            lList.add(list.get(i));
        }
        for (int i = mid + 1; i <= end; i++) {
            rList.add(list.get(i));
        }

        int index1 = 0, index2 = 0;
        int index = start;
        while (index <= end && index1 < lList.size() && index2 < rList.size()) {
            if (lList.get(index1) < rList.get(index2)) {
                list.set(index, lList.get(index1++));
            } else {
                list.set(index, rList.get(index2++));
            }
            index++;
        }

        if (index1 == lList.size()) {
            while (index2 < rList.size()) {
                list.set(index++, rList.get(index2++));
            }
        }

        if (index2 == rList.size()) {
            while (index1 < lList.size()) {
                list.set(index++, lList.get(index1++));
            }
        }
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0, 789,-4);
        sort.printList(valList);
        sort.sort(valList,0,valList.size()-1);
        sort.printList(valList);
    }
}
