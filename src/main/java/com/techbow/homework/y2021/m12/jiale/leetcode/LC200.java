package com.techbow.homework.y2021.m12.jiale.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// number of islands
public class LC200 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public int numIslandsDfs(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int numIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int curRow, int curCol) {
        int row = grid.length;
        int col = grid[0].length;

        if (curCol < 0 || curRow < 0 || curRow >= row || curCol >= col || grid[curRow][curCol] == '0') {
            return;
        }
        grid[curRow][curCol] = '0';
        for (int[] dir : DIRECTIONS) {
            dfs(grid, curRow + dir[0], curCol + dir[1]);
        }
    }

    /**
     * using bfs
     *
     * @param grid
     * @return
     */
    public int numIslandBfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            throw new IllegalArgumentException("illegal argument");
        }
        int nrow = grid.length;
        int ncol = grid[0].length;

        int numIsland = 0;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    // do bfs
                    numIsland++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * ncol + j);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            int cur = queue.poll();
                            int curR = cur / ncol;
                            int curC = cur % ncol;
                            for (int[] dir : DIRECTIONS) {
                                int nextR = curR + dir[0];
                                int nextC = curC + dir[1];
                                // check valid
                                if (nextC >= 0 && nextC < ncol && nextR >= 0 && nextR < nrow && grid[nextR][nextC] == '1') {
                                    grid[nextR][nextC] = '0';
                                    int next = nextR * ncol + nextC;
                                    queue.offer(next);
                                }
                            }

                        }
                    }
                }
            }
        }
        return numIsland;
    }

}
