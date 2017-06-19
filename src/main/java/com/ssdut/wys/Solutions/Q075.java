package com.ssdut.wys.Solutions;

/**
 * Created by wangyongshan on 17-6-19.
 */

import org.junit.Test;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class Q075 {
    public void sortColors(int[] nums) {
        int begin = 0, end = nums.length-1;
        int index = 0;
        while(index<=end) {
            if(nums[index] == 0) {
                while(nums[begin]==0&&begin<index) {
                    begin++;
                }
                int tmp = nums[begin];
                nums[begin] = nums[index];
                nums[index] = tmp;
                index++;
            } else if(nums[index] == 2) {
                while(nums[end]==2&&end>index) {
                    end--;
                }
                int tmp = nums[end];
                nums[end] = nums[index];
                nums[index] = tmp;
                if(end == index) {
                    index++;
                }
            } else {
                index++;
            }
        }
    }

    public void print(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }

        System.out.println();
    }

    @Test
    public void testSolution() {
        Q075 solution = new Q075();
        int[] nums = new int[]{1,0};
        solution.sortColors(nums);
        solution.print(nums);
    }
}
