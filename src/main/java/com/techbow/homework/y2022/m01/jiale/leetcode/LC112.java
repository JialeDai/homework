package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

public class LC112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
