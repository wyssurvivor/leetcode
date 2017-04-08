package com.ssdut.wys.q011;

/**
 * Created by Ryan on 17/4/5.
 */
public class Solution {
    public int maxArea(int[] height) {
        int beg = 0,end = height.length-1;
        int max = 0;

        while(beg<end) {
            if(Math.min(height[beg], height[end])*(end-beg) > max) {
                max = Math.min(height[beg], height[end]) * (end-beg);
            }

            if(height[beg] < height[end]) {
                beg++;
            } else {
                end--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int [] height = new int[]{1,3,2,4,3,1,2};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}
