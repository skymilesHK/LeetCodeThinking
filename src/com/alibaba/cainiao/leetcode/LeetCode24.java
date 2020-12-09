package com.alibaba.cainiao.leetcode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class LeetCode24 {

    // https://www.bilibili.com/video/av60198891
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode a = dummy.next;
        ListNode b = dummy.next;

        while (pre.next != null && pre.next.next != null) {
            a = pre.next;
            b = a.next;

            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;
        }

        return dummy.next;
    }

}
