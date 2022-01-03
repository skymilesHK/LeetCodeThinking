package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {
    static int N = 55;
    static int[][][] dp = new int[N * 2][N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] w = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = in.nextInt();
            }
        }

        for (int k = 2; k <= m + n; k++) {
            for (int i1 = Math.max(1, k - m); i1 <= Math.min(k - 1, n); i1++) {
                for (int i2 = Math.max(1, k - m); i2 <= Math.min(k - 1, n); i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;

                    int t = w[i1][j1];
                    if (i1 != i2) {
                        t += w[i2][j2];   //若路径不重合
                    }
                    int x = dp[k][i1][i2];
                    x = Math.max(x, dp[k - 1][i1 - 1][i2 - 1] + t);
                    x = Math.max(x, dp[k - 1][i1 - 1][i2] + t);
                    x = Math.max(x, dp[k - 1][i1][i2 - 1] + t);
                    x = Math.max(x, dp[k - 1][i1][i2] + t);
                    dp[k][i1][i2] = x;
                }
            }
        }
        System.out.println(dp[n + m][n][n]);
    }


}