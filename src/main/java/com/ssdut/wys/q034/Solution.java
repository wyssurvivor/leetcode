package com.ssdut.wys.q034;

/**
 * Created by Ryan on 17/5/1.
 */

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1) {
            return new int[]{-1,-1};
        }
        int start =0,end=nums.length-1;
        int rangeStart = -1,rangeEnd = -1;
        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                if(mid-1<0||nums[mid-1]!=target) {
                    start = mid;
                    break;
                } else {
                    end = mid-1;
                }
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        if(nums[start] == target) {
            rangeStart = start;
        }
        if(rangeStart == -1) {
            return new int[]{rangeStart, rangeEnd};
        }

        start = 0;
        end = nums.length-1;
        while(start<end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                if(mid+1>=nums.length||nums[mid+1]!=target) {
                    end = mid;
                    break;
                } else {
                    start = mid+1;
                }
            } else if(nums[mid]>target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        if(nums[end] == target) {
            rangeEnd = end;
        }

        return new int[]{rangeStart, rangeEnd};
    }

    public void printArray(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums=new int[]{};
        int target = 7;
        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);
        solution.printArray(result);
    }
}
