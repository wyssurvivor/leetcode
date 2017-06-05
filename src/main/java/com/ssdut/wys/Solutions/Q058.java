package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/1.
 */

import org.junit.Test;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Q058 {
    public int lengthOfLastWord(String s) {

        int len = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == ' ') {
                if(len == 0) {
                    continue;
                } else {
                    break;
                }
            }

            len++;
        }

        return len;
    }

    @Test
    public void testSolution() {
        Q058 solution = new Q058();
        String s="hello  ";
        System.out.println(solution.lengthOfLastWord(s));
    }
}
