package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * walls and gates
 */
public class LC286 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) throws IllegalArgumentException {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int row = rooms.length;
        int col = rooms[0].length;
        int minLen = 0;
        Queue<Integer> queue = new LinkedList<>();
        addAllGateToQueue(rooms, queue);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && rooms[ii][jj] == Integer.MAX_VALUE) {
                        queue.offer(ii * col + jj);
                        rooms[ii][jj] = minLen + 1;
                    }
                }
            }
            minLen++;
        }
    }

    private void addAllGateToQueue(int[][] rooms, Queue<Integer> queue) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * rooms[0].length + j);
                }
            }
        }
    }
}
