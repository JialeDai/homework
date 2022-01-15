package com.techbow.homework.y2022.m01.jiale.leetcode.OA;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER startRow
     *  3. INTEGER startCol
     *  4. INTEGER endRow
     *  5. INTEGER endCol
     *  6. INTEGER bishopRow
     *  7. INTEGER bishopCol
     */

    // 1. this is a shortest path question on 2d board
    // 2. 2d board -> graph
    // 3. vertex -> cell on border
    // 4. edge -> if a knight can go from A->B, AB forms a edge
    // 5. this is a undirected and equally weighted graph, we use bfd to solve the shorest path prbolem
    // 6. validation: is the current position is threated by bishop
    // 7. On graph: need visited check

    private static final int[][] DIRECTIONS = {{2, -1}, {2, 1}, {1, -2}, {1, 2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
    public static int moves(int n, int startRow, int startCol, int endRow, int endCol, int bishopRow, int bishopCol) {
        Integer bishopPos = bishopRow * n + bishopCol;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startRow * n + startCol);
        boolean[][] visited = new boolean[n][n];
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                Integer cur = queue.poll();
                int curRow = cur / n;
                int curCol = cur % n;
                for (int[] dir : DIRECTIONS) {
                    int nextRow = curRow + dir[0];
                    int nextCol = curCol + dir[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                        continue;
                    }
                    int next = nextRow * n + nextCol;
                    if (isValid(next, bishopPos, n, visited)) {
                        System.out.println(nextRow+" "+ nextCol);
                        queue.offer(next);
                        visited[nextRow][nextCol] = true;
                        if (nextRow == endRow && nextCol == endCol) {
                            return minLen+1;
                        }
                    }
                }
            }
            minLen++;
        }
        return -1;
    }

    private static boolean isThreatened(Integer curpos, Integer bishopPos, int n) {
        int curRow = curpos / n;
        int curCol = curpos % n;
        int bishopRow = bishopPos / n;
        int bishopCol = bishopPos % n;
        if (Math.abs(curRow - bishopRow) == Math.abs(curCol - bishopCol)) {
            return true;
        }
        return false;
    }

    private static boolean isValid(int pos,int bishopPos, int n, boolean[][] visited) {
        int row = pos / n;
        int col = pos % n;
        if (row >= 0 && row < n && col >= 0 && col < n && !isThreatened(pos, bishopPos, n) && !visited[row][col]) {
            return true;
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int result = Result.moves(5, 4, 2, 0, 1, 1, 3);
        System.out.println(result);
    }
}
