package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 310. 最小高度树
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 * 示例 2:
 *
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * 输出: [3, 4]
 * 说明:
 *
 *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class LeetCode310 {

    List<Integer> res = null;
    int idx = 0;
    // 对于每个点k，开一个单链表，存储k所有可以走到的点。h[k]存储这个单链表的头结点
    int[] h = new int[20001];
    int[] next = new int[20001];
    int[] e = new int[20001];
    // 入度
    int[] d = new int[20001];
    Queue<Integer> q = null;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        res = new ArrayList<>(n);
        if (n == 1) {
            res.add(0);
            return res;
        }

        Arrays.fill(h, -1);

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            add(a, b);
            add(b, a);
            d[a]++;
            d[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>(n);
        // 这里v是节点的值
        for (int v = 0; v < n; v++) {
            if (d[v] == 1) {
                q.offer(v);
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for (int k = 0; k < levelSize; k++) {
                Integer t = q.poll();
                list.add(t);
                //遍历头节点的每一个出边,这里i表示出边节点下标
                for (int i = h[t]; i != -1; i = next[i]) {
                    // j表示节点的值
                    int j = e[i];
                    //出边能到达的节点，入度减1
                    //如果结点j，入度为0则入队
                    if (--d[j] == 1) {
                        q.offer(j);
                    }
                }
            }

            res = list;
        }
        return res;
    }

    private void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

}
