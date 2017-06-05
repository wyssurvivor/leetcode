package com.ssdut.wys.q016;

/**
 * Created by Ryan on 17/4/9.
 */

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int absMinus = Integer.MAX_VALUE;
        for(int i=0 ;i < nums.length-2;i++) {
            int beg = i+1,end = nums.length-1;
            while(beg<end) {
                int sum = nums[i]+nums[beg]+nums[end];
                if(Math.abs(target-sum)<absMinus) {
                    absMinus=Math.abs(target-sum);
                    closest=sum;
                }

                if(sum>target) {
                    end--;
                } else if(sum<target) {
                    beg++;
                }else {
                    return target;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,0};
        int target = -100;
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
