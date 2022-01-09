package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class LC19 {
    /**
     *
     * dummy -> listNode1 -> listNode2 -> listNode3 -> listNode4 -> listNode5 -> null
     *                                    prev     cur                       next
     * n = 2
     * listNode1 -> listNode2 -> listNode3 -            -> listNode5 -> null
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head;
        for (int i = 0; i < n; i++) {
            next = next.next;
        }
        while (next != null) {
            prev = prev.next;
            cur = cur.next;
            next = next.next;
        }

        // remove prev
        prev.next = cur.next;
        cur.next = null;


        return dummy.next;
    }
}
