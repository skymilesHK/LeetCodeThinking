package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 食物链 {

    static int N = 50009;
    static int n, m, res;
    static int[] parent = new int[N];
    static int[] dist = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        do {
            int t, x, y;
            t = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            if (x > n || y > n) {
                res++;
            } else {
                int rooX = find(x);
                int rooY = find(y);
                if (t == 1) {
                    // 同类

                } else {
                    // 吃
                }
            }
        } while (--m > 0);
    }

    static int find(int p) {
        if (p != parent[p]) {
            int t = find(parent[p]);                // 先把p的父节点及以上压缩到树根
            dist[p] = dist[p] + dist[parent[p]];    // 事实上，d[x]始终代表到父节点的距离，只不过在find之后x的父节点距离直接变成了到祖宗的距离
            parent[p] = t;                          // p节点也压缩到树根
        }
        return parent[p];
    }

    static void union(int p, int q) {
        int rooP = find(p);
        int rooQ = find(q);
        if (rooP == rooQ) {

        }
    }
}
