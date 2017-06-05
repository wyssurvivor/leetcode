package com.ssdut.wys.q001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 17/3/31.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            record.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++) {
            Integer left = record.get(target-nums[i]);
            if(left!=null&&i!=left) {
                if(i<left) {
                    return new int[]{i,left};
                } else {
                    return new int[]{left, i};
                }
            }
        }

        return null;
    }

    public void print(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int []nums = new int[] {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        solution.print(solution.twoSum(nums, target));
    }
}
