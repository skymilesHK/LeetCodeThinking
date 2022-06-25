package com.alibaba.cainiao.acwing;


public class 单链表快速排序 {

    // https://www.bilibili.com/video/BV1HA411q7tH?p=1&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2
    public void quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        quickSort(head, cur);
    }

    void quickSort(ListNode l, ListNode r) {
        if (l == null || r == null || l == r) {
            return;
        }

        int pivot = l.val;
        ListNode i = l.next;
        ListNode j = l.next;
        ListNode pre = l;
        while (j != r.next) {
            if (j.val >= pivot) {
                j = j.next;
            } else {
                swap(i, j);
                pre = i;
                i = i.next;
                j = j.next;
            }
        }

        // 交换pivot(low每次都是pivot)
        swap(l, pre);
        quickSort(l, pre);
        quickSort(i, r);
    }

    void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
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
