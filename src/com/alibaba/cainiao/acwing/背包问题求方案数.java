package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 背包问题求方案数 {
    // https://www.acwing.com/solution/content/54273/
    static int N, V;
    static final int mod = (int) (1e9 + 7);
    static int[][] dp = new int[1001][1001];
    static int[][] g = new int[1001][1001];
    static int[] v = new int[1001];
    static int[] w = new int[1001];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        N = in.nextInt();
        V = in.nextInt();

        for (int i = 1; i <= N; ++i) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= V; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        g[0][0] = 1;
        for (int i = 1; i <= N; ++i) {
            g[i][0] = 1;
            for (int j = 0; j <= V; ++j) {
                if (dp[i][j] == dp[i - 1][j]) {
                    g[i][j] = (g[i][j] + g[i - 1][j]) % mod;
                }
                if (j >= v[i] && dp[i][j] == dp[i - 1][j - v[i]] + w[i]) {
                    g[i][j] = (g[i][j] + g[i - 1][j - v[i]]) % mod;
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= N; ++j) {
            if (dp[N][j] == dp[N][V]) {
                res = (res + g[N][j]) % mod;
            }
        }
        System.out.println(res);
    }
}
