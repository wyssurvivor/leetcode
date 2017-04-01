package com.ssdut.wys.q540;

/**
 * Created by Ryan on 17/3/26.
 */
/*
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int beg=0,end=nums.length-1;
        while(end-beg>0) {
            int mid=(beg+end)/2;
            if(nums[mid-1]==nums[mid]) {
                if(mid%2==0){
                    end=mid-1;
                }else {
                    beg=mid+1;
                }
            } else if(nums[mid+1]==nums[mid]) {
                if(mid%2==1){
                    end=mid-1;
                } else {
                    beg=mid+1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[beg];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1};
        System.out.println(solution.singleNonDuplicate(nums));
    }
}
