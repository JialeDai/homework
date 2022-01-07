package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class LC39 {
    /**
     * recursion tree:
     *                                                  {}
     *                number of 2          0     1    2    3    ......leftBalance
     *                number of 3      0 1 2    0 1 2           ......leftBalance
     *                number of 6
     *                number of 7
     *
     *                number of level: candidates.length
     *                meaning of each level: number of times we select this number.
     *                when leftBalance == 0, we add the solution so far to our result
     *                leftBalance = target - curSum, we calculate the curSum.
     *                result[i] means how many candidates[i] should be used
     *                then do a post-processing to get the final result.
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return getResult(res, candidates);
    }

    private List<List<Integer>> getResult(List<List<Integer>> input, int[] candidates) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> each: input) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < each.size(); i++) {
                int num = each.get(i);
                for (int j = 0; j < num; j++) {
                    temp.add(candidates[i]);
                }
            }
            res.add(temp);
        }
        return res;
    }

    private void dfs(int[] candidates, int leftBalance, int curLevel, List<Integer> sol, List<List<Integer>> res) {
        if (leftBalance == 0) {
            List<Integer> copy = new ArrayList<>(sol);
            res.add(copy);
            return;
        }
        if (curLevel >= candidates.length) {
            return;
        }
        int maxNum = leftBalance / candidates[curLevel] + 1;
        for (int i = 0; i < maxNum; i++) {
            leftBalance -= i * candidates[curLevel];
            sol.add(i);
            dfs(candidates, leftBalance, curLevel + 1, sol, res);
            sol.remove(sol.size()-1);
            leftBalance += i * candidates[curLevel];
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC39().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
