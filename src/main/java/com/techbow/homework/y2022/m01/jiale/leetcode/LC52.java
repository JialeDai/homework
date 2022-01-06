package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.Arrays;

public class LC52 {
    public int totalNQueens(int n) {
        char[][] border = getBorder(n);
        int[] preRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        return dfs(n, 0, 0, preRow, upperDiagonal, lowerDiagonal, border);
    }

    private int dfs(int n, int level, int count, int[] preRow, int[] upperDiagonal, int[] lowerDiagonal, char[][] border) {
        if (level == n) {
            count += 1;
            return count;
        }

        for (int i = 0; i < n; i++) {
            if (preRow[i] == 0 && upperDiagonal[i - level + n - 1] == 0 && lowerDiagonal[i + level] == 0) {
                border[level][i] = 'Q';
                preRow[i] = 1;
                upperDiagonal[i - level + n - 1] = 1;
                lowerDiagonal[i + level] = 1;
                count = dfs(n, level + 1, count, preRow, upperDiagonal, lowerDiagonal, border);
                preRow[i] = 0;
                upperDiagonal[i - level + n - 1] = 0;
                lowerDiagonal[i + level] = 0;
                border[level][i] = '.';
            }
        }
        return count;
    }

    private char[][] getBorder(int n) {
        char[][] border = new char[n][n];
        for (int i = 0; i < border.length; i++) {
            Arrays.fill(border[i], '.');
        }
        return border;
    }

    public static void main(String[] args) {
        int input = 4;
        System.out.println(new LC52().totalNQueens(input));
    }
}
