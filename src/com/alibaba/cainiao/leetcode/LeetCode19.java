package com.alibaba.cainiao.leetcode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class LeetCode19 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null && h2 != null) {
            boolean b = h1.val < h2.val;
            curr.next = b ? h1 : h2;
            curr = curr.next;

            h1 = b ? h1.next : h1;
            h2 = b ? h2 : h2.next;
        }

        curr.next = (h1 != null) ? h1 : h2;
        return dummy.next;
    }

}
