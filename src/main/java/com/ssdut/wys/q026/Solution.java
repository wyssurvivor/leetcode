package com.ssdut.wys.q026;

/**
 * Created by Ryan on 17/4/22.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        int tail = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]==nums[i]) {
                duplicateCount++;
            }

            if(nums[i]>nums[tail]) {
                nums[++tail] = nums[i];
            }
        }

        return nums.length-duplicateCount;
    }

    public void printArray(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String [] args) {
        int [] array = new int[]{1,1,2,2,2,3};
        Solution solution =new Solution();
        solution.removeDuplicates(array);
        solution.printArray(array);
    }
}
