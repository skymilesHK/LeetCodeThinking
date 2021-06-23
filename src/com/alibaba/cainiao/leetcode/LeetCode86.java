package com.alibaba.cainiao.leetcode;

/**
 * 86. Partition List
 * Medium
 *
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class LeetCode86 {

    // https://www.acwing.com/video/1430/
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        var lowDummy = new ListNode(0);
        var highDummy = new ListNode(0);
        var p = head;
        var p1 = lowDummy;
        var p2 = highDummy;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }

        // 高的部分断开
        p2.next = null;
        p1.next = highDummy.next;
        return lowDummy.next;
    }

}
