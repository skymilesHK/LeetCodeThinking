package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 摘花生 {

    static int N = 101;
    static int T, n, m;
    static int[][] dp = new int[N][N];
    static int[][] w = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        do {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    w[i][j] = in.nextInt();
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + w[i][j];
                }
            }

            System.out.println(dp[n][m]);
        } while (--T > 0);
    }

}
