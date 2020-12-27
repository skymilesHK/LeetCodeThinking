package com.alibaba.cainiao.leetcode;

/**
 * 745. 前缀和后缀搜索
 * 给定多个 words，words[i] 的权重为 i 。
 *
 * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
 *
 * 例子:
 *
 * 输入:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // 返回 0
 * WordFilter.f("b", "") // 返回 -1
 * 注意:
 *
 * words的长度在[1, 15000]之间。
 * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
 * words[i]的长度在[1, 10]之间。
 * prefix, suffix的长度在[0, 10]之前。
 * words[i]和prefix, suffix只包含小写字母。
 */
public class LeetCode745 {

    Trie trie = new Trie();

    public LeetCode745(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            String key = "{" + words[i];
            trie.insert(key, i);
            for (int j = 0; j < w.length(); ++j) {
                // apple, len = 5, e,l,p,p,a
                // 前缀+'{'+key
                // _apple
                // e_apple
                // le_apple
                key = w.charAt(w.length() - 1 - j) + key;
                trie.insert(key, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return trie.startsWithPrefix(suffix + "{" + prefix);
    }

    class Trie {

        public class TrieNode {
            public boolean isWord;
            public TrieNode[] next;
            public int index;

            public TrieNode() {
                index = -1;
                isWord = false;
                next = new TrieNode[27];
            }
        }

        TrieNode root = null;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word, int index) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (cur.next[idx] == null) {
                    cur.next[idx] = new TrieNode();
                }
                cur = cur.next[idx];
                // Update index
                cur.index = index;
            }
            cur.isWord = true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public TrieNode startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (cur.next[idx] == null) {
                    break;
                }
                cur = cur.next[idx];
            }
            return cur;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public int startsWithPrefix(String prefix) {
            TrieNode n = startsWith(prefix);
            if (n == null) {
                return -1;
            } else {
                return n.index;
            }
        }
    }

}
