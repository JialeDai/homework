package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

public class LC108 {
    /**
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootIndex = left + (right - left) / 2;
        TreeNode leftRoot = sortedArrayToBST(nums, left, rootIndex - 1);
        TreeNode rightRoot = sortedArrayToBST(nums, rootIndex + 1, right);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
