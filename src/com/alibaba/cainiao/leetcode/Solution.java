package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

public class Solution {

    public boolean canPartition(int[] nums) {
        /**
         * ①状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于j是否成立，成立为true
         * ②状态转移方程(分类讨论)：
         *  a.不选择i位置的值：dp[i][j] = dp [i - 1][j]
         *  b.选择i位置的值:
         *      I.当j > nums[i]时, dp[i][j] = dp [i - 1][j] || dp [i - 1][j - nums[i]]
         *     II.当j = nums[i]时，dp[i][j] = true
         *    III.当j < nums[i]时, dp[i][j] = dp [i - 1][j] （dp [i - 1][j - nums[i]]不存在）
         */
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum为奇数，不符合题意，返回false
        if ((sum & 1) == 1) {
            return false;
        }
        //定义背包target
        int target = sum / 2;
        //定义dp
        boolean[][] dp = new boolean[len][target + 1];
        //初始化初值:第一行只有第1个数只能让容积为它自己的背包恰好装满
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        //开始填表[1,len - 1]
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    //对应两种情况：j<nums[i]和当前背包不选i
                    dp[i][j] = dp[i - 1][j];
                }
            }
            //判断是否需要提前结束计算
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
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
