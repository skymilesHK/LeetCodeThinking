package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // 输入：[5,0,3,8,6]
    // 输出：3
    // 解释：left = [5,0,3]，right = [8,6]
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        // left存储的一半是较为小的半边,leftMax是左半边最大的
        // right存储的较大的半边,rightMin是右边最小的
        int leftMax = A[0];
        int rightMin = A[0];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 说明要更新rightMin
            if (A[i] < rightMin) {
                rightMin = leftMax;
                index = i;
            }
            leftMax = Math.max(leftMax, A[i]);
        }

        return index + 1;
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
