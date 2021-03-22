package com.alibaba.cainiao.leetcode;

/**
 * 924. 尽量减少恶意软件的传播
 * 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。
 *
 * 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
 *
 * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
 *
 * 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
 *
 * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播而受到感染。
 *
 *
 *
 * 示例 1：
 *
 * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * 输出：0
 * 示例 2：
 *
 * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 < graph.length = graph[0].length <= 300
 * 0 <= graph[i][j] == graph[j][i] <= 1
 * graph[i][i] == 1
 * 1 <= initial.length < graph.length
 * 0 <= initial[i] < graph.length
 */
public class LeetCode924 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        // size是点的数目
        int size = graph.length;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        // <!-- 這一步就是先找孤立的老大 -->
        int[] virCounter = new int[size];
        for (int v: initial) {
            virCounter[uf.find(v)]++;
        }

        int res = size - 1;
        int resSize = 0;
        for (int vir : initial) {
            int virRoot = uf.find(vir);
            // 只能阻断一个联通分量含有一个病毒的情况
            if (virCounter[virRoot] == 1) {
                int virRootSize = uf.getSize(virRoot);
                if (virRootSize > resSize) {
                    resSize = virRootSize;
                    res = vir;
                } else if (virRootSize == resSize) {
                    res = Math.min(res, vir);
                }
            }
        }

        if (res == size - 1) {
            for (int v : initial) {
                res = Math.min(res, v);
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;   // 每个点的父亲节点
        int[] rank;     // 按秩合并
        int[] size;     // 每个联通分量的size
        int cnt;        // 合并后有几个联通分量

        public UnionFind(int N) {
            parent = new int[N];
            rank = new int[N];
            size = new int[N];
            cnt = N;

            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = 1;
                size[i] = 1;
            }
        }

        // 这里必须调用者保证点是parent节点
        public int getSize(int parent) {
            return size[parent];
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
                size[qRoot] += size[pRoot];
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
