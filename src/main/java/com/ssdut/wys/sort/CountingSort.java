package com.ssdut.wys.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/3/19.
 */
public class CountingSort {

    public List<Integer> sort(List<Integer> valList) {
        int[] buckets = new int[10];//number range from 0 to 9 in valList
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }
        for (int i = 0; i < valList.size(); i++) {
            buckets[valList.get(i)]++;
        }

        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        List<Integer> resultList = new ArrayList<Integer>(valList.size());
        for (int i = 0; i < valList.size(); i++) {
            resultList.add(0);
        }
        for (int i = valList.size() - 1; i >= 0; i--) {
            resultList.set(buckets[valList.get(i)-1], valList.get(i));
            buckets[valList.get(i)]--;
        }

        return resultList;
    }

    public void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");

        }

        System.out.println();

    }

    public static void main(String[] args) {
        List<Integer> valList = Arrays.asList(6, 3, 2, 8, 1, 0);
        CountingSort sort = new CountingSort();
        sort.printList(valList);
        List<Integer> resultList = sort.sort(valList);
        sort.printList(resultList);
    }
}
