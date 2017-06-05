package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ryan on 17/5/13.
 */
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class q047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> set = new HashSet<String>();
        find(result, nums, 0, set);
        return result;
    }

    public void find(List<List<Integer>> result, int[] nums, int index, Set<String> set) {
        if(index>=nums.length) {
            addToResult(result, nums, set);
            return;
        }

        for(int i=index;i<nums.length;i++) {
            swap(nums, index, i);
            find(result, nums, index+1, set);
            swap(nums,index, i);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void addToResult(List<List<Integer>> result , int[] nums, Set<String> set) {
        String key = getKey(nums);
        if(set.contains(key)) {
            return;
        } else {
            set.add(key);
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++) {
                list.add(nums[i]);
            }

            result.add(list);
        }

    }

    public String getKey(int[] nums) {
        String str = null;
        for(int i=0;i<nums.length;i++) {
            if(str == null) {
                str = nums[i]+"";
            } else {
                str+="_"+nums[i];
            }
        }

        return str;
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
        int[] nums = new int[] {1,1,2};
        q047 solution = new q047();
        solution.print(solution.permuteUnique(nums));
    }
}
