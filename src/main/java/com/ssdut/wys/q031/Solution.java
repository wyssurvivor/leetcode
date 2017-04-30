package com.ssdut.wys.q031;

/**
 * Created by Ryan on 17/4/30.
 */

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<2) {
            return;
        }
        int index = findFirstASCIndex(nums);
        if(index >= 0) {
            swapASCPair(nums, index);
        }

        Arrays.sort(nums, index+1, nums.length);
    }

    private void swapASCPair(int[] nums, int index) {
        int i = nums.length-1;
        for(;i>=0;i--) {
            if(nums[i]>nums[index]) {
                break;
            }
        }

        swap(nums, index, i);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private  int findFirstASCIndex(int[] nums) {
        int largest = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]<largest) {
                return i;
            } else if(nums[i]>largest) {
                largest = nums[i];
            }
        }

        return -1;
    }

    public void printArray(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        solution.printArray(nums);
    }
}
