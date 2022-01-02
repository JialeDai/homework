package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 matrix
 */
public class LC542 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) throws IllegalAccessException {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
            throw new IllegalAccessException();
        }
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[mat.length][mat[0].length];
        Queue<Integer> queue = new LinkedList<>();
        allAllZeros(mat, queue);
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && mat[ii][jj] == 1 && result[ii][jj] == 0) {
                        queue.offer(ii * col + jj);
                        result[ii][jj] = minLen + 1;
                    }
                }
            }
            minLen++;
        }
        return result;
    }

    private void allAllZeros(int[][] mat, Queue<Integer> queue) {
        int col = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }
    }
}
