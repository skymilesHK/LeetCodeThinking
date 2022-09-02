package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 有向图的拓扑序列 {

    // https://www.acwing.com/solution/content/13530/
    static int N = 100001, M = 100001, n, m;
    static int idx, resIdx;
    static int[] h = new int[N];
    static int[] next = new int[M];
    static int[] e = new int[M];
    static int[] d = new int[M];   // 入度
    static int[] res = null;       // 结果
    static Queue<Integer> q = new ArrayDeque<>(N);
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        res = new int[n];
        Arrays.fill(h, -1);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            d[b]++;
        }

        if (topologicalSort()) {
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean topologicalSort() {
        // 这里v是节点的值
        for (int v = 1; v <= n; v++) {
            if (d[v] == 0) {
                q.offer(v);
            }
        }

        while (!q.isEmpty()) {
            // 队列不空，则取出头节点
            int t = q.poll();
            res[resIdx++] = t;
            // 遍历头节点的每一个出边,这里i表示出边节点下标
            for (int i = h[t]; i != -1; i = next[i]) {
                // j表示节点的值
                int j = e[i];
                //出边能到达的节点，入度减1
                //如果结点j，入度为0则入队
                if (--d[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return resIdx == n;
    }

    // 添加一条边a->b
    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
