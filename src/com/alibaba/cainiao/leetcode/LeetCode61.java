package com.alibaba.cainiao.leetcode;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 */
public class LeetCode61 {
    // https://www.bilibili.com/video/av60198891
    // 不需要虚拟头节点, 一般head节点需要变的情况下，要dummy节点,但是这题很特殊
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int n = 0;
        var h = head;
        while (h != null) {
            n++;
            h = h.next;
        }
        k = k % n;

        var slow = head;
        var fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
