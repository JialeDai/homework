package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *                  2
 *                 / \
 *                1   3
 * Input: root = [2,1,3]
 * Output: true
 */
public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /**
     * Top-down recursion
     * carry on the lowBound and upperBound
     * left -> update the upperBound
     * right-> update the lowBound
     * base case: root == null
     *
     * @param root
     * @param lowBound
     * @param upperBound
     * @return
     */
    private boolean isValidBSTRecur(TreeNode root, Integer lowBound, Integer upperBound) {
        if (root == null) {
            return true;
        }

        if (!(root.val > lowBound && root.val < upperBound)) {
            return false;
        }

        return isValidBSTRecur(root.left, lowBound, root.val) && isValidBSTRecur(root.right, root.val, upperBound);
    }
}
