package com.ssdut.wys.Solutions;

/**
 * Created by wangyongshan on 17-6-5.
 */

import org.junit.Test;

/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Q067 {
    public String addBinary(String a, String b) {
        String result = "";
        int index1 = a.length()-1;
        int index2 = b.length()-1;
        int jw = 0;
        while(index1>=0||index2>=0) {
            int sum = jw;
            if(index1>=0) {
                sum+=a.charAt(index1)-'0';
            }

            if(index2>=0) {
                sum+=b.charAt(index2)-'0';
            }

            result = (char)(sum%2+'0') + result;
            jw = sum/2;

            index1--;
            index2--;
        }

        if(jw>0) {
            result = "1" + result;
        }

        return result;
    }

    @Test
    public void testSolution() {
        String a = "11";
        String b = "1";
        Q067 solution = new Q067();
        System.out.println(solution.addBinary(a, b));
    }
}
