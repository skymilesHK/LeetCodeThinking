package com.alibaba.cainiao.leetcode;

public class LeetCode421 {

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, trie.queryMaximumXOR(nums[i]));
        }
        return res;
    }

    class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children;

            public TrieNode() {
                isWord = false;
                children = new TrieNode[26];
            }
        }

        TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int x) {
            TrieNode cur = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (x >> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new TrieNode();
                }
                cur = cur.children[bit];
            }
        }

        public int queryMaximumXOR(int x) {
            TrieNode curr = root;
            int sum = 0;
            for (int i = 30; i >= 0; i--) {
                // 获取第i位bit值
                int bit = (x >> i) & 1;
                // 和bit位相反的,是否存在
                int reverseBit = bit ^ 1;
                // 有和bit位相反的分支
                if(curr.children[reverseBit] != null) {
                    // 转为10进制，相加
                    sum += (1 << i);
                    curr = curr.children[reverseBit];
                } else {
                    // 无和bit位相反的分支,则走相同bit值的分支
                    curr = curr.children[bit];
                }
            }

            return sum;
        }
    }
}
