package com.ssdut.wys.q003;

/**
 * Created by Ryan on 17/3/31.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> record = new HashMap<Character, Integer>();
        int maxLength=0;
        int begin=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(record.get(c)!=null&&record.get(c)>=begin) {
                begin=record.get(c)+1;
            } else {
                if(i-begin+1>maxLength) {
                    maxLength = i-begin+1;
                }
            }
            record.put(c, i);
        }


        return maxLength;
    }

    public static void main(String[] args) {
        String s= "tmmzuxt";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
