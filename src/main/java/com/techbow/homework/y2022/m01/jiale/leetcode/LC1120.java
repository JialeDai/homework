package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.
 *
 * A subtree of a tree is any node of that tree plus all its descendants.
 *
 * The average value of a tree is the sum of its values, divided by the number of nodes.
 */
public class LC1120 {
    /**
     *                      5
     *                     / \
     *                    6   1
     *       bottom - top recursion
     *       record the node count and number of nodes
     *       update the nodeCount = left + right + cur.val and numNodes = left + right + 1
     *       curAgv = max{left, right, nodeCount/numNodes}
     *       return [curAvg, curSum, curCount]
     * @param root
     * @return
     */
    public double maximumAverageSubtree(TreeNode root) {
       return maximumAverageSubtreeRecursive(root)[0];
    }

    private double[] maximumAverageSubtreeRecursive(TreeNode root) {
        if (root == null) {
            return new double[]{0, 0, 0};
        }
        double[] left = maximumAverageSubtreeRecursive(root.left);
        double[] right = maximumAverageSubtreeRecursive(root.right);

        double curSum = left[1] + right[1] + root.val;
        double curCount = left[2] + right[2] + 1;
        double curAvg = curSum / curCount;

        curAvg = Math.max(Math.max(left[0], right[0]), curAvg);
        return new double[]{curAvg, curSum, curCount};
    }
}
