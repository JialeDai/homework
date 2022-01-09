package com.techbow.homework.y2022.m01.jiale.leetcode;


import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node wenxuan caoin the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
public class LC114 {


    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode right = flatten(root.right, tail);
        TreeNode left = flatten(root.left, right);
        root.right = left;
        root.left = null;
        return root;
    }

    /**
     * private TreeNode flattenTree(TreeNode node) {
     *
     *         // Handle the null scenario
     *         if (node == null) {
     *             return null;
     *         }
     *
     *         // For a leaf node, we simply return the
     *         // node as is.
     *         if (node.left == null && node.right == null) {
     *             return node;
     *         }
     *
     *         //Recursively flatten the left subtree
     *         TreeNode leftTail = this.flattenTree(node.left);
     *
     *         // Recursively flatten the right subtree
     *         TreeNode rightTail = this.flattenTree(node.right);
     *
     *         // If there was a left subtree, we shuffle the connections
     *         // around so that there is nothing on the left side
     *         // anymore.
     *         if (leftTail != null) {
     *             leftTail.right = node.right;
     *             node.right = node.left;
     *             node.left = null;
     *         }
     *
     *         // We need to return the "rightmost" node after we are
     *         // done wiring the new connections.
     *         return rightTail == null ? leftTail : rightTail;
     *     }
     *
     *     public void flatten(TreeNode root) {
     *
     *         this.flattenTree(root);
     *     }
     */
}
