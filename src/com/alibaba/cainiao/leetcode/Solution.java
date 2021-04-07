package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // https://www.youtube.com/watch?v=gOycoA8pOqg
    public String shiftingLetters(String S, int[] shifts) {
        // shifts [3,5,9]
        int[] postSum = new int[shifts.length];
        int sum = 0;
        for (int i = shifts.length - 1, idx = i; i >= 0 && idx >= 0; i--, idx--) {
            sum = shifts[i] % 26;
            if (idx == shifts.length - 1) {
                postSum[idx] = sum;
            } else {
                postSum[idx] = postSum[idx + 1] + sum;
            }
        }

        // S = "abc", postSum = [17,14,9], S的长度和shifts，postSum长度一样
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < S.length(); i++) {
            sb.setCharAt(i, (char) ((sb.charAt(i) - 'a' + postSum[i]) % 26 + 'a'));
        }

        return sb.toString();
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
