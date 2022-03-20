package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 第K短路 {

    static int N = 1009, M = 20009;
    static int n, m, S, T, K, idx;
    static int[] h = new int[N];
    static int[] rh = new int[N];   // 反向建图，用于dijkstra
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static Scanner in = new Scanner(System.in);

    // https://www.acwing.com/solution/content/41797/
    // https://www.acwing.com/solution/content/54738/
    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        Arrays.fill(rh, -1);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(h, a, b, c);
            add(rh, b, a, c);
        }
        S = in.nextInt();
        T = in.nextInt();
        K = in.nextInt();
        if (S == T) {
            K++;
        }

        dijkstra();
        System.out.println(aStar());
    }

    private static int aStar() {
        // 三维分别存 经过当前点的从起点到终点的路径的估计距离、起点到当前点的真实距离、节点号
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.x - b.x);
        pq.offer(new Tuple(dist[S] + 0, 0, S));     // 估价值 + 真实值，{真实值，编号}
        int cnt = 1; // 终点遍历几次,无解的话，返回 - 1

        if (dist[S] == 0x3f3f3f3f) {
            return -1;
        }

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int v = t.z;
            int d = t.y;
            if (v == T) {
                // 遍历一遍终点， cnt++，直到第K次
                if (cnt == K) {
                    return d;
                } else {
                    cnt++;
                }
            }

            // 正向扩展所有的边
            for (int i = h[v]; i != -1; i = next[i]) {
                int j = e[i];   // 新扩展的点j, 点i到点j的距离是w[i]
                // 起点到该点的真实距离+ 该点到终点的估价距离来作为标准
                pq.offer(new Tuple(d + w[i] + dist[j], d + w[i], j));
            }
        }

        return -1;
    }

    // 在反向图上dijkstra()，保存估价函数(dist[]距离)
    // dist存的是该点到终点的最小距离
    private static void dijkstra() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[T] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.x - b.x);
        pq.offer(new Pair(0, T));
        while (!pq.isEmpty()) {
            Pair t = pq.poll();

            int d = t.x;
            int v = t.y;
            if (st[v]) {
                continue;
            }

            st[v] = true;
            // 找到了距离最小的点t，并用最小的点t去更新其他的点到起点的距离
            for (int i = rh[v]; i != -1; i = next[i]) {
                int j = e[i];
                if (dist[j] > dist[v] + w[i]) {
                    dist[j] = dist[v] + w[i];
                    pq.offer(new Pair(dist[j], j));
                }
            }
        }
    }

    private static void add(int[]h, int a, int b, int c) {
        w[idx] = c;
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

    static class Pair {
        int x;  //距离值
        int y;  //点编号

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Tuple {
        int x;  // 当前点的从起点到终点的路径的估计距离
        int y;  // 起点到当前点的真实距离
        int z;  // 节点号

        public Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
