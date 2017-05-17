package com.ssdut.wys.Solutions;

import org.junit.Test;

/**
 * Created by Ryan on 17/5/17.
 */
/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

 */
public class Q052 {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        return dfs(board, 0);
    }

    private int dfs(char[][] board, int colIndex) {
        if(colIndex == board.length) {
            return 1;
        }

        int count = 0;
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                count += dfs(board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
        return count;
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    @Test
    public void testSolution() {
        int n= 7;
        Q052 solution = new Q052();
        System.out.println(solution.totalNQueens(n));
    }
}
