package com.ssdut.wys.Solutions;

/**
 * Created by wangyongshan on 17-6-19.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Q073 {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<rows.size();i++) {
            for(int j=0;j<matrix[0].length;j++) {
                matrix[rows.get(i)][j] = 0;
            }

            for(int j=0;j<matrix.length;j++) {
                matrix[j][cols.get(i)] = 0;
            }
        }
    }

    public void print(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }
    }

    @Test
    public void testSolution() {
        Q073 solution = new Q073();
        int[][] matrix = new int[][] {
                {1,0,1},
                {1,1,1},
                {1,1,0}
        };

        solution.setZeroes(matrix);
        solution.print(matrix);
    }
}
