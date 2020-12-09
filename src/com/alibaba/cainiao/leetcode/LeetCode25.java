package com.alibaba.cainiao.leetcode;

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        var dummy = new ListNode(-1);
        dummy.next = head;
        var p = dummy;
        while (p != null) {
            var q = p;
            for (int i = 0; i < k && q != null; i++) {
                q = q.next;
            }

            if (q == null) {
                break;
            }

            var a = p.next;
            var b = a.next;
            for (int i = 0; i < k - 1; i++) {
                var c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            var z = p.next;
            p.next = a;
            z.next = b;
            p = z;
        }

        return dummy.next;
    }

}
