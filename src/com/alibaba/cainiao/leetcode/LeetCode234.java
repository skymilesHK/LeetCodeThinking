package com.alibaba.cainiao.leetcode;

/**
 * 234. Palindrome Linked List
 * Easy
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class LeetCode234 {

    // https://www.acwing.com/video/1617/
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        var a = head;
        while (a != null) {
            n++;
            a = a.next;
        }

        if (n <= 1) {
            return true;
        }

        int half = n / 2;
        a = head;
        for (int i = 0; i < n - half - 1; i++) {
            a = a.next;
        }
        var b = a.next;
        var c = b;
        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        var p = head;
        var q = a;
        for (int i = 0; i < half; i++) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

}
