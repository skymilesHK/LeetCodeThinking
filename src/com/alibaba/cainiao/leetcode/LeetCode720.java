package com.alibaba.cainiao.leetcode;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2：
 *
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 *
 *
 * 提示：
 *
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 */
public class LeetCode720 {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        int maxLen = 0;
        String res = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int l = trie.searchLen(word);
            if (maxLen < l) {
                res = word;
                maxLen = l;
            }
        }

        return res;
    }

    class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children;
            public int len = 0;

            public TrieNode() {
                this.len = 0;
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        public TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insertDFS(word, 0, root, 0);
        }

        private void insertDFS(String word, int idxOfWord, TrieNode node, int l) {
            if (idxOfWord == word.length()) {
                node.isWord = true;
                node.len = l;
                return;
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            insertDFS(word, idxOfWord + 1, node.children[ch - 'a'], l + 1);
        }

        /**
         * Returns word len
         */
        public int searchLen(String word) {
            return searchLenDFS(word, 0, root);
        }

        private int searchLenDFS(String word, int idxOfWord, TrieNode node) {
            if (idxOfWord == word.length()) {
                if (node.isWord) {
                    return node.len;
                } else {
                    return 0;
                }
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                return 0;
            } else {
                return searchLenDFS(word, idxOfWord + 1, node.children[ch - 'a']);
            }
        }
    }
}
