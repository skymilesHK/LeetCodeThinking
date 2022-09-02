package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class Floyd求最短路 {

    static int N = 201, M = 20001, n, m, k, INF = 0x3f3f3f3f;
    // g[i, j]表示从i走到j的路径上除i和j点外只经过 1到k的点的所有路径的最短距离。
    static int[][] g = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    g[i][j] = INF;
                }
            }
        }

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        floyd();

        while (k-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(g[a][b] >= INF / 2 ? "impossible" : g[a][b]);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    g[i][j] = Math.max(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
