package com.alibaba.cainiao.leetcode;

/**
 * 147. Insertion Sort List
 * Sort a linked list using insertion sort.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Input:  4->2->1->3
        // Output: 1->2->3->4
        // dummy.next = head; 这题还有个地方，dummy先不和head相连，也是个边界
        var dummy = new ListNode(0);

        var pre = dummy;
        var cur = head;
        var next = cur.next;

        while (cur != null) {
            // 必须还原pre, 因为插入排序，想打牌洗牌一样，每次都要从最小开始对比，往后一个个比较，然后找位置插入
            pre = dummy;
            next = cur.next;

            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }

}
