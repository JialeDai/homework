package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.ListNode;

/**
 * reverse linkedList
 */
public class LC206 {
    /**
     * ListNode1 -> ListNode2 -> ListNode3 -> ListNode4 -> ListNode5 -> null
     * ListNode1 -> ListNode2 -> ListNode3 -> ListNode4   ListNode5
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head; // <-
        head.next = null;   // 断开
        return newHead;
    }
}
