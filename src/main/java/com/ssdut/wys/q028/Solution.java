package com.ssdut.wys.q028;

/**
 * Created by Ryan on 17/4/29.
 */

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    //use kmp
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) {
            return 0;
        } else if(needle.length()==haystack.length()&&!needle.equals(haystack)) {
            return -1;
        }
        int [] next = getNext(needle);
        int j=0;
        for(int i=0;i<haystack.length();i++) {
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)) {
                j=next[j];
            }

            if(haystack.charAt(i)==needle.charAt(j)) {
                j++;
            }

            if(j==needle.length()) {
                return i-j+1;
            }
        }

        return -1;
    }

    private int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len+1];
        next[0] = next[1] = 0;
        int j = 0;
        for(int i=1;i<len;i++) {
            while(j>0&&needle.charAt(i)!=needle.charAt(j)) {
                j = next[j];
            }

            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i+1] = j;
        }

        return next;
    }

    public static void main(String [] args) {
        String haystack="";
        String needle="";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }
}
