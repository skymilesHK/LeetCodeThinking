package com.alibaba.cainiao.leetcode;

/**
 * 合并两个有序链表
 * Merge Two Sorted Lists
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        var dummy = new ListNode(-1);
        var p1 = l1;
        var p2 = l2;
        var p3 = dummy;

        while (p1 != null && p2 != null) {
            boolean b = p1.val < p2.val;
            p3.next = b ? p1 : p2;
            p3 = p3.next;

            p1 = b ? p1.next : p1;
            p2 = b ? p2 : p2.next;
        }

        p3.next = (p1 != null) ? p1 : p2;
        return dummy.next;
    }
}
