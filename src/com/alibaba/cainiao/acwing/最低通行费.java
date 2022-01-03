package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最低通行费 {
    static int N = 101;
    static int[][] dp = new int[N][N];          // 从起点出发，走到第i行第j列的所有方案
    static int[][] w = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = w[i][j];
                } else {
                    dp[i][j] = 0x3f3f3f3f;
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + w[i][j]);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + w[i][j]);
                    }
                }
            }
        }

        System.out.printf("%d\n", dp[n][n]);
    }
}
