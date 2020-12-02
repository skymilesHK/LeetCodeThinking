package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BCG", "CDE", "GEA", "FFF");
    }


    int N = 10001;
    int M = 32001;
    int n = 0;
    int idx = 0;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] next = new int[M];
    int[] d = new int[N];
    Queue<Integer> q = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();

    // O(m+n)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Arrays.fill(h, -1);
        n = graph.length;
        // 反向建图
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                add(graph[i][j], i);
                d[i]++;
            }
        }

        topologicalSort();
        return res.stream().sorted().collect(Collectors.toList());
    }

    private void topologicalSort() {
        // 所有点入度为0 加入队列
        for (int v = 0; v < n; v++) {
            if (d[v] == 0) {
                q.offer(v);
                res.add(v);
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int k = 0; k < levelSize; k++) {
                Integer t = q.poll();
                for (int i = h[t]; i != -1; i = next[i]) {
                    // 从点t作为原点span的点j
                    int j = e[i];
                    if (--d[j] == 0) {
                        q.offer(j);
                        res.add(j);
                    }
                }
            }
        }
    }

    private void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
