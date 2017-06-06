package com.ssdut.wys.Solutions;

/**
 * Created by wangyongshan on 17-6-5.
 */

import org.junit.Test;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Q069 {
    public int mySqrt(int x) {
        long start = 0, end = Integer.MAX_VALUE;
        while(start<end) {
            long mid = (start+end)/2;
            if(mid*mid>x) {
                end = mid-1;
            } else {
                if(mid+1>x/(mid+1))
                    return (int)mid;
                start = mid + 1;
            }
        }

        return (int)start;
    }



    @Test
    public void testSolution() {
        Q069 solution = new Q069();
        System.out.println(solution.mySqrt(22));
        System.out.println((int)Math.sqrt(22));
    }
}
