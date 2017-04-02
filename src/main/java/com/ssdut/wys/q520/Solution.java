package com.ssdut.wys.q520;

/**
 * Created by Ryan on 17/3/28.
 */

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2) {
            return true;
        }

        int mode = detectMode(word);
        if(mode>3) {
            return false;
        }

        if(mode == 1) {
            for(int i=2;i<word.length();i++) {
                if(!Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for(int i=2;i<word.length();i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public int detectMode(String word) {
        if(Character.isUpperCase(word.charAt(0))&&Character.isUpperCase(word.charAt(1))) {
            return 1;
        } else if(Character.isUpperCase(word.charAt(0))) {
            return 3;
        } else if(Character.isUpperCase(word.charAt(1))){
            return 4;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("usA"));
    }
}
