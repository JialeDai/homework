package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */
public class LC1026 {
    /**
     *                              8
     *                             /  \
     *                            3    10
     *                          / \    / \
     *                         1  6  nil  14
     *                      / \  / \      /
     *                   nil nil 4  7   13
     *
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        int[] max = new int[1];
        helper(root, root.val, root.val, max);
        return max[0];
    }

    /**
     * @param cur
     * @return
     */
    private void helper(TreeNode cur, int max, int min, int[] res) {
        if (cur == null) {
            res[0] = Math.max(res[0], Math.abs(max - min));
            return;
        }
        helper(cur.left, Math.max(max, cur.val), Math.min(min, cur.val), res);
        helper(cur.right, Math.max(max, cur.val), Math.min(min, cur.val), res);
    }
}
