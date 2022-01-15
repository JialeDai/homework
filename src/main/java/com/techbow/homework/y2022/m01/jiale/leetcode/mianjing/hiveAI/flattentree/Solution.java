package com.techbow.homework.y2022.m01.jiale.leetcode.mianjing.hiveAI.flattentree;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * 1. dummy node, and a current start from dummy node, traverse in pre order and add next to dummy node.
 * time: O(n), space: O(n) take the size of the output into consideration
 *
 * 2.O(n) space in place in order traverse:
 * ListNode next, prev
 * TreeNode left, right
 * reuse
 * goal: update left and right of each node
 * listNode1 -> listNode2 -> listNode3 -> listNode4 -> listNode5 -> null
 * prev         cur
 * pre order traverse the tree, and in the meantime, update the left and right point of node
 * how to access the cur in recursion: root
 * how to access the prev in recursion: keep and update the prev variable;
 *
 *
 * TreeNode prev = null;
 * TreeNode head = null;
 * // TreeNode tail = null; // last cur, 不需要， pre end at tail
 * inorder(TreeNode root) {
 *     inorder(root.left);
 *     // do sth
 *     if (prev != null) prev.right == root; // npe
 *     else head = root; // head is the first not null node in the process of traverse;
 *     root.left = prev;
 *     // prev++, cur++(inorder traverse)
 *     prev = root;
 *     // tail = root;
 *     inorder(root.right);
 * }
 *
 *
 * bottom up recursion
 * ask left and right child for the head of the linked
 * current level: right.tail.next = left.head, root.next =
 *
 *
 * 3. recursion:
 * return head of left subtree and tail of right subtree
 * if root == null, return root;
 * TreeNode r = inorder(root.right);
 * if (r != nul) r.prev = root, root.next = r;
 * TreeNode l = inorder(root.left);
 * TreeNode l = inorder(root.left);
 * return l;
 */
public class Solution {
    public void flatten(TreeNode root) {

    }
}