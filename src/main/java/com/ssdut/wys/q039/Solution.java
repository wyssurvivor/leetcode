package com.ssdut.wys.q039;

/**
 * Created by Ryan on 17/5/4.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]

 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> possible = new ArrayList<Integer>();
        find(result, possible, candidates, target, 0);

        return result;
    }

    public void find(List<List<Integer>> result, List<Integer> possible, int[] candidates, int left, int index) {
        if(left == 0) {
            if(possible.size()>0) {
                addToResult(result, possible);
            }

            return ;
        } else if(left < 0) {
            return ;
        }

        if(index>=candidates.length) {
            return;
        }


        int count = 0;
        do {
            find(result, possible, candidates, left, index+1);
            left -= candidates[index];
            possible.add(candidates[index]);
            count++;

        }
        while(left>=0) ;
        while(count > 0) {
            possible.remove(possible.size()-1);
            count--;
        }

    }

    public void addToResult(List<List<Integer>> result, List<Integer> possible) {
        List<Integer> newList = new ArrayList<Integer>(possible);
        result.add(newList);
    }

    public void print(List<List<Integer>> lList) {
        for(int i=0;i<lList.size();i++) {
            for(int j=0;j<lList.get(i).size();j++) {
                System.out.print(lList.get(i).get(j)+" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,6,7};
        int target = 7;

        Solution solution = new Solution();
        solution.print(solution.combinationSum(nums, target));
    }
}
