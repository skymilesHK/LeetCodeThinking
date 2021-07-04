package com.alibaba.cainiao.leetcode;

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }

        return mergeKLists(lists, 0, k - 1);
    }

    // 机器下标范围
    // divide
    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        } else {
            int mid = l + (r - l) / 2;
            // 注意[l,mid] + [mid+1,r]
            ListNode left = mergeKLists(lists, l, mid);
            ListNode right = mergeKLists(lists, mid + 1, r);
            return mergeTwoSortedLists(left, right);
        }
    }

    // conquer
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        var dummy = new ListNode(0);
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
