package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hi", "helo");
        LeetCode848 leetCode = new LeetCode848();
        int[] a = {3,5,9};
        leetCode.shiftingLetters("abc", a);
    }

    /**
     * 1. 判断井字棋是否合法, 那么把每个条件都细化为逻辑来判断
     * 2. 可以根据 X赢 或 O赢分为4中情况讨论
     *     2.1 X赢了, O没赢: x先手, 所以此时合法情况是 x 比 o 多一个
     *     2.2 X没赢, O赢了: x先手, 所以此时合法情况是 x 与 o 相等
     *     2.3 X没赢, O没赢: 中间情况 0 <= count(x) - count(o) <= 1
     *     2.4 X赢了, O赢了: 必定非法
     *
     * 3. 怎么判断有没有人赢: 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
     *
     * https://www.acwing.com/solution/content/10721/
     * https://www.bilibili.com/video/BV1wZ4y1u7ew?from=search&seid=7834459577974549367
     */
    public boolean validTicTacToe(String[] board) {
        int xCnt = 0, oCnt = 0;
        for (String row : board) {
            char[] rowChars = row.toCharArray();
            for (char ch : rowChars) {
                if (ch == 'X') {
                    xCnt++;
                } else if (ch == 'O') {
                    oCnt++;
                }
            }
        }

        int diff = xCnt - oCnt;
        boolean xIsWinner = isWinner('X', board);
        boolean oIsWinner = isWinner('O', board);

        if (xIsWinner && !oIsWinner) {
            return diff == 1;
        }
        if (oIsWinner && !xIsWinner) {
            return diff == 0;
        }
        if (!xIsWinner && !oIsWinner) {
            return 0 <= diff && diff <= 1;
        }
        return false;
    }

    private boolean isWinner(char p, String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }

        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }

        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }

        return false;
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
