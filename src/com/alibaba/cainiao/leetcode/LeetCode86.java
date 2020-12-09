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
        if (head == null) {
            return null;
        }

        var ldummy = new ListNode(-1);
        var rdummy = new ListNode(-1);
        //设置两个指针，分别是两个链表的尾指针
        var lt = ldummy;
        var rt = rdummy;
        var cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lt.next = cur;
                lt = lt.next;
            } else {
                rt.next = cur;
                rt = rt.next;
            }
            cur = cur.next;
        }

        //两个链表首尾相连
        lt.next = ldummy.next;
        rt.next = null;
        return ldummy.next;
    }

}
