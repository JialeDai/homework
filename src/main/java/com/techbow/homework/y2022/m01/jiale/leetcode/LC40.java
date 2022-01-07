package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class LC40 {

    /**
     *                                      {}
     *                     10             1   2   7   6   1   5
     *               10,1 10,2 ...
     *
     *               number of levels: candidates.len
     *               meaning of each level: stand on the previous element, we choose the current element
     *               when to store the result: sum = target -> sort first;
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> sol, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> copy = new ArrayList<>(sol);
            res.add(copy);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            sol.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, sol, res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new LC40().combinationSum2(candidates, target));
    }
}
