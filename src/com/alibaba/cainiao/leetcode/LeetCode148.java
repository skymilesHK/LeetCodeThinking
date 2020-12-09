package com.alibaba.cainiao.leetcode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 */
public class LeetCode148 {
    // https://leetcode-cn.com/problems/sort-list/solution/gui-bing-pai-xu-he-kuai-su-pai-xu-by-a380922457/
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return;
        }

        var left = head;
        var cur = head.next;
        int pivot = head.val;
        while (cur != tail) {
            if (pivot > cur.val) {
                left = left.next;
                swap(cur, left);
            }
            cur = cur.next;
        }

        swap(head, left);
        quickSort(head, left);
        quickSort(left.next, tail);
    }

    private void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

}
