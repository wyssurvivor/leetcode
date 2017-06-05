package com.ssdut.wys.Solutions;

/**
 * Created by Ryan on 17/6/1.
 */

import org.junit.Test;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Q059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int iter = 1;
        for(int i=0;i<n/2;i++) {
            for(int j=i;j<n-i-1;j++) {
                matrix[i][j] = iter++;
            }

            for(int j=i;j<n-i-1;j++) {
                matrix[j][n-i-1] = iter++;
            }

            for(int j=n-i-1;j>i;j--) {
                matrix[n-i-1][j] = iter++;
            }

            for(int j=n-i-1;j>i;j--) {
                matrix[j][i] = iter++;
            }
        }

        if(n%2 == 1) {
            matrix[n/2][n/2] = iter++;
        }

        return matrix;
    }

    public void print(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j = 0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }
    }

    @Test
    public void testSolution() {
        int n = 1;
        Q059 solution = new Q059();
        solution.print(solution.generateMatrix(n));
    }
}
