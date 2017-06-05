package com.ssdut.wys.Solutions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ryan on 17/5/14.
 */
/*
implement pow(x,n)
 */
public class Q050 {
    public double myPow(double x, int n) {
        boolean negative = false;
        if(n<0) {
            n=Math.abs(n);
            negative = true;
        }
        double result =  calc(x, n);
        if(negative) {
            return 1/result;
        }

        return result;
    }

    public double calc(double x, int n) {
        if(n == 1) {
            return x;
        }
        if(n == 0) {
            return 1;
        }

        double half = calc(x, n/2);

        if(n%2 == 0) {
            return half*half;
        } else {
            return half*half*x;
        }
    }

    @Test
    public void testSolution() {
        double x = 34.00515;
        int n = 3;
        Q050 solution = new Q050();
        System.out.println(solution.myPow(x, n));
        Assert.assertEquals(solution.myPow(x, n), Math.pow(x, n), 0.00000000001);
    }


}
