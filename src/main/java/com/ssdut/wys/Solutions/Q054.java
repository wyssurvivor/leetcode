package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 17/5/20.
 */
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class Q054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) {
            return result;
        }
        for (int i = 0; i <= matrix.length / 2&&i<=matrix[i].length/2; i++) {

            if (matrix.length - i - 1 == i) {
                for (int j = i; j < matrix[i].length - i; j++) {
                    result.add(matrix[i][j]);
                }
            } else if (matrix[i].length - i - 1 == i) {
                for (int j = i; j < matrix.length - i; j++) {
                    result.add(matrix[j][i]);
                }
            } else {
                for (int j = i; j < matrix[i].length - i - 1; j++) {
                    result.add(matrix[i][j]);
                }


                for (int j = i; j < matrix.length - i - 1; j++) {
                    result.add(matrix[j][matrix[i].length - i - 1]);
                }


                for (int j = matrix[i].length - i - 1; j > i; j--) {
                    result.add(matrix[matrix.length - i - 1][j]);
                }


                for (int j = matrix.length - i - 1; j > i; j--) {
                    result.add(matrix[j][i]);
                }

            }

        }

        return result;
    }

    public void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }

    @Test
    public void testSolution() {
        Q054 solution = new Q054();
        int[][] matrix = new int[][]{
//                {1, 2, 3, 10},
//                {4, 5, 6, 11},
//                {7, 8, 9, 12},
//                {13, 14, 15, 16}
                {1},
                {2},
                {3},
                {4}
        };
        solution.print(solution.spiralOrder(matrix));

    }
}
