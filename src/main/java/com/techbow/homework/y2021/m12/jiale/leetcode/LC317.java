package com.techbow.homework.y2021.m12.jiale.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC317 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int numR = grid.length;
        int numC = grid[0].length;
        int[][] cost = new int[numR][numC];

        for (int i = 0; i < numR; i++) {
            for (int j = 0; j < numC; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < numR; i++) {
            for (int j = 0; j < numC; j++) {
                if (grid[i][j] == 0 && cost[i][j] != 0){
                    minDistance = Math.min(cost[i][j], minDistance);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfs(int[][] grid, int[][] cost, int i, int j) {
        int numR = grid.length;
        int numC = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * numC + j);
        int minLen = 1;
        boolean[][] visited = new boolean[numR][numC];
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curR = cur / numC;
                int curC = cur % numC;
                for (int[] dir : DIRECTIONS) {
                    int nextR = curR + dir[0];
                    int nextC = curC + dir[1];
                    if (nextR >= 0 && nextR < numR && nextC >= 0 && nextC < numC && grid[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        int next = nextR * numC + nextC;
                        queue.offer(next);
                        visited[nextR][nextC] = true;
                        cost[nextR][nextC] += minLen;
                    }
                }
            }
            minLen++;
        }

        /**
         * for the following condition: we should set the unaccessiable node to 2 at the end of each bfs
         * 0 2 1
         * 1 0 2
         * 0 1 0
         */
        for (int r = 0; r < numR; r++) {
            for (int c = 0; c < numC; c++) {
                if (!visited[r][c]) {
                    grid[r][c] = 2;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] input = {{0, 2, 1}, {1, 0, 2},{0,1,0}};
        System.out.println(new LC317().shortestDistance(input));
    }
}
