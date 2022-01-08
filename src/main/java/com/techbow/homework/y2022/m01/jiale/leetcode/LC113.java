package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     * dfs
     * 先办事后recursion， update sol 和 sum, 在比较当前层的sum 时候满足targetSum.
     * 如果不是叶子节点，recursion call
     * @param root
     * @param targetSum
     * @param sum
     * @param sol
     * @param res
     */
    private void pathSum(TreeNode root, int targetSum, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        sol.add(root.val);
        sum+=root.val;
        if (root.left == null && root.right == null) {
            if (sum  == targetSum) {
                List<Integer> copy = new ArrayList<>(sol);
                res.add(copy);
            }
        } else {
            pathSum(root.left, targetSum, sum, sol, res);
            pathSum(root.right, targetSum, sum, sol, res);
        }
        sol.remove(sol.size()-1);
    }
}
