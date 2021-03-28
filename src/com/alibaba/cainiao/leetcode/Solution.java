package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    int N = 101, M = 6001, idx = 0;
    int[] h;
    int[] e;
    int[] w ;
    int[] next;
    int[] dist;
    boolean[] st;
    Queue<Integer> q;

    public int networkDelayTime(int[][] times, int n, int k) {
        if (times.length == 0 || times[0].length == 0) {
            return 0;
        }
        q = new ArrayDeque<>(n);
        Arrays.fill(h, -1);
        h = new int[n];
        e = new int[n];
        w = new int[n];
        next = new int[times.length];
        dist = new int[n];
        st = new boolean[n];

        for (int i = 0; i < times.length; i++) {
            int a = times[i][0];
            int b = times[i][1];
            int c = times[i][2];
            add(a, b, c);
        }

        return spfa(n, k);
    }

    private int spfa(int n, int k) {
        Arrays.fill(dist, 0x3f3f3f);
        dist[k] = 0;
        st[k] = true;
        //声明一个队列保存更新过的节点
        Queue<Integer> q = new ArrayDeque<>(n);
        q.add(k);

        while (!q.isEmpty()) {
            // t是可能更小距离的点
            Integer t = q.poll();
            st[t] = false;

            // 更新可以更新的点
            for (int i = h[t]; i != -1; i = next[i]) {
                int j = e[i];
                //如果当前节点可以被更新，就做更新操作，并将该节点加入到队列中
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res >= 0x3f3f3f ? -1 : res;
    }

    private void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        next[idx] = h[a];
        h[a] = idx++;
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

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
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
