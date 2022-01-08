package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.ListNode;
import com.techbow.homework.y2021.m09.jiale.common.TreeNode;


/**
 * different from int[] input
 */
public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = getMid(head);
        TreeNode cur = new TreeNode(mid.val);
        if (head == mid) {
            return cur;
        }
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(mid.next);
        cur.left = left;
        cur.right = right;
        return cur;
    }

    /**
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *           s
     *                      f
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        ListNode prevPtr  = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prevPtr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prevPtr != null) {
            prevPtr.next = null;
        }
        return slow;
    }
}
