package com.ssdut.wys.q014;

/**
 * Created by Ryan on 17/4/8.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int len = 0;
        while(len<strs[0].length()) {
            int i=0;
            if(strs[i].length()==0) {
                return "";
            }
            char c = strs[0].charAt(len);
            for(;i<strs.length;i++) {
                if(len>=strs[i].length()||strs[i].charAt(len) != c) {
                    break;
                }
            }

            if(i==strs.length) {
                len++;
            } else {
                break;
            }
        }

        return strs[0].substring(0, len);
    }

    public static void main(String[] args) {
        String[] strs = new String[] {""};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
