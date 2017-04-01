package com.ssdut.wys.q349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan on 17/3/27.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersaction = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                i++;
            } else if(nums1[i]>nums2[j]) {
                j++;
            } else {
                intersaction.add(nums1[i]);
                i++;
                j++;
            }
        }
        int [] result = new int[intersaction.size()];
        i=0;
        for (Integer num : intersaction) {
            result[i++] = num;
        }
        return result;
    }

    public void printArray(int [] nums){
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        int[] nums1=new int[]{1,1,2,2};
        int[] nums2=new int[]{3,2,4,};
        int[] result = solution.intersection(nums1,nums2);
        solution.printArray(result);
    }
}
