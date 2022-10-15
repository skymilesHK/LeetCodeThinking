package com.alibaba.cainiao.acwing;

public class 链表归并排序 {

    // https://www.bilibili.com/video/BV1gx411R7QV/?from=search&seid=5487826975357080276&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2
    // merge sort
    // 6 5 3 1 8 7 2 4
    //      mid
    //

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidNode(head);
        ListNode secondHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l, ListNode r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p3 = dummy;
        ListNode p1 = l;
        ListNode p2 = r;
        while (p1 != null && p2 != null) {
            boolean b = p1.val < p2.val;
            p3.next = b ? p1 : p2;
            p3 = p3.next;

            p1 = b ? p1.next : p1;
            p2 = b ? p2 : p2.next;
        }

        p3.next = p1 != null ? p1 : p2;
        return dummy.next;
    }

    private ListNode getMidNode(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }
        ListNode slow = h;
        ListNode fast = h;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
