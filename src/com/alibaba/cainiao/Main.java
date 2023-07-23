package com.alibaba.cainiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // https://www.acwing.com/solution/content/14088/
    static int N = 502, M = 10002, n, m, k;
    static int INF = 0x3f3f3f3f;
    static int[] dist = new int[N];
    static int[] backup;
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

        Arrays.fill(dist, INF);
        int t = bellmanFord();
        if (t == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }
    }

    private static int bellmanFord() {
        dist[1] = 0;
        // 不超过k条边
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist, N);
            // 遍历所有边
            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }

        if (dist[n] >= INF / 2) {
            return -1;
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

class UF {
    int[] parent;
    int[] h;

    public UF(int size) {
        parent = new int[size];
        h = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            h[i] = 1;
        }
    }

    public int getSize() {
        return parent.length;
    }

    public boolean union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return false;
        }

        if (h[pRoot] < h[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (h[pRoot] > h[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            h[qRoot]++;
        }
        return true;
    }

    public int find(int p) {
        if (p < 0 || p >= getSize()) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


