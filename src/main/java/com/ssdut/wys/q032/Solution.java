package com.ssdut.wys.q032;

/**
 * Created by Ryan on 17/4/30.
 */

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


 */
public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int parCount = 0;
        int len = 0;
        int start = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                parCount++;
            } else {
                if(parCount>0) {
                    parCount--;
                    len+=2;
                } else {
                    parCount = 0;
                    if(len>result) {
                        result = len;
                    }
                    len = 0;
                    start = i+1;
                }
            }
        }

        if(len> result) {
            result = len;
        }

        return result;
    }


    public static void main(String[] args) {
        String str = "(()())())";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(str));
    }
}
