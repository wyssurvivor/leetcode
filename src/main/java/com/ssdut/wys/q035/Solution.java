package com.ssdut.wys.q035;

/**
 * Created by Ryan on 17/5/2.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length-1;
        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target){
                if(mid-1<0 || nums[mid-1] < target) {
                    return mid;
                }

                end = mid-1;
            } else {
                if(mid+1>=nums.length || nums[mid+1] >= target) {
                    return mid+1;
                }

                start = mid+1;
            }
        }

        if(nums[start] >= target) {
            return start;
        } else {
            return start+1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        int target = 4;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));
    }
}
