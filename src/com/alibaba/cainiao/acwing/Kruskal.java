package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    // https://www.acwing.com/solution/content/6345/
    // res记录最小生成树的树边权重之和,cnt记录的是全部加入到树的集合中边的数量(可能有多个集合)
    static int N = 100002, M = 200002, n = 0, m = 0, res = 0, cnt = 0, INF = 0x3f3f3f3f;
    static Edge[] edges = new Edge[M];
    static int[] parent = new int[N];
    static int[] h = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges, 0, m, (a, b) -> a.w - b.w);

        // init UF
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            h[i] = 1;
        }

        // 从小到大枚举所有边
        for (int i = 0; i < m; i++) {
            int a = edges[i].a;
            int b = edges[i].b;
            int w = edges[i].w;

            // a, b点是否联通
            if (!isConnected(a, b)) {
                res += w;
                cnt++;
                union(a, b);
            }
        }

        // 若cnt < n - 1表示不是联通图
        if (cnt < n - 1) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (h[pRoot] < h[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (h[pRoot] > h[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            h[qRoot]++;
        }
    }

    private static boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private static int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
