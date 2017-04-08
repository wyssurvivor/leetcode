package com.ssdut.wys.q008;

/**
 * Created by Ryan on 17/4/2.
 */

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        long result=0;
        int sign = 1;
        int index=0;
        if(str.length()==0) {
            return 0;
        }

        if(str.charAt(0)=='-'||str.charAt(0)=='+') {
            index++;
            if(str.charAt(0)=='-') {
                sign=-1;
            }
        }

        for(;index<str.length();index++) {
            if(str.charAt(index)<'0'||str.charAt(index)>'9') {
                break;
            }
            int num = str.charAt(index)-'0';
            result=10*result+num;
            if(result*sign<Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if(result*sign>Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if(result == 0) {
            return 0;
        }
        return (int)result*sign;
    }

    public static void main(String[] args) {
        String s="7843400";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(s));
    }
}
