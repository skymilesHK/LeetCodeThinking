package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;

public class Solution {

    static int[][] b = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "leetcode");
        int[] a = {2,3,1,2,4,3};

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        LeetCode169 leetCode = new LeetCode169();
    }

    // https://www.acwing.com/video/1846/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 需要dummy
        var h1 = reverse(l1);
        var h2 = reverse(l2);
        var dummy = new ListNode(-1);
        int carry = 0;
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                carry += h1.val;
                h1 = h1.next;
            }

            if (h2 != null) {
                carry += h2.val;
                h2 = h2.next;
            }

            var cur = new ListNode(carry % 10);
            carry /= 10;

            //头插入
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var a = head;
        var b = head.next;
        var c = b;
        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        return a;
    }
}

class Trie {

    public class TrieNode {
        public boolean isWord;
        public TrieNode[] next;

        public TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }

        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return true;
    }

}
