package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC79 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        List<int[]> starts = getStarts(board, word);
        for (int[] start : starts) {
            if (exist(board, start[0], start[1], word, 0, new boolean[board.length][board[0].length])) {
                return true;
            }
        }
        return false;
    }

    private List<int[]> getStarts(char[][] board, String word) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        // success
        if (index == word.length()) {
            return true;
        }
        // fail
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            res = exist(board, ii, jj, word, index + 1, visited);
            if (res) {
                break;
            }
        }
        visited[i][j] = false;
        return res;
    }
}
