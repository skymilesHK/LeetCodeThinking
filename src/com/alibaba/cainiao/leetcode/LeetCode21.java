package com.alibaba.cainiao.leetcode;

/**
 * 合并两个有序链表
 * Merge Two Sorted Lists
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {
    // pre初始化指向dummy,a指向dummy.next, b指向dummy.next.next
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode a = pre.next;
        ListNode b = pre.next.next;
        while (pre != null && pre.next != null && pre.next.next != null) {
            a = pre.next;
            b = pre.next.next;

            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;
        }

        return dummy.next;
    }
}
