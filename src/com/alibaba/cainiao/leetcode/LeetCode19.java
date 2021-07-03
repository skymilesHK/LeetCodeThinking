package com.alibaba.cainiao.leetcode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class LeetCode19 {

    // 1.fast先移动n位
    // 2.fast和slow同时移动
    // 3.删除slow后面这个点，就ok
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode(-1);
        dummy.next = head;
        var slow = dummy;
        var fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        var next = slow.next;
        slow.next = next.next;
        next.next = null;

        return dummy.next;
    }

}
