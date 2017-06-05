package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 17/5/13.
 */
/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class q046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        find(result, nums, 0);
        return result;
    }

    public void find(List<List<Integer>> result, int[] nums, int index) {
        if(index>=nums.length) {
            addToResult(result, nums);
            return;
        }

        for(int i=index;i<nums.length;i++) {
            swap(nums, index, i);
            find(result, nums, index+1);
            swap(nums,index, i);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void addToResult(List<List<Integer>> result , int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }

        result.add(list);
    }

    public void print(List<List<Integer>> result) {
        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testSolution() {
        int[] nums = new int[] {1,2,3,4};
        q046 solution = new q046();
        solution.print(solution.permute(nums));
    }
}
