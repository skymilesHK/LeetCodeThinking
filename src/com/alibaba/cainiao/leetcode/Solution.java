package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "leetcode");
        int[] a = {2,3,1,2,4,3};
        int[][] b = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        LeetCode169 leetCode = new LeetCode169();
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int start = 0, end = n - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }

        return Math.min(nums[start], nums[end]);
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
