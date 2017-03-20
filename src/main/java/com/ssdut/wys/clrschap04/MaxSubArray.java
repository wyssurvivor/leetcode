package com.ssdut.wys.clrschap04;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyongshan on 17-3-16.
 */

class SubArrayResult {
    int low;
    int hith;
    int result;
    public SubArrayResult(int low, int high, int result) {
        this.low = low;
        this.hith = high;
        this.result = result;
    }
}
public class MaxSubArray {

    public SubArrayResult maximumSubArray(List<Integer> list, int low, int high) {
        if (low == high) {
            return new SubArrayResult(low, high, list.get(low));
        }

        int mid = (low + high) / 2;
        SubArrayResult leftResult = maximumSubArray(list, low, mid);
        SubArrayResult rightResult = maximumSubArray(list, mid + 1, high);
        SubArrayResult crossResult = maximumCrossingSubArray(list, low, mid, high);

        SubArrayResult finalResult = leftResult;
        if (finalResult.result < rightResult.result) {
            finalResult = rightResult;
        }
        if (finalResult.result < crossResult.result) {
            finalResult = crossResult;
        }

        return finalResult;
    }

    public SubArrayResult maximumCrossingSubArray(List<Integer> list, int low, int mid, int high) {
        int leftResult = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = 0;
        for (int i = mid; i >= low; i--) {
            sum += list.get(i);
            if (sum > leftResult) {
                leftResult = sum;
                leftIndex = i;
            }
        }

        sum = 0;
        int rightResult = Integer.MIN_VALUE;
        int rightIndex = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += list.get(i);
            if (sum > rightResult) {
                rightResult = sum;
                rightIndex = i;
            }
        }

        return new SubArrayResult(leftIndex, rightIndex, leftResult + rightResult);
    }

    public static void main(String[] args) {
        List<Integer> valList = Arrays.asList(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7);
        MaxSubArray sub = new MaxSubArray();
        SubArrayResult subArrayResult = sub.maximumSubArray(valList, 0, valList.size() - 1);
        System.out.println(subArrayResult.low + "-" + subArrayResult.hith + "-" + subArrayResult.result);
    }
}
