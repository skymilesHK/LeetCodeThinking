package com.alibaba.cainiao.leetcode;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 *
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 *
 * 提示：
 *
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 */
public class LeetCode676 {

    Trie trie = null;

    /** Initialize your data structure here. */
    public LeetCode676() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String w : dictionary) {
            trie.insert(w);
        }
    }

    public boolean search(String searchWord) {
        return trie.replaceOneCharSearch(searchWord, 1);
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
            // 不能else
            insertDFS(word, idxOfWord + 1, node.children[ch - 'a']);
        }

        /** 只允许替换一个字符，进行进行存在性搜索 */
        public boolean replaceOneCharSearch(String word, int permitCnt) {
            return replaceOneCharSearchDFS(word, permitCnt, 0, root);
        }

        private boolean replaceOneCharSearchDFS(String word, int permitCnt, int idxOfWord, TrieNode node) {
            if (idxOfWord == word.length()) {
                return node.isWord && permitCnt == 0;
            }
            if (permitCnt < 0) {
                return false;
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                --permitCnt;
                if (permitCnt < 0) {
                    return false;
                } else {
                    // hello
                    // hhllo
                    for (int i = 0; i < 26; i++) {
                        if (node.children[i] != null && replaceOneCharSearchDFS(word, permitCnt, idxOfWord + 1, node.children[i])) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                return replaceOneCharSearchDFS(word, permitCnt, idxOfWord + 1, node.children[ch - 'a']);
            }

        }
    }
}
