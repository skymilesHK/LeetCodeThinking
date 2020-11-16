package com.alibaba.cainiao.leetcode;

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode a = head, b = head.next;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        return a;
    }

}
