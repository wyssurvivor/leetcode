package com.ssdut.wys.q542;

/**
 * Created by Ryan on 17/3/30.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.

 */
public class Solution {

    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(matrix.size()) ;
        for(int i=0;i<matrix.size();i++) {
            List<Integer> list = new ArrayList<Integer>(matrix.get(i).size());
            for(int j=0;j<matrix.get(i).size();j++) {
                list.add(-1);
            }
            result.add(list);
        }

        for(int i=0;i<matrix.size();i++) {
            for(int j=0;j<matrix.get(i).size();j++) {
                if(matrix.get(i).get(j)==0) {
                    updateDistance(0, matrix, result, i+1, j, LEFT, DOWN);
                    updateDistance(0, matrix, result, i-1, j, RIGHT, UP);
                    updateDistance(0, matrix, result, i, j+1, RIGHT, DOWN);
                    updateDistance(0, matrix, result, i, j-1, LEFT, UP);
                }
            }
        }

        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                if(result.get(i).get(j)==-1) {
                    result.get(i).set(j,0);
                }
            }
        }

        return result;
    }

    public void updateDistance(int distance, List<List<Integer>> matrix, List<List<Integer>> result,int i, int j,
                               int hDirection, int vDirection) {
        if (i<0||i>=matrix.size()||j<0||j>=matrix.get(0).size()) {
            return;
        }
        if(matrix.get(i).get(j)==0) {
            return ;
        }

        distance +=1;
        int value = result.get(i).get(j);
        if(value==-1||value>distance) {
            result.get(i).set(j, distance);
        }

        if(vDirection==UP) {
            updateDistance(distance, matrix, result, i-1, j, hDirection, vDirection);
        } else {
            updateDistance(distance, matrix, result, i+1, j, hDirection, vDirection);
        }

        if(hDirection==LEFT) {
            updateDistance(distance, matrix, result, i, j-1, hDirection, vDirection);
        } else {
            updateDistance(distance, matrix, result, i, j+1, hDirection, vDirection);
        }

    }

    public void print(List<List<Integer>> matrix) {
        for(int i=0;i<matrix.size();i++) {
            for(int j=0;j<matrix.get(i).size();j++) {
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        matrix.add(Arrays.asList(0,0,1,0,1,1,1,0,1,1));
        matrix.add(Arrays.asList(1,1,1,1,0,1,1,1,1,1));
        matrix.add(Arrays.asList(1,1,1,1,1,0,0,0,1,1));

        Solution solution = new Solution();
        List<List<Integer>> result = solution.updateMatrix(matrix);
        solution.print(result);
    }
}
