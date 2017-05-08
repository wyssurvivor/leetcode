package com.ssdut.wys.q043;

/**
 * Created by Ryan on 17/5/8.
 */

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    public int trap(int[] height) {
        int  biggestIndex = -1, result = 0, biggest = 0;
        for(int i=0;i<height.length;i++) {
            if(height[i]>biggest) {
                biggest = height[i];
                biggestIndex = i;
            }
        }

        if(biggestIndex == -1) {
            return 0;
        }

        int left = 0;
        for(int i=1;i<=biggestIndex;i++) {
            if(height[i]>=height[left]) {
                if(height[left]>0) {
                    int internalResult = 0;
                    for(int j=left;j<i;j++) {
                        internalResult+=height[left]-height[j];
                    }
                    result+=internalResult;
                }
                left = i;
            }
        }

        int right = height.length-1;
        for(int i=height.length-2;i>=biggestIndex;i--) {
            if(height[i]>=height[right]) {
                if(height[right] > 0) {
                    int internalResult = 0;
                    for(int j=right;j>i;j--) {
                        internalResult+=height[right]-height[j];
                    }
                    result+=internalResult;
                }
                right = i;
            }
        }

        return result;
    }

    public static void main(String [] args) {
        int[] nums = new int[]{2,0,2};
        Solution solution = new Solution();
        System.out.println(solution.trap(nums));
    }

}
