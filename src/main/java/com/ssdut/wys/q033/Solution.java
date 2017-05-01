package com.ssdut.wys.q033;

/**
 * Created by Ryan on 17/5/1.
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<1) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        while(start<end) {
            int mid = (start+end)/2;
            if(nums[start] == target ) {
                return start;
            }
            if(nums[end] == target ) {
                return end;
            }
            if(nums[mid] == target ) {
                return mid;
            }

            if(nums[start]<nums[end]) {
                if(nums[mid]<target) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            } else if(nums[start] < nums[mid]) {
                if(nums[mid]>target&&nums[start]<target) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(nums[mid]<target&&nums[end]>target) {
                    start = mid+1;
                } else {
                    end = mid -1;
                }
            }
        }

        if(nums[start] == target) {
            return start;
        }


        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1};
        int target = 1;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}
