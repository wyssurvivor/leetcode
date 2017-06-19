package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/5.
 */

import org.junit.Test;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Q070 {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0] = ways[1] = 1;
        for(int i=2;i<=n;i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    @Test
    public void testSolution() {
        int n = 3;
        Q070 solution = new Q070();
        System.out.println(solution.climbStairs(n));
    }
}