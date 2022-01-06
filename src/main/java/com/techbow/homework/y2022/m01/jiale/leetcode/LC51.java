package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * top bottom - recursion
 * left right - for loop
 * dfs (matrix, level, sol, res)
 */
public class LC51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        dfs(n, 0, sol, res);
        return res;
    }

    private void dfs(int n, int level, List<String> sol, List<List<String>> res) {
        if (level == n) {
            List<String> copy = new ArrayList<>(sol);
            res.add(copy);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(sol, level, i, n)) {
                char[] status = getEmptyStatus(n);
                sol.add(setQueen(status, i));
                dfs(n, level + 1, sol, res);
                sol.remove(level);
            }
        }
    }

    /**
     * we look for a one to one relation for projection to a 1 dimension array.
     * <p>
     * (0, 0) -> array(n-1)
     * (n - 1, 0) -> look top left -> array(0)
     * (0, n - 1) -> look top left -> array(array.length-1)
     * so loop top-left -> (i, j) -> j - i + (array.length -1)
     * <p>
     * (0, 0) -> array(0)
     * (n - 1, 0) -> array(n-1)
     * (n - 1, n - 1) -> array(2n -1)
     * so loop top-right -> bottom-left -> (i, j) -> i + j
     * . . . . .     # # # # # # # # #
     * . . . . .
     * . . . . .
     * . . . . .
     * . . . . .
     * <p>
     * use a 2*5-1 array.
     * i j -> look up -> j
     * i j -> up left ->
     */
    // look up, up-left, up-right
    private boolean isValid(List<String> sol, int r, int c, int size) {
        // look up
        for (int i = 0; i < r; i++) {
            if (sol.get(r - i - 1).charAt(c) == 'Q') {
                return false;
            }
        }
        // look top left diagonal
        int rr = r - 1;
        int cc = c - 1;
        while (rr >= 0 && cc >= 0) {
            if (sol.get(rr).charAt(cc) == 'Q') {
                return false;
            }
            rr--;
            cc--;
        }

        rr = r - 1;
        cc = c + 1;
        while (rr >= 0 && cc <= size - 1) {
            if (sol.get(rr).charAt(cc) == 'Q') {
                return false;
            }
            rr--;
            cc++;
        }
        return true;
    }

    private char[] getEmptyStatus(int size) {
        char[] status = new char[size];
        Arrays.fill(status, '.');
        return status;
    }

    private String setQueen(char[] status, int pos) {
        status[pos] = 'Q';
        return new String(status);
    }

    public static void main(String[] args) {
        int input = 4;
        System.out.println(new LC51().solveNQueens(input));
    }
}
