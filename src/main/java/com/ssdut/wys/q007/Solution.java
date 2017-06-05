package com.ssdut.wys.q007;

/**
 * Created by Ryan on 17/4/2.
 */

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */
public class Solution {
    public int reverse(int x) {
        long value = x;
        long result = 0;
        boolean isMinus = false;
        if(value<0) {
            value=-value;
            isMinus = true;
        }

        while(value>0) {
            long left = value%10;
            result = result*10+left;
            value/=10;
        }

        if (isMinus) {
            result = -result;
        }

        if(result<Integer.MIN_VALUE||result>Integer.MAX_VALUE) {
            return 0;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        int x = 0;
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }
}
