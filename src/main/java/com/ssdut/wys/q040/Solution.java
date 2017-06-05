package com.ssdut.wys.q040;

/**
 * Created by Ryan on 17/5/6.
 */

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<String> satisfied = new HashSet<String>();
        List<Integer> possible = new ArrayList<Integer>();
        find(res, possible, satisfied, 0, target, candidates);
        return res;
    }

    private void find(List<List<Integer>> result, List<Integer> possible, Set<String> satisfied, int index, int target, int[] candidates) {
        if (target == 0) {
            addToResult(result, possible, satisfied);
        } else if (target < 0) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        if (target - candidates[index] >= 0) {
            possible.add(candidates[index]);
            find(result, possible, satisfied, index + 1, target - candidates[index], candidates);
            possible.remove(possible.size() - 1);
            find(result, possible, satisfied, index + 1, target, candidates);
        }
    }

    private void addToResult(List<List<Integer>> result, List<Integer> possible, Set<String> satisfied) {
        ArrayList<Integer> list = new ArrayList<Integer>(possible);
        if (list.size() == 0) {
            return;
        }
        String str = generateStr(list);
        if (satisfied.contains(str)) {
            return;
        } else {
            satisfied.add(str);
            result.add(list);
        }

    }

    private String generateStr(List<Integer> possible) {
        String str = null;
        for (int i = 0; i < possible.size(); i++) {
            if (null == str) {
                str = possible.get(i) + "";
            } else {
                str += "_" + possible.get(i);
            }
        }

        return str;
    }

    public void print(List<List<Integer>> lList) {
        for (int i = 0; i < lList.size(); i++) {
            for (int j = 0; j < lList.get(i).size(); j++) {
                System.out.print(lList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(nums, target);
        solution.print(res);
    }
}
