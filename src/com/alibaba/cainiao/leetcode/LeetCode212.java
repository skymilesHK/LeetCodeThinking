package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 212. Word Search II
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class LeetCode212 {

    List<String> res = new ArrayList<>();
    int m = 0, n = 0;
    boolean[][] visited = null;
    Trie trie = new Trie();
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length; n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, "");
            }
        }

        return res.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(char[][] board, int row, int col, String path) {
        if (visited[row][col]) {
            return;
        }

        path += board[row][col];
        if (!trie.startsWith(path)) {
            return;
        }

        if (trie.search(path)) {
            res.add(path);
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = dx[i] + row;
            int y = dy[i] + col;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(board, x, y, path);
            }
        }
        visited[row][col] = false;
        // path不需要回溯，因为String每次dfs都是新deep copy的
    }

    class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children;

            public TrieNode() {
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        TrieNode root = null;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insertDFS(word, 0, root);
        }

        private void insertDFS(String word, int idxOfWord, TrieNode node) {
            if (idxOfWord == word.length()) {
                node.isWord = true;
                return;
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            insertDFS(word, idxOfWord + 1, node.children[ch - 'a']);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return searchDFS(word, 0, root);
        }

        private boolean searchDFS(String word, int idxOfWord, TrieNode node) {
            if (idxOfWord == word.length()) {
                return node.isWord;
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                return false;
            } else {
                return searchDFS(word, idxOfWord + 1, node.children[ch - 'a']);
            }
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWithDFS(prefix, 0, root);
        }

        private boolean startsWithDFS(String word, int idxOfWord, TrieNode node) {
            if (idxOfWord == word.length()) {
                return true;
            }
            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                return false;
            } else {
                return startsWithDFS(word, idxOfWord + 1, node.children[ch - 'a']);
            }
        }
    }
}
