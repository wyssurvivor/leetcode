package com.ssdut.wys.q038;

/**
 * Created by Ryan on 17/5/4.
 */

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        int count =1;
        while(count<n) {
            String internalRes = "";
            int index = 0;
            int numberCount = 0;
            while(index<res.length()) {
                if(index+1>=res.length()||res.charAt(index) != res.charAt(index+1)) {
                    numberCount++;
                    internalRes+=String.valueOf(numberCount)+res.charAt(index);
                    numberCount =0;
                } else  {
                    numberCount++;
                }
                index++;
            }

            res = internalRes;
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(n-1));
        System.out.println(solution.countAndSay(n));
    }
}
