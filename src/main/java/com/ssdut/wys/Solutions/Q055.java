package com.ssdut.wys.Solutions;

import org.junit.Test;

/**
 * Created by Ryan on 17/5/21.
 */
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class Q055 {

    public boolean canJump(int[] nums) {
        if(nums.length == 0) {
            return true;
        }
        int tempLen = 0;
        int index = 0;
        while(index<=tempLen&&index<nums.length) {
            if(index+nums[index] >= nums.length) {
                return true;
            }

            tempLen = Math.max(tempLen, index+nums[index]);
            index++;
        }
        if(index == nums.length) {
            return true;
        }
        return false;
    }

    @Test
    public void testSolution() {
        int[] nums = new int[]{0};
        Q055 solution = new Q055();
        System.out.println(solution.canJump(nums));
    }
}
