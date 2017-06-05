package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/3.
 */

import org.junit.Test;

/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
public class Q063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] calc = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    calc[i][j] = 0;
                } else {
                    if(i==0&&j==0) {
                        calc[i][j] = 1;
                    } else if(i==0) {
                        calc[i][j] = calc[i][j-1];
                    } else if(j==0) {
                        calc[i][j] = calc[i-1][j];
                    } else {
                        calc[i][j] = calc[i-1][j]+calc[i][j-1];
                    }
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(calc[i][j]+ " ");
            }
            System.out.println();
        }

        return calc[m-1][n-1];
    }

    @Test
    public void testSolution() {
        int[][] obstacleGrid= new int[][] {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        Q063 solution = new Q063();
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
