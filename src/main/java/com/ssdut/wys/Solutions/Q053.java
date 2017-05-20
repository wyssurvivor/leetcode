package com.ssdut.wys.Solutions;

import org.junit.Test;

/**
 * Created by Ryan on 17/5/17.
 */
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 */
public class Q053 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            if(sum+nums[i]>result) {
                result = sum+nums[i];
            }

            if(sum+nums[i] < 0) {
                sum = 0;
            } else {
                sum+=nums[i];
            }
        }

        return result;
    }

    @Test
    public void testSolutionm() {
        int[] nums = new int[] {-2,1};
        Q053 solution =new Q053();
        System.out.println(solution.maxSubArray(nums));
    }
}
