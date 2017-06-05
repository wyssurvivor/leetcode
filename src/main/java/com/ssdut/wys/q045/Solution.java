package com.ssdut.wys.q045;

/**
 * Created by Ryan on 17/5/12.
 */
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        for(int i=0;i<jumps.length;i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        jumps[0] = 0;
        for(int i=0;i<nums.length;i++) {
            int len = 0;
            while(len<=nums[i]&&len+i<nums.length) {
                if(jumps[i]+1<jumps[len+i]) {
                    jumps[len+i] = jumps[i]+1;
                }

                len++;
            }
        }

        return jumps[nums.length-1];
    }

    public int jump2(int[] nums) {
        int jumpCount = 0;
        int currentLen = 0;
        int nextLen = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>nextLen) {
                return -1;
            }
            if(i>currentLen) {
                currentLen = nextLen;
                jumpCount++;
            }
            if(i+nums[i] > nextLen) {
                nextLen = i+nums[i];
            }
        }

        return jumpCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        Solution solution = new Solution();
        System.out.println(solution.jump2(nums));
    }
}
