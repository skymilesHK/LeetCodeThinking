package com.alibaba.cainiao.leetcode;

/**
 * 143. Reorder List
 * Medium
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class LeetCode143 {

    // https://www.acwing.com/solution/LeetCode/content/240/     文字表述
    // 给定 1->2->3->4->5, 变成 1->5->2->4->3
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        int n = 0;
        var cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        if (n <= 2) {
            return;
        }

        var mid = head;
        // 左边链表多一个,n/2上取整 == n+1/2下取整
        for (int i = 0; i < (n + 1) / 2 - 1; i++) {
            mid = mid.next;
        }

        // a是后半部分的第一个节点, b是后半部分的第二个节点
        var a = mid.next;
        var b = a.next;
        var c = b.next;
        mid.next = null;
        // a一定要断开
        a.next = null;

        // 后半部分反转
        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        // b是前半部分的第一个节点, a是后半部分的头节点
        b = head;
        while (a != null) {
            ListNode bn = b.next;
            b.next = a;
            b = bn;
            ListNode an = a.next;
            a.next = b;
            a = an;
        }

    }

}
