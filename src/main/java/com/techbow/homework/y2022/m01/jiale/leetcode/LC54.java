package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * in order to locate a Rectangle， we can use a point (a, b) and two line
 * we use recursion to move to the smaller loop
 * and use for loop to print all the element on one loop
 * recursion has min(length/2, width/2)
 * each recursion handle one loop
 * move between loops dfs(matrix, offset, rowSize - 2, colSize -2)
 * <p>
 * base case:
 * size == 1
 * print;
 * size == 0;
 * return;
 */
public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        dfs(matrix, 0, rowSize, colSize, res);
        return res;
    }

    private void dfs(int[][] matrix, int offset, int rowSize, int colSize, List<Integer> res) {
        if (rowSize == 0 || colSize == 0) {
            return;
        }
        if (rowSize == 1 || colSize == 1) {
            if (rowSize == 1) {
                for (int i = 1; i <= colSize; i++) {
                    res.add(matrix[offset][offset + i - 1]);
                }
            } else {
                for (int i = 1; i <= rowSize; i++) {
                    res.add(matrix[offset + i - 1][offset]);
                }
            }
            return;
        }

        // use step
        // top-left -> top-right
        for (int i = 0; i < colSize - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        // top right -> bottom-right
        for (int i = 0; i < rowSize - 1; i++) {
            res.add(matrix[offset + i][offset + colSize - 1]);
        }
        // bottom-right -> bottom-left
        for (int i = 0; i < colSize - 1; i++) {
            res.add(matrix[offset + rowSize - 1][offset + colSize - i - 1]);
        }
        // bottom-left -> top-left
        for (int i = 0; i < rowSize - 1; i++) {
            res.add(matrix[offset + rowSize - i - 1][offset]);
        }
        dfs(matrix, offset + 1, rowSize - 2, colSize - 2, res);
    }
}
