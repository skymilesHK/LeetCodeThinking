package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 685. Redundant Connection II
 * Hard
 *
 * 1033
 *
 * 241
 *
 * Add to List
 *
 * Share
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.
 *
 * Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * Output: [4,1]
 *
 *
 * Constraints:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 */
public class LeetCode685 {

    class UF {
        int[] parent;
        int[] h;

        public UF(int size) {
            parent = new int[size];
            h = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                h[i] = 1;
            }
        }

        public int getSize() {
            return parent.length;
        }

        public boolean union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return false;
            }

            if (h[pRoot] < h[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (h[pRoot] > h[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                h[qRoot]++;
            }
            return true;
        }

        public int find(int p) {
            if (p < 0 || p >= getSize()) {
                throw new IllegalArgumentException("p is out of bound");
            }

            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        // 入度
        int[] d = new int[n + 1];
        int hasTwoNode = -1;
        for (int[] edge : edges) {
            if (++d[edge[1]] == 2) {
                // 删除入读为2的点的两个边试试看，删除哪个以后，没有环
                hasTwoNode = edge[1];
                break;
            }
        }

        // 没有入度为2的点，直接判定circle就可以拿到需要删除的边
        if (hasTwoNode == -1) {
            return detectCircle(n, edges, null);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (edges[i][1] == hasTwoNode) {
                // 有入度为2的点，跳过(删除)当前边试试看，有没有circle
                if (detectCircle(n, edges, edges[i]) == null) {
                    return edges[i];
                }
            }
        }

        return new int[] {};
    }

    public int[] detectCircle(int n, int[][] edges, int[] skipEdge) {
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            if (Arrays.equals(edge, skipEdge)) {
                continue;
            }

            // 不能union,说明有环
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }
}
