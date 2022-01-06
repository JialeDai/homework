package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class LC78 {
    /**
     * {}
     * 1       {}                  Level0
     * 1,2   1    2   {}               Level1
     * 1,2,3 1,2  1,3 1 2,3   {}              Level2
     * number of level: input.length
     * meaning of the level: whether to choose the current element
     * we get the answer at the null level below the leaf node
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(nums, 0, new ArrayList<>(), res);
        return res;
    }


    /**
     * use recursion to control the level, using for loop to control different branch
     *
     * @param nums
     * @param index
     * @param sol
     * @param res
     */
    private void dfs(int[] nums, int index, List<Integer> sol, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> copy = new ArrayList<>(sol);
            res.add(copy);
            return;
        }
        sol.add(nums[index]);
        dfs2(nums, index + 1, sol, res);
        sol.remove(sol.size() - 1);

        dfs(nums, index + 1, sol, res);
    }

    /**
     * {}
     * 1      2     3        level 0
     * 12  13   23              level 1
     * 123                         level 2
     * <p>
     * number of levels: input.length
     * meaning of levels: the number of elements solution so far contains
     * when to record the result: every time(node)
     *
     * @param nums
     * @param index
     * @param sol
     * @param res
     */
    private void dfs2(int[] nums, int index, List<Integer> sol, List<List<Integer>> res) {
        List<Integer> copy = new ArrayList<>(sol);
        res.add(copy);

        for (int i = index; i < nums.length; i++) {
            sol.add(nums[i]);
            dfs(nums, i + 1, sol, res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(new LC78().subsets(input));
    }
}
