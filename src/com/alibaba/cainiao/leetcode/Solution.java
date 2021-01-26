package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "leetcode");
        int[] a = {1,2,3};
        int[][] b = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        LeetCode713 leetCode = new LeetCode713();
        int circular = leetCode.numSubarrayProductLessThanK(a, 0);
    }

    // https://www.cnblogs.com/grandyang/p/8627783.html
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int N = 1000001;
        // index 是 两数距离差，value是两数距离差出现的次数
        int[] bucket = new int[N];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dis = Math.abs(nums[i] - nums[j]);
                ++bucket[dis];
            }
        }

        for (int i = 0; i < N; i++) {
            if (bucket[i] < k) {
                k -= bucket[i];
            } else {
                return i;
            }
        }
        return -1;
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
