package com.ssdut.wys.q029;

/**
 * Created by Ryan on 17/4/29.
 */

/**
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class Solution {
    public int divide(int dividend, int divisor) {

        boolean isMinus = dividend<0^divisor<0;
        long dividendl = dividend;
        long divisorl = divisor;
        dividendl = Math.abs(dividendl);
        divisorl = Math.abs(divisorl);
        if(divisorl > dividendl) {
            return 0;
        }

        long result = 0;
        while(divisorl<=dividendl) {
            long multi = 1;
            long d = divisorl;
            while((d<<1L)<=dividendl) {
                d <<= 1L;
                multi<<=1L;
            }
            dividendl-=d;
            result+=multi;
        }



        result = isMinus?-result:result;
        if(result>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-1010369383,-2147483648));
    }
}
