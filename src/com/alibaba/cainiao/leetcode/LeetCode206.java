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
    // https://www.bilibili.com/video/av60198891
    // 不需要dummy，特殊, 不需要写反而快
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var a = head;
        var b = head.next;
        var c = head.next;
        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        head.next = null;
        return a;
    }
}
