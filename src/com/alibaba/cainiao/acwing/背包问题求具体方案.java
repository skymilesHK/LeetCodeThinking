package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 背包问题求具体方案 {
    // https://www.acwing.com/video/2805/
    static int N = 1009, V = 1009;
    static int n, m;
    static int[][] dp = new int[N][V];
    static int[] v = new int[N];
    static int[] w = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]);
                }
            }
        }

        // dp[1][V]是结果
        for (int i = 1, j = m; i <= n; i++) {
            if (j >= v[i] && dp[i + 1][j - v[i]] + w[i] >= dp[i + 1][j]) {
                System.out.println(i);
                j -= v[i];
            }
        }
    }
}
