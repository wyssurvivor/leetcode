package com.ssdut.wys.q004;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyongshan on 17-4-1.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count = 0, iter1=0, iter2=0;
        List<Integer> numList = new ArrayList<Integer>();

        while(count<=(len1+len2)/2) {
            if(iter1>=len1) {
                numList.add(nums2[iter2++]);
            } else if(iter2>=len2) {
                numList.add(nums1[iter1++]);
            } else {
                if(nums1[iter1]<nums2[iter2]) {
                    numList.add(nums1[iter1++]);
                } else {
                    numList.add(nums2[iter2++]);
                }
            }

            count++;
        }

        if((len1+len2)<2){
            return numList.get(0);
        } else {
            if((len1+len2)%2==1) {
                return numList.get(numList.size()-1);
            } else {
                return (numList.get(numList.size()-1)+numList.get(numList.size()-2))/2.0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2,4};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
