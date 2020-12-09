package com.alibaba.cainiao.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 *
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        var dummy = new ListNode(-1);
        dummy.next = head;

        var pre = dummy;
        var cur = head;
        while (cur != null) {
            // curr指针一直判断重复，向后移动
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

}
