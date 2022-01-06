package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 */
public class LC77 {

    /**
     * recursion tree:
     *                                  {}
     *                         1       2      3       4         level 0
     *                 12 13 14     23 24    34                 level 1
     *              null ......
     * number of level: k
     * meaning of each level: the index to be decided
     * use recursion to move to next level and use for loop to go over all the possible solution on each level.
     * we store the result when we reach the null below leaf node.
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 0, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int level, int cur, List<Integer> sol, List<List<Integer>> res) {
        if (level == k) {
            List<Integer> copy = new ArrayList<>(sol);
            res.add(copy);
            return;
        }
        for (int i = cur; i <= n; i++) {
            sol.add(i);
            dfs(n, k, level + 1, i + 1, sol, res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC77().combine(4, 2));
    }
}
