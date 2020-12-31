package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "leetcode");
        int[] a = {1,1,2};
        int[] b = {9};
        LeetCode66 leetCode = new LeetCode66();
        System.out.println(leetCode.plusOne(b));
    }

    // https://blog.csdn.net/linhuanmars/article/details/24389549
    // http://www.cnblogs.com/springfor/p/3884034.html (参考 int len = rootIndex - inStart;这段代码)
    // https://www.bilibili.com/video/av61190561 (这段讲解)

    private HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    private int n = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = inorder.length;
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 先序遍历的从左数第一个为整棵树的根节点
        int rootVal = preorder[preStart];
        // 先序的第一个是root, 通过map获取下标
        int inRootIndex = inOrderMap.get(rootVal);
        // 记录左子树的长度, 维护区间
        int leftLen = inRootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIndex - 1);
        root.right = dfs(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
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
