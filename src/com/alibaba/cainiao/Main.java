package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int N = 205, INF = 0x3f3f3f3f;
    static int dist[][] = new int[N][N];
    static int n, m, q;

    static void flody() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            dist[a][b] = Math.min(dist[a][b], c);
        }
        flody();
        while (q-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(dist[a][b] > INF / 2 ? "impossible" : dist[a][b]);
        }
    }
}