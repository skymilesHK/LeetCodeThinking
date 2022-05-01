package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    // https://www.acwing.com/solution/content/6345/

    static int N = 100009, M = 200009, n = 0, m = 0, res = 0, cnt = 0;
    static Edge[] edges = new Edge[M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        // 读入m条边
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            // 一定要取min，因为可能有重复边，但是权重不一样
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges, 0, m);

        UF uf = new UF(n + 1);
        for (int i = 0; i < m; i++) {
            int a = edges[i].a;
            int b = edges[i].b;
            int w = edges[i].w;
            if (uf.union(a, b)) {
                res += w;
                cnt++;
            }
        }

        // 若cnt < n - 1表示不是联通图
        if (cnt < n - 1) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

    static class UF {
        int[] parent;
        int[] h;

        public UF(int sz) {
            parent = new int[sz];
            h = new int[sz];

            for (int i = 0; i < sz; i++) {
                parent[i] = i;
                h[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return parent[x];
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
    }
}
