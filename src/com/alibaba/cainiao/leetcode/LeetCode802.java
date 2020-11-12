package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在有向图中，我们从某个结点和每个转向处开始，沿着图的有向边走。如果我们到达的结点是终点（即它没有连出的有向边），我们停止。
 *
 * 现在，如果我们最后能走到终点，那么我们的起始结点是 最终安全的。更具体地说，存在一个自然数 K，无论选择从哪里开始行走，我们必能在走了不到 K 步时停止在一个终点。
 *
 * 哪些结点最终是安全的？结果返回一个有序的数组。
 *
 * 该有向图有 N 个结点，标签为 0, 1, ..., N-1，其中 N 是 graph 的结点数。图以以下的形式给出：graph[i] 是结点 j 的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 样例
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 这里是上图的示意图。
 *
 * 提示
 * graph 结点数不超过 10000。
 * 图的边数不会超过 32000。
 * 每个 graph[i] 被排序为不同的整数列表，范围在区间 [0, graph.length - 1]。
 *
 */
public class LeetCode802 {

    int N = 10009;
    int M = 32009;
    int idx = 0;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] next = new int[M];
    int[] d = new int[N];

    // https://leetcode-cn.com/problems/find-eventual-safe-states/solution/tuo-bu-pai-xu-by-pen999/

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Arrays.fill(h, -1);
        int n = graph.length;
        Queue<Integer> q = new ArrayDeque<>(n);
        List<Integer> res = new ArrayList<>(n);

        // 建立反图
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                add(graph[i][j], i);
                d[i]++;
            }
        }

        // 0入度入队列
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int k = 0; k < levelSize; k++) {
                Integer t = q.poll();
                for (int i = h[t]; i != -1; i = next[i]) {
                    // t作为原点span的点j
                    int j = e[i];
                    if (--d[j] == 0) {
                        q.offer(j);
                        res.add(j);
                    }
                }
            }
        }

        return res.stream().sorted().collect(Collectors.toList());
    }

    private void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx;
        idx++;
    }

}
