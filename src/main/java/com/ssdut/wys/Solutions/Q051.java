package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 17/5/15.
 */
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class Q051 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Integer> colFoRow = getColForRow(n);
        solve(result, colFoRow, n, 0);
        return result;
    }

    public List<Integer> getColForRow(int n) {
        List<Integer> colFoRow = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
            colFoRow.add(i, -1);
        }

        return colFoRow;
    }

    public String getEmptyLine(int n) {
        String line = "";
        for(int j=0;j<n;j++) {
            line+=".";
        }
        return line;
    }


    public void solve(List<List<String>> result, List<Integer> colForRow, int n, int row) {
        if(row == n) {
            List<String> board = new ArrayList<String>();
            String emptyLine = getEmptyLine(n);
            for(int i=0;i<row;i++) {
                board.add(emptyLine.substring(0, colForRow.get(i))+"Q"+emptyLine.substring(colForRow.get(i)+1));
            }
            result.add(board);
            return ;
        }

        for(int j=0;j<n;j++) {
            colForRow.set(row, j);
            if(canQueen(row, colForRow)) {
                solve(result, colForRow, n, row+1);
            }
        }
    }



    public boolean canQueen(int row, List<Integer> colFoRow) {
        for(int i=0;i<row;i++) {
            if(colFoRow.get(i) == colFoRow.get(row)||Math.abs(colFoRow.get(row)-colFoRow.get(i))==row-i) {
                return false;
            }
        }

        return true;
    }

    public  void print(List<List<String>> result) {
        System.out.println("totaly:"+result.size());
        for(int i=0;i<result.size();i++) {
            for(int j =0;j<result.get(i).size();j++) {
                System.out.println(result.get(i).get(j));
            }

            System.out.println("=====================");
        }
    }

    @Test
    public void testSolution() {
        int n = 5;
        Q051 solution = new Q051();
        solution.print(solution.solveNQueens(n));
    }
}
