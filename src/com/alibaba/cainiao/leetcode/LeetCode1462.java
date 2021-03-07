package com.alibaba.cainiao.leetcode;

import java.util.*;

public class LeetCode1462 {

    int N = 101, n = 0;
    int[] h = new int[N];
    int[] next = new int[N + N];
    int[] e = new int[N + N];
    int[] d = null;             // 入度
    int[] res = null;           // 结果
    int idx = 0, resIdx = 0;
    Queue<Integer> q = null;

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        this.n = n;
        Arrays.fill(h, -1);
        d = new int[n + 1];
        res = new int[n];
        q = new ArrayDeque<>(n);

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            add(a, b);
            d[b]++;
        }

        boolean flag = topologicalSort();


        StringBuilder sb = new StringBuilder(res.length);
        for (int x : res) {
            sb.append(x);
        }

        List<Boolean> list = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            // a是不是b的前驱
            char a = (char) (query[0] + '0');
            char b = (char) (query[1] + '0');
            int idxA = sb.indexOf(a + "");
            int idxB = sb.indexOf(b + "");
        }
        return list;
    }

    private boolean topologicalSort() {
        //入度为0的点入队，v表示vertex
        for (int v = 0; v < n; v++) {
            if (d[v] == 0) {
                q.offer(v);
            }
        }

        while(!q.isEmpty()) {
            int t = q.poll();
            res[resIdx++] = t;
            for (int v = h[t]; v != -1; v = next[v]) {
                //遍历头节点的每一个出边,这里i表示出边节点下标
                // 出边的点j
                int j = e[v];
                if (--d[j] == 0) {
                    q.offer(j);
                }
            }

        }

        return resIdx == n;
    }

    private void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
