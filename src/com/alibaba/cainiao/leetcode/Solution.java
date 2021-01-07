package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "leetcode");
        int[] a = {1,0,0,0,1};
        int[][] b = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        LeetCode832 leetCode = new LeetCode832();
        leetCode.flipAndInvertImage(b);
    }

    // 本来完全没思路
    // https://leetcode-cn.com/problems/image-overlap/solution/javajie-fa-chao-ji-xiang-xi-de-jie-xi-by-coder_hez/
    public int largestOverlap(int[][] A, int[][] B) {
        List<Point> listA = new ArrayList<>(A.length * A.length), listB = new ArrayList<>(B.length * B.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                //将等于1的点添加进去。
                if (A[i][j] == 1) {
                    listA.add(new Point(i, j));
                }
                if (B[i][j] == 1) {
                    listB.add(new Point(i, j));
                }
            }
        }

        Set<Point> BSet = new HashSet(listB);

        int res = 0;
        Set<Point> seen = new HashSet();
        for (Point a : listA) {
            //对应A中每个1去与B中每个1去重合
            for (Point b : listB) {
                //这个delta可以理解为A中的点a要走到b这个点需要走多少。例如A中第一个1，走到B中第1个1
                //需要右移动1（b.x-a.x），向下移动1（b.y-a.y）。
                Point delta = new Point(b.x - a.x, b.y - a.y);
                //为了避免相同的位移。比如A中（0，1）处的1想到B中（1，2）处的1也是需要向右移动1，向下移动1
                //那么我们之前计算过一遍就不需要再计算一次了。
                if (!seen.contains(delta)) {
                    seen.add(delta);
                    int candi = 0;
                    //对于listA中的每个点都加上位移，去判断是否与B重合
                    for (Point pa : listA) {
                        if (BSet.contains(new Point(pa.x + delta.x, pa.y + delta.y))) {
                            candi++;
                        }
                    }
                    res = Math.max(res, candi);
                }
            }
        }

        return res;
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
