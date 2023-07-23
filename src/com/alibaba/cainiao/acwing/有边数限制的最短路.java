package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 有边数限制的最短路 {

    // https://www.acwing.com/solution/content/14088/
    static int N = 501, M = 10001, n, m, k;
    static int INF = 0x3f3f3f3f;
    static int[] dist = new int[N];
    static int[] backup = new int[N];
    static Edge[] edges = new Edge[M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int t = bellmanFord();
        if (t == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }
    }

    private static int bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        // 不超过k条边
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist, N);
            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        if (dist[n] >= INF / 2) {
            return INF;
        }
        return dist[n];
    }

    static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
