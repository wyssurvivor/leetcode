package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/4.
 */

import org.junit.Test;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Q064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] calc = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0) {
                    calc[i][j] = grid[i][j];
                } else if (i==0) {
                    calc[i][j]=calc[i][j-1] + grid[i][j];
                } else if (j==0) {
                    calc[i][j]=calc[i-1][j] + grid[i][j];
                } else {
                    calc[i][j] = Math.min(calc[i-1][j],calc[i][j-1]) + grid[i][j];
                }
            }
        }

        return calc[m-1][n-1];
    }

    @Test
    public void testSolution() {
        int[][] grid = new int[][] {
                {1,2,3},
                {4,-5,6},
                {7,8,9}
        };

        Q064 solution = new Q064();
        System.out.println(solution.minPathSum(grid));
    }
}
