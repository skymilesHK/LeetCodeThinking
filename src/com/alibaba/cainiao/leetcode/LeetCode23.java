package com.alibaba.cainiao.leetcode;

public class LeetCode23 {

    // divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }

        return mergeK(lists, 0, k - 1);
    }

    // divide
    private ListNode mergeK(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        } else {
            int mid = l + (r - l) / 2;
            ListNode left = mergeK(lists, l, mid - 1);
            ListNode right = mergeK(lists, mid + 1, r);
            return mergeTwoSortedLists(left, right);
        }
    }

    // conquer
    private ListNode mergeTwoSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            boolean b = head1.val < head2.val;
            cur.next = b ? head1 : head2;
            cur = cur.next;

            head1 = b ? head1.next : head1;
            head2 = b ? head1 : head2.next;
        }

        cur.next = head1 != null ? head1 : head2;

        return dummy.next;
    }

}
