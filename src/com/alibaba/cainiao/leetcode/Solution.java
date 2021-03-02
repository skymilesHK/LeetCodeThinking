package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    // https://www.youtube.com/watch?v=5a_AlfATYEU
    public String orderlyQueue(String S, int K) {
        if (S.length() >= 2) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        return S;
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
