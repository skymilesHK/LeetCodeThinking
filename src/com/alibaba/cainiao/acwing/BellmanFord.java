package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author skymiles
 */
public class BellmanFord {

    static int N = 509, M = 10009, n = 1, m = 1, k = 1;
    static Edge[] edges = new Edge[M];
    static int[] dist = new int[N];
    static int[] backup = null;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        bellmanFord();
        if (dist[n] < 0x3f3f3f3f / 2) {
            System.out.println(dist[n]);
        } else {
            System.out.println("impossible");
        }
    }

    private static void bellmanFord() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        // 本来是迭代n个点，但是限制了 k 条边，所以写k
        for (int i = 1; i <= k; i++) {
            // System.arraycopy(dist, 0, backup, 0, dist.length);
            backup = dist.clone();
            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int c = edges[j].c;
                dist[b] = Math.min(dist[b], backup[a] + c);
            }
        }

    }
}

class Edge {
    int a;
    int b;
    int c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}