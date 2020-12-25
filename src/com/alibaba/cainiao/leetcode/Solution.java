package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hi", "helo");
        LeetCode526 leetCode = new LeetCode526();
        int[] a = {3,5,9};
        leetCode.countArrangement(3);
    }

}

class Trie {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] next;

        public TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        dfsInsert(word, cur, 0);
    }

    private void dfsInsert(String word, TrieNode node, int u) {
        if (u == word.length()) {
            node.isWord = true;
            return;
        }

        char ch = word.charAt(u);
        if (node.next[ch - 'a'] == null) {
            node.next[ch - 'a'] = new TrieNode();
        }

        dfsInsert(word, node.next[ch - 'a'], u + 1);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        return dfsSearch(word, curr, 0);
    }

    private boolean dfsSearch(String word, TrieNode node, int u) {
        if (u == word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(u);
        if (node.next[ch - 'a'] == null) {
            return false;
        } else {
            return dfsSearch(word, node.next[ch - 'a'], u + 1);
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        return dfsStartsWith(prefix, curr, 0);
    }

    private boolean dfsStartsWith(String prefix, TrieNode node, int u) {
        if (u == prefix.length()) {
            return true;
        }

        char ch = prefix.charAt(u);
        if (node.next[ch - 'a'] == null) {
            return false;
        } else {
            return dfsStartsWith(prefix, node.next[ch - 'a'], u + 1);
        }
    }


    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode cur = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            if (cur.next[ch - 'a'] == null) {
//                cur.next[ch - 'a'] = new TrieNode();
//            }
//
//            cur = cur.next[ch - 'a'];
//        }
//        if (!cur.isWord) {
//            cur.isWord = true;
//        }
//    }

    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TrieNode cur = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            if (cur.next[ch - 'a'] == null) {
//                return false;
//            }
//            cur = cur.next[ch - 'a'];
//        }
//
//        return cur.isWord;
//    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode cur = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            char ch = prefix.charAt(i);
//            if (cur.next[ch - 'a'] == null) {
//                return false;
//            }
//            cur = cur.next[ch - 'a'];
//        }
//
//        return true;
//    }
}
