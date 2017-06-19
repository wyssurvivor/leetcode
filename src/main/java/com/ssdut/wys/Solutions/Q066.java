package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/4.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Q066 {
    public int[] plusOne(int[] digits) {
        int[] digitList = new int[digits.length];
        int jw = 1;
        for(int i=digits.length-1;i>=0;i--) {
            int sum = digits[i] + jw;
            digitList[i] = sum%10;
            jw = sum/10;
        }

        if(jw>0) {
            int[] result = new int[digitList.length+1];
            for(int i=0;i<digitList.length;i++) {
                result[i+1] = digitList[i];
            }
            result[0] = jw;
            return result;
        } else {
            return digitList;
        }
    }

    public void print(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    @Test
    public void testSolution() {
        int[] digits = new int[]{9,1};
        Q066 solution = new Q066();
        solution.print(solution.plusOne(digits));
    }
}
