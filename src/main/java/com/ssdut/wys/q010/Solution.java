package com.ssdut.wys.q010;

/**
 * Created by Ryan on 17/4/9.
 */

/**
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */


/**
 * ATTENTION:WRONG ANSWER
 * case aaa,a*a
 * should use dynamic programming
 * need redo
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0;
        while(sIndex<s.length()&&pIndex<p.length()) {
            if(s.charAt(sIndex) == p.charAt(pIndex)) {
                sIndex++;
                pIndex++;
            } else if(p.charAt(pIndex) == '.') {
                sIndex++;
                pIndex++;
            } else if(p.charAt(pIndex) == '*') {
                if(pIndex+1<p.length()&&p.charAt(pIndex+1)==s.charAt(sIndex)) {
                    pIndex++;
                }else {
                    if(p.charAt(pIndex-1)!='.' && sIndex-1>=0 && s.charAt(sIndex-1) == s.charAt(sIndex)) {
                        sIndex++;
                    } else if(p.charAt(pIndex-1) == '.') {
                        sIndex++;
                    } else {
                        break;
                    }
                }

            } else if(pIndex+1<p.length()&&p.charAt(pIndex+1)=='*'){
                pIndex++;
            } else {
                break;
            }
        }

        if(sIndex==s.length()){
            if(pIndex==p.length()||(pIndex==p.length()-1 && p.charAt(pIndex)=='*')) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*a";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
