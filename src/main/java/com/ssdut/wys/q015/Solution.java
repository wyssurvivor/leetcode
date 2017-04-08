package com.ssdut.wys.q015;

import java.util.*;

/**
 * Created by Ryan on 17/4/8.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        Set<String> recordSet = new HashSet<String>();
        for(int i=0;i<nums.length;i++) {
            numMap.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {

                int sum = nums[i]+nums[j];
                if(numMap.get(-sum)!=null) {
                    if(numMap.get(-sum)<=i||numMap.get(-sum)<=j) {
                        continue;
                    }
                    int[] enums = new int[] {nums[i], nums[j], nums[numMap.get(-sum)]};
                    Arrays.sort(enums);
                    if(!recordSet.contains(enums[0]+"_"+enums[1]+"_"+enums[2])) {
                        result.add(Arrays.asList(enums[0], enums[1], enums[2]));
                        recordSet.add(enums[0]+"_"+enums[1]+"_"+enums[2]);
                    }
                }
            }
        }

        return result;
    }

    //copied from web,use 2sum as a sub func
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    private void add(List<List<Integer>> result, int[] nums) {

    }

    public void print(List<List<Integer>> result) {
        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                System.out.print(result.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum2(nums);
        solution.print(result);
    }
}
