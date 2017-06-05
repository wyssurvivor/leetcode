package com.ssdut.wys.q027;

/**
 * Created by Ryan on 17/4/22.
 */

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == val) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }

        return nums.length-count;
    }

    public void printArray(int[] nums,int len) {
        for(int i=0;i<len;i++) {
            System.out.print(nums[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3,5,6,3,7};
        Solution solution = new Solution();
        int len = solution.removeElement(nums,3);
        solution.printArray(nums, len);
    }
}
