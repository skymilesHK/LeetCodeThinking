package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    // https://www.acwing.com/video/1492/
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        Set<Integer> set = new HashSet<>(n);
        for (int x : nums) {
            set.add(x);
        }

        int res = 1;
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                // 一定要删除,防止重复枚举
                set.remove(x);
                int y = x;
                while (set.contains(y + 1)) {
                    y++;
                    // 一定要删除,防止重复枚举
                    set.remove(y);
                }
                res = Math.max(res, y - x + 1);
            }
        }
        return res;
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

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
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
