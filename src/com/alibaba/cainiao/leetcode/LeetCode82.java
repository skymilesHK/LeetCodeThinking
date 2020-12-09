package com.alibaba.cainiao.leetcode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Medium
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class LeetCode82 {

    // 根据定义做, head节点可能会被跳过，所以需要dummy
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var dummy = new ListNode(-1);
        dummy.next = head;

        var pre = dummy;
        var cur = head;

        while (cur != null) {
            // curr指针一直判断重复，向后移动
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

}
