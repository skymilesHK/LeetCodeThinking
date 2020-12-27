package com.alibaba.cainiao.leetcode;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 */
public class LeetCode677 {

    Trie trie = null;

    /** Initialize your data structure here. */
    public LeetCode677() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.sum(trie.lastNode(prefix));
    }

    class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children;
            public int val;

            public TrieNode() {
                this.val = 0;
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        public TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word, int value) {
            insertDFS(word, 0, root, value);
        }

        private void insertDFS(String word, int idxOfWord, TrieNode node, int value) {
            if (idxOfWord == word.length()) {
                node.isWord = true;
                node.val = value;
                return;
            }

            char ch = word.charAt(idxOfWord);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            insertDFS(word, idxOfWord + 1, node.children[ch - 'a'], value);
        }

        /**
         * 找到Trie中匹配该前缀的最后一个节点
         */
        public TrieNode lastNode(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return null;
                }
                cur = cur.children[index];
            }
            return cur;
        }

        /**
         * 从匹配到前缀的最后一个节点开始,继续递归搜索,找到单词就将值累加
         */
        public int sum(TrieNode node) {
            if (node == null) {
                return 0;
            }

            int sum = 0;
            if (node.isWord) {
                sum += node.val;
            }

            for (TrieNode child : node.children) {
                sum += sum(child);
            }

            return sum;
        }
    }
}
