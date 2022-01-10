package com.techbow.homework.y2022.m01.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LC141 {

    /**
     * listNode1 -> listNode2 -> listNode3 -> listNode4 -> listNode5 -> null
     *                                             |            |
     *                                             <-------------
     *  cur = cur.next until we find a null or visited node
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
