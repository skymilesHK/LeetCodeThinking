package com.alibaba.cainiao.leetcode;

/**
 * 203. Remove Linked List Elements
 * Easy
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        var dummy = new ListNode(-1);
        dummy.next = head;
        var pre = dummy;
        var cur = head;
        var next = head.next;
        while (cur != null) {
            next = cur.next;
            if (cur.val == val) {
                pre.next = next;
                cur.next = null;
            }
            pre = cur;
            cur = next;
        }

        return dummy.next;
    }

}
