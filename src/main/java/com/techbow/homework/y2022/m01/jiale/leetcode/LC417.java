package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Pacific Atlantic Water Flow
 * do two bfs from pacific and atlantic, find the overlap
 */
public class LC417 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        loadAtlantic(queue, heights, atlantic);
        bfs(queue, atlantic, pacific, result, heights);
        loadPatific(queue, heights, pacific);
        bfs(queue, pacific, atlantic, result,heights);

        return result;
    }

    private void loadAtlantic(Queue<Integer> queue, int[][] matrix, boolean[][] atlantic) {
        int row = matrix.length;
        int col = matrix[0].length;
        queue.offer((row - 1) * col + col - 1);
        atlantic[row - 1][col - 1] = true;
        for (int i = 0; i < col - 1; i++) {
            queue.offer((row - 1) * col + i);
            atlantic[row - 1][i] = true;
        }
        for (int i = 0; i < row - 1; i++) {
            queue.offer(i * col + col - 1);
            atlantic[i][col - 1] = true;
        }
    }

    private void loadPatific(Queue<Integer> queue, int[][] matrix, boolean[][] pacific) {
        int row = matrix.length;
        int col = matrix[0].length;
        queue.offer(0);
        pacific[0][0] = true;
        for (int i = 1; i < col; i++) {
            queue.offer(0 * col + i);
            pacific[0][i] = true;
        }
        for (int i = 1; i < row; i++) {
            queue.offer(i * col + 0);
            pacific[i][0] = true;
        }
    }

    private void bfs(Queue<Integer> queue, boolean[][] self, boolean[][] other, List<List<Integer>> result, int[][] height) {
        int row = self.length;
        int col = self[0].length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            if (other[i][j]) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                result.add(tmp);
            }
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && !self[ii][jj] && height[ii][jj] >= height[i][j]) {
                    int next = ii * col + jj;
                    queue.offer(next);
                    self[ii][jj] = true;
                }
            }
        }
    }
}
