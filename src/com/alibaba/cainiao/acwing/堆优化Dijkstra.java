package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 堆优化Dijkstra {

    static int N = 150001, INF = 0x3f3f3f3f;
    static int n, m, idx;
    static int[] h = new int[N];                //稀疏图一般使用邻接表
    static int[] e = new int[N];
    static int[] next = new int[N];
    static int[] dist = new int[N];             //记录每个节点距离起点的距离
    static int[] w = new int[N];                //边权重
    static boolean[] st = new boolean[N];
    static PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.x, b.x));
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        Arrays.fill(h, -1);
        do {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
        } while (--m > 0);

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        // 1. d距离数组初始化,d[1]=0,第一个节点是1开始，不是0开始
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair t = pq.poll();
            int v = t.y;
            int d = t.x;
            if (st[v]) {
                continue;
            }

            // 加入到pq集合中
            st[v] = true;
            // 找到v的所有领边，用v更新其他点的距离
            for (int i = h[v]; i != -1; i = next[i]) {
                // j是邻点
                int j = e[i];
                if (dist[j] > d + w[i]) {
                    dist[j] = d + w[i];
                    pq.offer(new Pair(dist[j], j));
                }
            }
        }
        // 如果起点到达不了n号节点，则返回-1
        if (dist[n] >= INF) {
            return -1;
        }
        // 返回起点距离n号节点的最短距离
        return dist[n];
    }

    // 添加一条a->b的边
    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        next[idx] = h[a];
        h[a] = idx++;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
