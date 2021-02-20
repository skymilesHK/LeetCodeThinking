package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;

public class Solution {

    public static void main(String[] args) {
        // creating tree map
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
//        treemap.put(6, "six");
        treemap.put(5, "five");

        System.out.println("Checking floor entry for 6");
        System.out.println("Value is: "+ treemap.floorEntry(6));
    }

    // https://leetcode-cn.com/problems/nth-magical-number/solution/er-fen-shuang-wai-wai-by-zzxn/
    // https://www.acwing.com/solution/content/582/   gcd,lcm操作
    long mod = (long) (1E9 + 7);
    public int nthMagicalNumber(int n, int a, int b) {
        if (a > b) {
            return nthMagicalNumber(n, b, a);
        }

        long lcm = (long) a * b / gcd(a, b);
        long start = 1, end = lcm * n, mid = 1;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (check(mid, a, b, lcm) >= n) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (check(start, a, b, lcm) <= n) {
            return (int) (start / mod);
        } else {
            return (int) (end / mod);
        }
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    private long check(long mid, long a, long b, long lcm) {
        // 小于等于i的神奇数字数量
        return mid / a + mid / b - mid / lcm;
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
